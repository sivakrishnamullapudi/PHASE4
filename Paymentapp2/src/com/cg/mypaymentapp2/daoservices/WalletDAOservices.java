package com.cg.mypaymentapp2.daoservices;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mypaymentapp2.beans.Customer;

public interface WalletDAOservices extends JpaRepository<Customer, String>{

	}

