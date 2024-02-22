package giadung.webmvc.dao;

import java.util.List;

import giadung.webmvc.model.Product;

public interface ProductDao {
	void insert(Product product);

	void edit(Product product);

	void delete(String id);

	Product get(int id);
	
	Product get(String name);

	List<Product> getAll();
	List<Product> getAll(int id,int sizePage,int index);
	List<Product> getProductById(int id);

//	List<Product> searchByName(String productName);
	
	int getTotalProduct();
	
	public List<Product> getAllpt(int sizePage,int index);

	int getTotalProductsearch(String keyword);
	List<Product> searchByNamept(String keyword,int sizePage,int index);
	
	List<Product> getAllProductSale(int sizePage,int index);
}
