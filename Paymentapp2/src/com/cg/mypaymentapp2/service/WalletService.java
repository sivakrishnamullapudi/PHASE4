package com.cg.mypaymentapp2.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.mypaymentapp2.beans.Customer;
import com.cg.mypaymentapp2.beans.Wallet;

public interface WalletService {

	Customer createAccount(String name, String number, BigDecimal amount) throws Exception;

	Customer showBalance(String mobileno) ;

	Customer fundTransfer(String sourceMobileNo, String targetMobileNo,
			BigDecimal amount) throws Exception;

	Customer depositAmount(String mobileNo, BigDecimal amount1) throws Exception;

	Customer withdrawAmount(String mobileNo1, BigDecimal amount2) throws Exception;

	List<Customer> showBalance();
	
}
