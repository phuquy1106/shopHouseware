package giadung.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import giadung.webmvc.dao.ReviewDao;
import giadung.webmvc.jdbc.connectDB;
import giadung.webmvc.model.Review;

public class ReviewDaoImpl  implements ReviewDao {

	
	public void insert(Review review) {
		String sql = "INSERT INTO review(product_id,  name, email, content, created) VALUES (?, ?, ?, ?, ?)";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, review.getProduct_id());
			ps.setString(2, review.getName());
			ps.setString(3, review.getEmail());
			ps.setString(4, review.getContent());
			ps.setString(5, review.getCreated());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void edit(Review review) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(int id) {
		String sql = "DELETE FROM review WHERE id=?";
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public Review get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Review get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Review> getAll() {
		List<Review> reviews = new ArrayList<Review>();
		String sql = "SELECT * FROM review";
		Connection con = connectDB.getConnect();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Review review = new Review();
				review.setId(rs.getString("id"));
				review.setName(rs.getString("name"));
				review.setEmail(rs.getString("email"));
				review.setProduct_id(rs.getString("product_id"));
				review.setContent(rs.getString("content"));
				review.setCreated(rs.getString("created"));
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviews;
	}
	
	
	public List<Review> getReviewById(int id)
	{
		List<Review> reviews = new ArrayList<Review>();
		String sql = "SELECT * FROM review WHERE product_id=?";
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Review review = new Review();
				review.setId(rs.getString("id"));
				review.setName(rs.getString("name"));
				review.setEmail(rs.getString("email"));
				review.setProduct_id(rs.getString("product_id"));
				review.setContent(rs.getString("content"));
				review.setCreated(rs.getString("created"));
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviews;
	}

}
