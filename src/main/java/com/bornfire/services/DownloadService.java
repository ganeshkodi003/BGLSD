package com.bornfire.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
public class DownloadService {
	private static final Logger logger = LoggerFactory.getLogger(DownloadService.class);
	
	
	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	SessionFactory sessionFactory;

	
	//DOWNLOAD FUNCTION FOR ACCOUNT STATEMENT
 
	public File getFileAcccount_Ledger(String filetype, String acct_num) 
			throws FileNotFoundException, JRException, SQLException,IllegalArgumentException {
		
	    String path = env.getProperty("output.exportpath");
	    System.out.println(path);

	    String fileName = "";
	    File outputFile;

	    logger.info("Getting Output file : Month");

	    fileName = "ACCOUNT LEDGER -" + acct_num ;

	    try {
	        InputStream jasperFile;
	        
			if (filetype.equals("Excel")) {
				System.out.println("inner pdf");
					jasperFile = this.getClass()
							.getResourceAsStream("/static/JASPER/AccountLedgerStatement.jrxml");
				}else {
				
					jasperFile = this.getClass()
							.getResourceAsStream("/static/JASPER/AccountLedgerStatement.jrxml");
				
			}
	        if (jasperFile == null) {
	            throw new FileNotFoundException("Jasper file not found");
	        }
	        JasperReport jr = JasperCompileManager.compileReport(jasperFile);
	        HashMap<String, Object> map = new HashMap<>();
	        map.put("Account_Number", acct_num);
	       
	        System.out.println(acct_num);
	            //for excel code
	           if ("pdf".equals(filetype)) {
	               fileName = fileName + ".pdf";
	           } else {
	               fileName = fileName + ".xlsx";
	           }

	           path = path + fileName;
	            if ("pdf".equals(filetype)) {
	                logger.info("Generating PDF...");
	                JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
	                JasperExportManager.exportReportToPdfFile(jp, path);
	                logger.info("PDF generated successfully");
	            } else {
	                logger.info("Generating XLSX...");
	                JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
	                JRXlsxExporter exporter = new JRXlsxExporter();
	                exporter.setExporterInput(new SimpleExporterInput(jp));
	                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
	                exporter.exportReport();
	                logger.info("XLSX generated successfully");
	            }
	        

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        throw e; // Rethrow the exception for higher-level handling
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new JRException("Error generating Jasper report", e);
	    }

	    outputFile = new File(path);
	    return outputFile;

	}

}
