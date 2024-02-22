package giadung.webmvc.dao;

import java.util.List;

import giadung.webmvc.model.Ordered;

public interface OrderedDao {
	void insert(Ordered ordered); 
	 
	void edit(Ordered ordered); 
	
	void delete(String id); 
 
	Ordered get(int id); 
	 
	Ordered get(String name); 
 
	List<Ordered> getAll();

	List<String> getIdPro();
}
