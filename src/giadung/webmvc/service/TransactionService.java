package giadung.webmvc.service;

import java.util.ArrayList;
import java.util.List;

import giadung.webmvc.model.Transactions;

public interface TransactionService {
	void insert(Transactions transaction);
	 
	void edit(Transactions transaction); 

	void delete(String id); 
 
	Transactions get(int id); 
	 
	Transactions get(String name); 
 
	List<Transactions> getAll();

	ArrayList<Transactions> getAllUser(String username);

	void setStatus(int id); 

}
