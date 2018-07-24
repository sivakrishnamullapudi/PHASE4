package com.cg.mypaymentapp2.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp2.beans.Customer;
import com.cg.mypaymentapp2.beans.Wallet;
import com.cg.mypaymentapp2.daoservices.WalletDAOservices;
import com.cg.mypaymentapp2.exception.InsufficientBalanceException;
import com.cg.mypaymentapp2.exception.InvalidInputException;

@Component(value="walletServices")
public class WalletServiceImpl implements WalletService{

	@Autowired
	private WalletDAOservices daoservice;

	@Transactional
	@Override
	public Customer createAccount(String name, String mobileNo, BigDecimal amount) throws Exception 
	{
	
		
		Customer customer1=null;
		
		String pattern="[1-9][0-9]{9}";
		if(!mobileNo.matches(pattern))
		{
			throw new InvalidInputException("Mobile number should contain 10 digits only, no alphabets");
			
		}
		
		
		if(daoservice.findOne(mobileNo)!=null)
		{
			throw new InvalidInputException("Account Exists");
		}
		
		
		if((amount.compareTo(new BigDecimal(0)))>0)
		{
		customer1=new Customer(name, mobileNo, new Wallet(amount));
		// saving to hashmap
		if(daoservice.save(customer1) != null)
		{
			return customer1;
		}
		return customer1;}
		
		else
		{
			throw new InvalidInputException("Amount has to be > 0");
		}
	}
	
	
	
	@Override
	public Customer showBalance(String mobileNo) throws InvalidInputException
	{
		Customer customer=daoservice.findOne(mobileNo);
		if(customer!=null)
			return customer;
		else
			throw new InvalidInputException("Mobile number doesn't exist");
	}
	
	
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount)throws Exception
	{
		
		Customer source=daoservice.findOne(sourceMobileNo);
		Customer target=daoservice.findOne(targetMobileNo);
		if((source==null||target==null)||(sourceMobileNo.equals(targetMobileNo)))
			throw new InvalidInputException("source or target number is invalid");
			
		if((amount.compareTo(new BigDecimal(0)))<0)
		{
			throw new InvalidInputException("Amount >0");
		}
		else {
	
		if(source!=null&&target!=null&&(source.getWallet().getBalance().compareTo(amount))>=0)
		{
			BigDecimal amount1=target.getWallet().getBalance().add(amount);
			target.setWallet(new Wallet(amount1));
			daoservice.save(target);
			
			amount1=source.getWallet().getBalance().subtract(amount);
			source.setWallet(new Wallet(amount1));
			daoservice.save(source);

		return source;
		}
		else 
			throw new InsufficientBalanceException(" fund amount amount should not be greater than balance");
		}
		
	}
	
	
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount)throws Exception
	{
		Customer customer=daoservice.findOne(mobileNo);
		if(customer!=null)
		{
			if((amount.compareTo(new BigDecimal(0)))>0)
			{
				BigDecimal amount1=customer.getWallet().getBalance().add(amount);
			customer.setWallet(new Wallet(amount1));
			if(daoservice.save(customer) != null)
			{
				return customer;
			}
			}
			else throw new 	InvalidInputException("deposit amount >0");
		}
		else
			throw new InvalidInputException("Mobile number doesn't exist");
	
		return null;
	}
	

	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws Exception
	{
		Customer customer=daoservice.findOne(mobileNo);
		if(customer!=null)
		{
			if((amount.compareTo(new BigDecimal(0)))>0)
			{
				int i=customer.getWallet().getBalance().compareTo(amount);
			if(i>=0)
			{
				BigDecimal amount1=customer.getWallet().getBalance().subtract(amount);
				customer.setWallet(new Wallet(amount1));
				if(daoservice.save(customer) != null)
				{
					return customer;
				}
			}		
			else
				throw new InsufficientBalanceException("withdrawal amount can't be greater than balance");
			}
			else throw new 	InvalidInputException("withdraw amount >0");
	}
		else
		throw new InvalidInputException("Mobile number doesn't exist ");
		return null;
}



	@Override
	public List<Customer> showBalance() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}