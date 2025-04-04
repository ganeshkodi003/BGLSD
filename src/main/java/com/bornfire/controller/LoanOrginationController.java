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
	
	
	
}
