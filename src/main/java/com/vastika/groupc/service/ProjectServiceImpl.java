package com.vastika.groupc.service;

import java.util.List;

import com.vastika.groupc.dao.ProjectDao;
import com.vastika.groupc.dao.ProjectDaoImpl;
import com.vastika.groupc.model.Customer;

public class ProjectServiceImpl implements ProjectService{
	
	ProjectDao projectDao= new ProjectDaoImpl();

	@Override
	public int updateInfo(Customer customer) {
		return projectDao.updateInfo(customer);
	}

	@Override
	public int deposit(long id, double amount) {
		return projectDao.deposit(id, amount);
	}

	@Override
	public int withdraw(long id, double amount) {
		return projectDao.withdraw(id, amount);
	}

	@Override
	public double checkBalance(long id) {
		return projectDao.checkBalance(id);
	}

	@Override
	public int openAccount(Customer customer) {
		return projectDao.openAccount(customer);
	}

	@Override
	public boolean verifyCustomer(long id, String password) {
		
		return projectDao.verifyCustomer(id, password);
	}

	@Override
	public List<Double> getTransactions(long id) {
		return projectDao.getTransactions(id);
	}

	@Override
	public boolean doesExist(long id) {
		return projectDao.doesExist(id);
	}

	@Override
	public Customer getCustomer(long id) {
		return projectDao.getCustomer(id);
	}

	

}
