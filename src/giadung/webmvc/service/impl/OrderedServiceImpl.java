package giadung.webmvc.service.impl;

import java.util.List;

import giadung.webmvc.dao.OrderedDao;
import giadung.webmvc.dao.impl.OrderedDaoImpl;
import giadung.webmvc.model.Ordered;
import giadung.webmvc.service.OrderedService;

public class OrderedServiceImpl implements OrderedService{
	OrderedDao orderDao = new OrderedDaoImpl();
	
	public void insert(Ordered ordered) {
		orderDao.insert(ordered);
	}

	
	public void edit(Ordered ordered) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	
	public Ordered get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Ordered get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Ordered> getAll() {
		return orderDao.getAll();
	}


	public List<String> getIdPro() {
		return orderDao.getIdPro();
	}

}
