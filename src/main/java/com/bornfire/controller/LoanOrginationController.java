package com.bornfire.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bornfire.entities.BLMS_PERSONALDET_REPO;
import com.bornfire.entities.BLMS_PERSONAL_LOAN_ENTITY;
import com.bornfire.entities.BLMS_VEHICLEDET_REPO;
import com.bornfire.entities.BLMS_VEHICLE_DET_ENTITY;
import com.bornfire.entities.Chart_Acc_Entity;
import com.bornfire.entities.CustomerRequest;
import com.bornfire.entities.DMD_TABLE;
import com.bornfire.entities.DepositEntity;
import com.bornfire.entities.Lease_Loan_Work_Entity;
import com.bornfire.entities.TRAN_MAIN_TRM_WRK_ENTITY;
import com.bornfire.entities.Td_defn_table;



@Controller
@ConfigurationProperties("default")
public class LoanOrginationController {
	private static final Logger logger = LoggerFactory.getLogger(CustOnboardinController.class);
	
	@Autowired
	BLMS_PERSONALDET_REPO blms_PERSONALDET_REPO;
	
	@Autowired
	BLMS_VEHICLEDET_REPO bLMS_VEHICLEDET_REPO;
	
	
	@RequestMapping(value = "RetailloanApproval", method = { RequestMethod.GET, RequestMethod.POST })
	public String Retailloan(@RequestParam(required = false) String formmode,
    Model md, HttpServletRequest req,@RequestParam(required = false) String id) {
		String userid = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("menu", "BAJHeaderMenu");

		if (formmode == null || formmode.equals("tab")) {
			md.addAttribute("formmode", "tab");
			
		}else if (formmode.equals("listForPersonal")) {
			md.addAttribute("formmode", "listForPersonal");
		}else if (formmode.equals("ApprovalPersonalView")) {
			md.addAttribute("formmode", "ApprovalPersonalView");
			md.addAttribute("personal", blms_PERSONALDET_REPO.getRefNo(id));
		}
		return "Loan_Origintation/RETAIL_LOANAPPROVAL";
	}

	@RequestMapping(value = "approvefuncloan", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, String> approvefuncs(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String ApprefNO,
			HttpServletRequest rq, @RequestParam(required = false) String reject_remarks,
			@RequestParam(required = false) String hold_remarks) {
		String user = (String) rq.getSession().getAttribute("USERID");
		String msg = "";
		String username = (String) rq.getSession().getAttribute("USERNAME");
		SimpleDateFormat compDate = new SimpleDateFormat("dd-MM-yyyy");
		String Date = compDate.format(new Date());
		BLMS_PERSONAL_LOAN_ENTITY up = blms_PERSONALDET_REPO.getRefNo(ApprefNO);
		if (formmode.equals("approveAcc")) {
			up.setVerify_flg("Y");
			up.setVerify_time(new Date());
			up.setVerify_user(user);

			msg += "Reference No: " + ApprefNO + "<br>";
			msg += "Approved Name: " + username + " <br>";
			msg += "Approved Date: " + Date + " ";

		} else if (formmode.equals("Holdfin")) {
			/*
			 * up.setStatus("HOLD"); up.getCa_preferred_name(); SimpleDateFormat compDate =
			 * new SimpleDateFormat("dd-MM-yyyy"); String ComplianceDate =
			 * compDate.format(new Date()); up.setHold_remarks(hold_remarks);
			 * up.setVerify_time(new Date()); up.setVerify_user(user);
			 * bACP_CUS_PROFILE_REPO.save(up); msg = "Reference No: " + ApprefNO +
			 * " has been moved to HOLD LIST ";
			 */

		} else if (formmode.equals("Reject_acc")) {
			/*
			 * CustomerRequest up = bACP_CUS_PROFILE_REPO.findByref_norec(ApprefNO, rec_no);
			 * up.setStatus("REJECT"); up.getCa_preferred_name();
			 * 
			 * up.setVerify_time(new Date()); up.setVerify_user(user); SimpleDateFormat
			 * compDate = new SimpleDateFormat("dd-MM-yyyy"); String ComplianceDate =
			 * compDate.format(new Date()); up.setReject_remarks(reject_remarks);
			 * bACP_CUS_PROFILE_REPO.save(up); msg = "Reference No: " + ApprefNO +
			 * "  Rejected";
			 */
		}

		else {

			msg = "Error Occured!!!";
		}

		Map<String, String> response = new HashMap<>();
		response.put("message", msg);
		return response;

	}
	

@RequestMapping(value = "RetailloanMaintanence", method = { RequestMethod.GET, RequestMethod.POST })
	public String RetailloanMaintanence(@RequestParam(required = false) String formmode,@RequestParam(required = false) String id,
			Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("menu", "BAJHeaderMenu");

		if (formmode == null || formmode.equals("tab")) {
			md.addAttribute("formmode", "tab");

		} else if (formmode.equals("listForPersonal")) {
			md.addAttribute("formmode", "listForPersonal");
		} 
		else if (formmode.equals("listForVehicle")) {
			md.addAttribute("formmode", "listForVehicle");
		}
		else if (formmode.equals("ApprovalPersonalView")) {
			md.addAttribute("formmode", "ApprovalPersonalView");
			md.addAttribute("personal", blms_PERSONALDET_REPO.getRefNo(id));
		}
			else if (formmode.equals("ApprovalVehicleView")) {
			md.addAttribute("formmode", "ApprovalVehicleView");
		 md.addAttribute("Vehicle", bLMS_VEHICLEDET_REPO.getRefNo(id));
		}
		return "Loan_Origintation/Maintanence";
	}
	
	
	
}
