package giadung.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import giadung.webmvc.dao.BoardnewDao;
import giadung.webmvc.jdbc.connectDB;
import giadung.webmvc.model.Boardnew;

public class BoardnewDaoImpl  implements BoardnewDao{
	
	public void insert(Boardnew boardnew) {
		String sql = "INSERT INTO boardnew(title, content,image_link, created) VALUES (?, ?, ?, ?)";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, boardnew.getTitle());
			ps.setString(2, boardnew.getContent());
			ps.setString(3, boardnew.getImage_link());
			ps.setString(4, boardnew.getCreated());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void delete(int id) {
		String sql = "DELETE FROM boardnew WHERE id=?";
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void edit(Boardnew boardnew) {
		String sql = "UPDATE boardnew SET title=?,content=?,image_link=? WHERE id=?";
		Connection con = connectDB.getConnect();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, boardnew.getTitle());
			ps.setString(2, boardnew.getContent());
			ps.setString(3, boardnew.getImage_link());
			ps.setString(4, boardnew.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Boardnew get(int id) {
		
		String sql = "SELECT * FROM boardnew WHERE id = ? ";
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Boardnew boardnew = new Boardnew();

				boardnew.setId(rs.getString("id"));
				boardnew.setTitle(rs.getString("title"));
				boardnew.setContent(rs.getString("content"));
				boardnew.setImage_link(rs.getString("image_link"));
				boardnew.setCreated(rs.getString("created"));
				//System.out.println("cc"+rs.getString("title"));
				return boardnew;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Boardnew get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Boardnew> getAll(int sizePage,int index) {
		List<Boardnew> boardnews = new ArrayList<Boardnew>();
		String sql = "SELECT * FROM boardnew ORDER BY id DESC LIMIT ? OFFSET ?";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sizePage);
			ps.setInt(2, ((index-1)*sizePage));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Boardnew boardnew = new Boardnew();

				boardnew.setId(rs.getString("id"));
				boardnew.setTitle(rs.getString("title"));
				boardnew.setContent(rs.getString("content"));
				boardnew.setImage_link(rs.getString("image_link"));
				boardnew.setCreated(rs.getString("created"));
				boardnews.add(boardnew);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boardnews;
	}


	public int getTotalBoardnew() {
		String sql = "SELECT COUNT(*) FROM boardnew ";
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


	public List<Boardnew> getAll() {
		List<Boardnew> boardnews = new ArrayList<Boardnew>();
		String sql = "SELECT * FROM boardnew";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Boardnew boardnew = new Boardnew();

				boardnew.setId(rs.getString("id"));
				boardnew.setTitle(rs.getString("title"));
				boardnew.setContent(rs.getString("content"));
				boardnew.setImage_link(rs.getString("image_link"));
				boardnew.setCreated(rs.getString("created"));
				boardnews.add(boardnew);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boardnews;
	}

}
