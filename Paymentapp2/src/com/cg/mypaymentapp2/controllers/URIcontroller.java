package com.cg.mypaymentapp2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mypaymentapp2.beans.Customer;

@Controller
public class URIcontroller {
	

	@RequestMapping("/")
	public String getHomePage() {
		return "indexpage";
	}
	
	@RequestMapping("/indexpage")
	public String getindexpage() {
		return "indexpage";
	}
	
	@RequestMapping("/createaccount")
	public String getRegistrationPage() {
		return "createaccountpage";
	}

	@RequestMapping("/showbalance")
	public String getbalancepage() {
		return "showpage";
	}
	
	@RequestMapping("/Deposit")
	public String deposit() {
		return "depositamount";
	}
	@RequestMapping("/Withdraw")
	public String withdraw() {
		return "withdrawamount";
	}
	
	@RequestMapping("/FundTransfer")
	public String transfer() {
		return "transferpage";
	}
	
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}

	

}
