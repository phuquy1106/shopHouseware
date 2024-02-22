package giadung.webmvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
	public connectDB() {
		super();
	}
	public static Connection getConnect() {
	Connection c = null;
		try {
			// đăng ký mysql drive với drivermanager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			// các thông số
			String url = "jdbc:mysql://localhost:3306/qlns";
			String username = "root";
			String password = "";
		// tạo kết nối
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	public static void main(String[] args) {
		System.out.println(getConnect());
	}

}