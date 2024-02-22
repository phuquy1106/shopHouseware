package giadung.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import giadung.webmvc.dao.CategoryDao;
import giadung.webmvc.dao.TransactionDao;
import giadung.webmvc.jdbc.connectDB;
import giadung.webmvc.model.Transactions;

public class TransactionDaoImpl implements TransactionDao {
	public void insert(Transactions transaction) { 
		String sql = "INSERT INTO transactions(user_session,user_name,user_mail,user_phone,address,message,amount,payment,created,status) VALUES (?,?,?,?,?,?,?,?,?,?)"; 
		new connectDB(); 
		Connection con = connectDB.getConnect(); 
 
		try { 
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1, transaction.getUser_session());
			ps.setString(2, transaction.getUser_name());
			ps.setString(3, transaction.getUser_mail());
			ps.setString(4, transaction.getUser_phone());
			ps.setString(5, transaction.getAddress());
			ps.setString(6, transaction.getMessage());
			ps.setString(7, transaction.getAmount());
			ps.setString(8, transaction.getPayment());
			ps.setString(9, transaction.getCreated());
			ps.setString(10, transaction.getStatus());
			int r = ps.executeUpdate(); 
			System.out.println(r);
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
	} 
	
	
	public void delete(String id) { 		
		String sql = "Delete from transactions where id=?";
		new connectDB();
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	} 
	

	public Transactions get(int id) {		
		Transactions transaction = new Transactions();
		String sql = "SELECT * FROM transactions WHERE id=?";
		new connectDB();
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {				
				transaction.setId(rs.getInt("id"));
				transaction.setUser_session(rs.getString("user_session"));
				transaction.setUser_name(rs.getString("user_name"));
				transaction.setUser_mail(rs.getString("user_mail"));
				transaction.setUser_phone(rs.getString("user_phone"));
				transaction.setAddress(rs.getString("address"));
				transaction.setMessage(rs.getString("message"));
				transaction.setAmount(rs.getString("amount"));
				transaction.setPayment(rs.getString("payment"));
				transaction.setCreated(rs.getString("created"));
				return transaction;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void edit(Transactions transaction) { 
	String sql = "Update transactions set user_name =?, user_mail =?, user_phone =?, address= ?,message=?,amount=?,payment=?, status=? where id=?";

		new connectDB();
		Connection con = connectDB.getConnect();
		try 
		{
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1, transaction.getUser_name());
			ps.setString(2, transaction.getUser_mail());
			ps.setString(3, transaction.getUser_phone());
			ps.setString(4, transaction.getAddress());
			ps.setString(5, transaction.getMessage());
			ps.setString(6, transaction.getAmount());
			ps.setInt(7, Integer.parseInt(transaction.getPayment()));
			ps.setString(8,transaction.getStatus());
			ps.setInt(9,transaction.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		 
	} 
	
	
	public Transactions get(String name) { 
		return null; 
	} 
 
	
	public List<Transactions> getAll() { 
		List<Transactions> transactions = new ArrayList<Transactions>(); 
		String sql = "SELECT * FROM transactions"; 
		Connection conn = connectDB.getConnect(); 
 
		try { 
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery(); 
 
			while (rs.next()) { 
				Transactions transaction = new Transactions(); 
				transaction.setId(rs.getInt("id"));
				transaction.setUser_session(rs.getString("user_session"));
				transaction.setUser_name(rs.getString("user_name"));
				transaction.setUser_mail(rs.getString("user_mail"));
				transaction.setUser_phone(rs.getString("user_phone"));
				transaction.setAddress(rs.getString("address"));
				transaction.setMessage(rs.getString("message"));
				transaction.setAmount(rs.getString("amount"));
				transaction.setPayment(rs.getString("payment"));
				transaction.setStatus(rs.getString("status"));
				transaction.setCreated(rs.getString("created"));
				transactions.add(transaction); 
			} 
 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
 
		return transactions; 
	}


	public ArrayList<Transactions> getAllUser(String username) {
		ArrayList<Transactions> transactions = new ArrayList<Transactions>(); 
		String sql = "SELECT * FROM transactions WHERE user_session = ?"; 
		Connection conn = connectDB.getConnect(); 
 
		try { 
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery(); 
 
			while (rs.next()) { 
				Transactions transaction = new Transactions(); 
				transaction.setId(rs.getInt("id"));
				transaction.setUser_session(rs.getString("user_session"));
				transaction.setUser_name(rs.getString("user_name"));
				transaction.setUser_mail(rs.getString("user_mail"));
				transaction.setUser_phone(rs.getString("user_phone"));
				transaction.setAddress(rs.getString("address"));
				transaction.setMessage(rs.getString("message"));
				transaction.setAmount(rs.getString("amount"));
				transaction.setPayment(rs.getString("payment"));
				transaction.setStatus(rs.getString("status"));
				transaction.setCreated(rs.getString("created"));
				transactions.add(transaction); 
			} 
 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
 
		return transactions;
	}


	public void setStatus(int id) {
		String sql = "UPDATE transactions SET status = 'Đã xác nhận' WHERE id = ? ;";

		new connectDB();
		Connection con = connectDB.getConnect();
		try 
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		 
		
	}
}
