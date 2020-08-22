package com.vastika.groupc.dao;

import java.util.List;

import com.vastika.groupc.model.Customer;

public interface ProjectDao {
	
	int updateInfo(Customer customer);
	int deposit(long id, double amount);
	int withdraw(long id, double amount);
	double checkBalance(long id);
	int openAccount(Customer customer);
	boolean verifyCustomer(long id, String password);
	List<Double> getTransactions(long id);
	
	boolean doesExist(long id);
	Customer getCustomer(long id );
	
	
}
