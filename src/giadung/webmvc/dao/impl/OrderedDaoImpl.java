package giadung.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import giadung.webmvc.dao.OrderedDao;
import giadung.webmvc.jdbc.connectDB;
import giadung.webmvc.model.Ordered;

public class OrderedDaoImpl implements OrderedDao{

	
	public void insert(Ordered ordered) {
		String sql = "INSERT INTO ordered(product_id, transaction_id,qty) VALUES (?, ?, ?)";
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ordered.getProduct_id());
			ps.setInt(2, Integer.parseInt(ordered.getTransaction_id()));
			ps.setInt(3, ordered.getQty());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		List<Ordered> ordereds = new ArrayList<Ordered>();
		String sql = "SELECT * FROM ordered";
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Ordered ordered = new Ordered();
				ordered.setId(rs.getString("id"));
				ordered.setProduct_id(rs.getString("product_id"));
				ordered.setTransacsion_id(rs.getString("transaction_id"));
				ordered.setQty(Integer.parseInt(rs.getString("qty")));
				ordereds.add(ordered);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordereds;
	}

	public List<String> getIdPro() {
		List<String> namenhieu = new ArrayList<String>();
		String sql = "SELECT product_id, COUNT(*) AS soluong FROM ordered GROUP BY product_id ORDER BY soluong DESC;";
		Connection con = connectDB.getConnect();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("product_id");
				namenhieu.add(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return namenhieu;
	}

}
