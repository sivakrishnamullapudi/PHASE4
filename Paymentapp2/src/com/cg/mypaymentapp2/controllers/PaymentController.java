package com.cg.mypaymentapp2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mypaymentapp2.beans.Customer;
import com.cg.mypaymentapp2.exception.InvalidInputException;
import com.cg.mypaymentapp2.service.WalletService;

@Controller
public class PaymentController {
	
	@Autowired(required=true)
	private WalletService walletServices;
	
	@PostMapping("/register")
	public ModelAndView registerFaculty(@ModelAttribute("customer") Customer customer) throws InvalidInputException {
		try {
			customer =walletServices.createAccount(customer.getName(), customer.getMobileNo(), customer.getWallet().getBalance());
			ModelAndView modelAndView = new ModelAndView("registrationSuccessPage", "customer", customer);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("errorPage");
	}
	
	@RequestMapping("/display")
	public ModelAndView getDetails(@ModelAttribute("customer") Customer customer) throws Exception
	{
		customer=walletServices.showBalance(customer.getMobileNo());
		ModelAndView mav=new ModelAndView("showbalance","customer",customer);
		return mav;
	}
	
	@RequestMapping("/deposit")
	public ModelAndView deposit(@ModelAttribute("customer") Customer customer) throws Exception
	{
		customer=walletServices.depositAmount(customer.getMobileNo(),customer.getWallet().getBalance());
		ModelAndView mav=new ModelAndView("update","customer",customer);
		return mav;
	}
	
	@RequestMapping("/withdrawamt")
	public ModelAndView withdrawal(@ModelAttribute("customer") Customer customer) throws Exception
	{
		customer=walletServices.withdrawAmount(customer.getMobileNo(),customer.getWallet().getBalance());
		ModelAndView mav=new ModelAndView("update","customer",customer);
		return mav;
	}
	
	@RequestMapping("/transferamt")
	public ModelAndView transfer(@ModelAttribute("customer") Customer customer) throws Exception
	{
		customer=walletServices.withdrawAmount(customer.getMobileNo(),customer.getWallet().getBalance());
		ModelAndView mav=new ModelAndView("update","customer",customer);
		return mav;
	}
	
	
	
	
	
	
	
	
}
