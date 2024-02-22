package giadung.webmvc.service.impl;


import java.util.List;

import giadung.webmvc.dao.CategoryDao;
import giadung.webmvc.dao.impl.CategoryDaoImpl;
import giadung.webmvc.model.Catalog;
import giadung.webmvc.model.Product;
import giadung.webmvc.service.CategoryService;

public class CategoryServicesImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDaoImpl();

	
	public void insert(Catalog category) {
		categoryDao.insert(category);
	}

	
	public void edit(Catalog newCategory) {
		Catalog oldCate = categoryDao.get(Integer.parseInt(newCategory.getId()));
		oldCate.setName(newCategory.getName());
		categoryDao.edit(oldCate);

	}

	
	public void delete(String id) {
		categoryDao.delete(id);

	}

	
	public Catalog get(int id) {
		return categoryDao.get(id);
	}

	
	public Catalog get(String name) {
		return categoryDao.get(name);
	}

	
	public List<Catalog> getAll() {
		return categoryDao.getAll();
	}
	
	
	public List<Catalog> getCateByProduct(int id) {
		return categoryDao.getCateByProduct(id);
	}

}