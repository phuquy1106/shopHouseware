package giadung.webmvc.dao;
import java.util.ArrayList;
import java.util.List;

import giadung.webmvc.model.Transactions;


public interface TransactionDao {
	void insert(Transactions transaction); 
	 
	void edit(Transactions admin); 
	
	void delete(String id); 
 
	Transactions get(int id); 
	 
	Transactions get(String name); 
 
	List<Transactions> getAll();

	ArrayList<Transactions> getAllUser(String username);

	void setStatus(int id); 
	
	
}
