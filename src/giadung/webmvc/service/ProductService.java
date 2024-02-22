package giadung.webmvc.service;

import java.util.List;

import giadung.webmvc.model.Product;
public interface ProductService {
	void insert(Product product);

	void edit(Product product);

	void delete(String id);

	Product get(int id);
	
	Product get(String name);

	List<Product> getAll();
	
	List<Product> getProductById(int id);

	// List<Product> searchByName(String productName);

	List<Product> getProductByIdCate(int idCate);
	int getTotalProduct();
	public List<Product> getAllpt(int sizePage,int index);
	int getTotalProductsearch(String keyword);
	List<Product> searchByNamept(String keyword,int sizePage,int index);

	List<Product> getAllProductSale(int sizePage,int index);
	List<Product> getAll(int id,int sizePage,int index);
}

