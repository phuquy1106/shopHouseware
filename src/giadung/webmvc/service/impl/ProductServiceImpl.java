package giadung.webmvc.service.impl;


import java.util.List;

import giadung.webmvc.dao.ProductDao;
import giadung.webmvc.dao.impl.ProductDaoImpl;
import giadung.webmvc.model.Product;
import giadung.webmvc.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();

	
	public void insert(Product product) {
		productDao.insert(product);
	}

	
	public void edit(Product newProduct) {
		Product oldProduct = productDao.get(Integer.parseInt(newProduct.getId()));
		oldProduct.setName(newProduct.getName());
		oldProduct.setCatalog_id(newProduct.getCatalog_id());
		oldProduct.setStatus(newProduct.getStatus());
		oldProduct.setPrice(newProduct.getPrice());
		oldProduct.setDescription(newProduct.getDescription());
		oldProduct.setContent(newProduct.getContent());
		oldProduct.setDiscount(newProduct.getDiscount());
		oldProduct.setImage_link(newProduct.getImage_link());
		oldProduct.setCreated(newProduct.getCreated());

		productDao.edit(oldProduct);

	}

	
	public void delete(String id) {
		productDao.delete(id);

	}

	
	public Product get(int id) {
		return productDao.get(id);
	}

	
	public Product get(String name) {
		return productDao.get(name);
	}

	
	public List<Product> getAll() {
		return productDao.getAll();
	}

	
	public List<Product> getProductById(int id) {
		return productDao.getProductById(id);
	}
	
	
//	public List<Product> searchByName(String productName) {
//		return productDao.searchByName(productName);
//	}

	
	public List<Product> getProductByIdCate(int idCate) {
		// TODO Auto-generated method stub
		return null;
	}


	public int getTotalProduct() {
		// TODO Auto-generated method stub
		return productDao.getTotalProduct();
	}


	public List<Product> getAllpt(int sizePage, int index) {
		// TODO Auto-generated method stub
		return productDao.getAllpt(sizePage, index);
	}


	public int getTotalProductsearch(String keyword) {
		// TODO Auto-generated method stub
		return productDao.getTotalProductsearch(keyword);
	}


	public List<Product> searchByNamept(String keyword, int sizePage, int index) {
		// TODO Auto-generated method stub
		return productDao.searchByNamept(keyword, sizePage, index);
	}


	

	public List<Product> getAllProductSale(int sizePage, int index) {
		// TODO Auto-generated method stub
		return productDao.getAllProductSale( sizePage,  index);
	}


	public List<Product> getAll(int id, int sizePage, int index) {
		// TODO Auto-generated method stub
		return productDao.getAll(id,sizePage,index);
	}



}