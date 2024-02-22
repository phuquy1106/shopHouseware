package giadung.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import giadung.webmvc.dao.ProductDao;
import giadung.webmvc.jdbc.connectDB;
import giadung.webmvc.model.Product;

import java.sql.ResultSet;

public class ProductDaoImpl  implements ProductDao {

	
	public void insert(Product product) {
		String sql = "INSERT INTO product(catalog_id, name, price, status, description, content, discount, image_link, created) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getCatalog_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getPrice());
			ps.setString(4, product.getStatus());
			ps.setString(5, product.getDescription());
			ps.setString(6, product.getContent());
			ps.setString(7, product.getDiscount());
			ps.setString(8, product.getImage_link());
			ps.setString(9, product.getCreated());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void edit(Product product) {
		String sql = "UPDATE product SET name = ?, catalog_id = ?, price = ?, status = ?, description = ?, content = ?, discount = ?, image_link = ? WHERE id = ?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getCatalog_id());
			ps.setString(3, product.getPrice());
			ps.setString(4, product.getStatus());
			ps.setString(5, product.getDescription());
			ps.setString(6, product.getContent());
			ps.setString(7, product.getDiscount());
			ps.setString(8, product.getImage_link());
			ps.setString(9, product.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void delete(String id) {
		String sql = "DELETE FROM product WHERE id = ?";
		new connectDB();
		Connection conn = connectDB.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public Product get(int id) {
		String sql = "SELECT * FROM product WHERE id = ? ";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				return product;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Product get(String name) {
		Product product = null;
		String sql = "SELECT * FROM product WHERE name = ? ;";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				product = new Product();

				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product ORDER BY discount DESC;";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	
	public List<Product> getProductById(int id) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE catalog_id=?";
		Connection conn = connectDB.getConnect();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	

	
//	public List<Product> searchByName(String keyword) {
//		List<Product> productList = new ArrayList<Product>();
//		String sql = "SELECT * FROM product WHERE name LIKE ? ";
//		Connection conn = connectDB.getConnect();
//
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, "%" + keyword + "%");
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				Product product = new Product();
//				product.setId(rs.getString("id"));
//				product.setCatalog_id(rs.getString("catalog_id"));
//				product.setName(rs.getString("name"));
//				product.setPrice(rs.getString("price"));
//				product.setStatus(rs.getString("status"));
//				product.setDescription(rs.getString("description"));
//				product.setContent(rs.getString("content"));
//				product.setDiscount(rs.getString("discount"));
//				product.setImage_link(rs.getString("image_link"));
//				product.setCreated(rs.getString("created"));
//				productList.add(product);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return productList;
//	}


	public int getTotalProduct() {
		String sql = "SELECT COUNT(*) FROM product";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
			 return	rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	public List<Product> getAllpt(int sizePage,int index) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product ORDER BY discount DESC LIMIT ? OFFSET ?;";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sizePage);
			ps.setInt(2, ((index-1)*sizePage));
			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	
	public int getTotalProductsearch(String keyword) {
		String sql = "SELECT COUNT(*) FROM product WHERE name LIKE ? ";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
			 return	rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public List<Product> searchByNamept(String keyword,int sizePage,int index) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE name LIKE ? LIMIT ? OFFSET ? ";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ps.setInt(2, sizePage);
			ps.setInt(3, ((index-1)*sizePage));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}





	public List<Product> getAllProductSale(int sizePage, int index) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE discount>0 ORDER BY id DESC LIMIT ? OFFSET ?;";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sizePage);
			ps.setInt(2, ((index-1)*sizePage));
			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}


	public List<Product> getAll(int id, int sizePage, int index) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE catalog_id = ? LIMIT ? OFFSET ?;";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, sizePage);
			ps.setInt(3, ((index-1)*sizePage));
			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	

}
