package giadung.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import giadung.webmvc.jdbc.connectDB;
import giadung.webmvc.model.User;

public class LoginDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public User checkLogin(String username, String password) {
		try {
			String query = "select * from users where username = ? AND password = ?";
			new connectDB();
			conn = connectDB.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String created = rs.getString(7);
				String role = rs.getString(8);
				User user = new User(id, name, email, phone, username, password, created, role);
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
