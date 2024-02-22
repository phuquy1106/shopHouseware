package giadung.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import giadung.webmvc.dao.UserDao;
import giadung.webmvc.jdbc.connectDB;
import giadung.webmvc.model.User;

import java.sql.ResultSet;

public class UserDaoImpl  implements UserDao {
	
	
	public void insert(User user) {
		String sql = "INSERT INTO users(name,email,phone,username,password,created,role) VALUES (?, ?, ?, ?, ?, ?, ?)";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6,user.getCreated());
			ps.setString(7, user.getRole());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void delete(int id) {
		String sql = "DELETE FROM users where id = ?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public User get(String username) {
		User user = new User();
		String sql = "select * from users where username=?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
				user.setRole(rs.getString("role"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return user;
	}

	
	public User get(int id) {
		User user = new User();
		String sql = "select * from users where id=?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
				user.setRole(rs.getString("role"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return user;
	}
	
	
	public void edit(User user) {	
		String sql = "Update users set name=?, email=?, phone=? where id=?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setInt(4,user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<User> getAll() {		
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return users; 
	}


	public int editpass(User user) {
		int result = 0;
		String sql = "Update users set users.password=? where users.username=?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println(user.getPassword() + user.getUsername());
			ps.setString(1, user.getPassword());
			ps.setString(2,user.getUsername());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	public void edituser(User user) {
		String sql = "Update users set name=?, email=?, phone=?,role = ? where username=?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getRole());
			ps.setString(5,user.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<User> getAllRole(String role) {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users WHERE role = ?";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, role);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
				user.setRole(rs.getString("role"));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return users; 
	}

}


