package com.bornfire.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ConfigurationProperties("default")
public class LoanOrginationController {
	private static final Logger logger = LoggerFactory.getLogger(CustOnboardinController.class);
	
	
	@RequestMapping(value = "RetailloanApproval", method = { RequestMethod.GET, RequestMethod.POST })
	public String Retailloan(@RequestParam(required = false) String formmode,
    Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		md.addAttribute("menu", "BAJHeaderMenu");

		if (formmode == null || formmode.equals("tab")) {
			md.addAttribute("formmode", "tab");
			
		} else if (formmode.equals("ModifyHead")) {
			md.addAttribute("formmode", "ModifyHead");
		} 
		return "Loan_Origintation/APPROVAL";
	}
}
