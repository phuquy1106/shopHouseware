package giadung.webmvc.service;

import java.util.List;

import giadung.webmvc.model.Ordered;

public interface OrderedService {
	void insert(Ordered ordered); 
	 
	void edit(Ordered ordered); 

	void delete(String id); 
 
	Ordered get(int id); 
	 
	Ordered get(String name); 
 
	List<Ordered> getAll();

	List<String> getIdPro(); 
 
}
