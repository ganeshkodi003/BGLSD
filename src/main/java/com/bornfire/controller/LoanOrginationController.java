package com.bornfire.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bornfire.entities.BLMS_PERSONALDET_REPO;
import com.bornfire.entities.BLMS_PERSONAL_LOAN_ENTITY;
import com.bornfire.entities.CustomerRequest;

@Controller
@ConfigurationProperties("default")
public class LoanOrginationController {
	private static final Logger logger = LoggerFactory.getLogger(CustOnboardinController.class);
	
	@Autowired
	BLMS_PERSONALDET_REPO blms_PERSONALDET_REPO;
	
	
	@RequestMapping(value = "RetailloanApproval", method = { RequestMethod.GET, RequestMethod.POST })
	public String Retailloan(@RequestParam(required = false) String formmode,
    Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("menu", "BAJHeaderMenu");

		if (formmode == null || formmode.equals("tab")) {
			md.addAttribute("formmode", "tab");
			
		}else if (formmode.equals("listForPersonal")) {
			md.addAttribute("formmode", "listForPersonal");
		}
		return "Loan_Origintation/APPROVAL";
	}
	
	
	/* SURIYA */
	@GetMapping("AllApprovedPersonal")
	public List<BLMS_PERSONAL_LOAN_ENTITY> AllApproved(@RequestParam(required = false) String tran_id) {
		return blms_PERSONALDET_REPO.getApprovelist();
	}

	@GetMapping("ApprovedPersonal")
	public List<BLMS_PERSONAL_LOAN_ENTITY> Approved(@RequestParam(required = false) String tran_id,
			@RequestParam(required = false) String part_tran_id) {
		return blms_PERSONALDET_REPO.getapproved();
	}

	@GetMapping("NotApprovedPersonal")
	public List<BLMS_PERSONAL_LOAN_ENTITY> NotApproved(@RequestParam(required = false) String tran_id,
			@RequestParam(required = false) String part_tran_id) {
		return blms_PERSONALDET_REPO.getnotapproved();
	}
}
