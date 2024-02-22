package giadung.webmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import giadung.webmvc.dao.TransactionDao;
import giadung.webmvc.dao.impl.TransactionDaoImpl;

import giadung.webmvc.model.Transactions;
import giadung.webmvc.service.TransactionService;

public class TransactionServicesImpl implements TransactionService{
	TransactionDao transactionDao = new TransactionDaoImpl();
	 
	public void insert(Transactions transaction) { 
		transactionDao.insert(transaction); 
	} 
	
	
	
	public void edit(Transactions transaction) {
		Transactions oldTransaction = transactionDao.get(transaction.getId());		
		oldTransaction.setUser_name(transaction.getUser_name());
		oldTransaction.setUser_mail(transaction.getUser_mail());
		oldTransaction.setUser_phone(transaction.getUser_phone());
		oldTransaction.setAddress(transaction.getAddress());
		oldTransaction.setMessage(transaction.getMessage());
		oldTransaction.setAmount(transaction.getAmount());
		oldTransaction.setPayment(transaction.getPayment());
		oldTransaction.setStatus(transaction.getStatus());
		transactionDao.edit(oldTransaction);
	} 
	
	
	 
	public void delete(String id) { 
		transactionDao.delete(id); 
 
	} 
 
	 
	public Transactions get(int id) { 
		return transactionDao.get(id); 
	} 
 
	 
	public Transactions get(String name) { 
		return transactionDao.get(name); 
	} 
 
	 
	public List<Transactions> getAll() { 
		return transactionDao.getAll(); 
	}



	public ArrayList<Transactions> getAllUser(String username) {
		return transactionDao.getAllUser(username);
	}



	public void setStatus(int id) {
		transactionDao.setStatus(id);
		
	}	
 

}
