package giadung.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import giadung.webmvc.dao.IbannerDao;
import giadung.webmvc.jdbc.connectDB;
import giadung.webmvc.model.Banner;

public class BannerDaoImpl  implements IbannerDao{


	public void insert(Banner banner) {
		String sql = "INSERT INTO banner(name,note,img) VALUES (?,?,?)"; 
		new connectDB(); 
		Connection con = connectDB.getConnect(); 
 
		try { 
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1, banner.getName()); 
			ps.setString(2, banner.getNote()); 
			ps.setString(3, banner.getImg()); 
			ps.executeUpdate(); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		
	}


	public void delete(int id) {
		String sql = "Delete from banner where id=?";
		new connectDB();
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}


	public void edit(Banner banner) {
		String sql = "UPDATE banner SET name=?,note=?,img=? where id = ?";
		Connection con = connectDB.getConnect();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, banner.getName());
			ps.setString(2, banner.getNote()); 
			ps.setString(3, banner.getImg()); 
			ps.setString(4, banner.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public List<Banner> getAll() {
		List<Banner> banners = new ArrayList<Banner>(); 
		String sql = "SELECT * FROM banner"; 
		Connection conn = connectDB.getConnect(); 
 
		try { 
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery(); 
 
			while (rs.next()) { 
				Banner banner = new Banner(); 
 
				banner.setId(rs.getString("id")); 
				banner.setName(rs.getString("name")); 
				banner.setNote(rs.getString("note")); 
				banner.setImg(rs.getString("img")); 
				banners.add(banner); 
			} 
 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
 
		return banners; 
	}

	
	public Banner get(int id) {

		String sql = "SELECT * FROM banner WHERE id = ?";
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {	
				Banner banner = new Banner();
				banner.setId(rs.getString("id"));
				banner.setName(rs.getString("name")); 
				banner.setNote(rs.getString("note")); 
				banner.setImg(rs.getString("img"));
				return banner;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
