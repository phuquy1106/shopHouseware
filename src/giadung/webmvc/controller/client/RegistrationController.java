package giadung.webmvc.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.dao.impl.RegisterDao;
import giadung.webmvc.jdbc.connectDB;
import giadung.webmvc.model.User;
import giadung.webmvc.service.UserService;
import giadung.webmvc.service.impl.UserServicesImpl;
import giadung.webmvc.util.StringUtil;

/**
 * Servlet implementation class RegistrationController
 */

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServicesImpl();
	
	
	public RegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/client/register.jsp");
    	dispatcher.forward(req, resp);
    }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String name = req.getParameter("name");
		String created = req.getParameter("created");
		String passmahoa = StringUtil.md5(password);
		User user = new User(0, name, email, phone, username, passmahoa, created, "User");

		List<User> users = userService.getAll();
		boolean usernameExists = false;
		for (User kt : users) {
			if(kt.getUsername().equals(username)) {
				
				usernameExists = true;
				
			}
		}	
		if(usernameExists) {
			req.setAttribute("user", user);
			req.setAttribute("erruser", "Username đã tồn tại");
			RequestDispatcher rd = req.getRequestDispatcher("/view/client/register.jsp");
			rd.forward(req, resp);
		}else {
			RegisterDao register = new RegisterDao(connectDB.getConnect());
			if (register.RegisterUser(user)) // On success, you can display a message to user on Home page
			{
				req.setAttribute("Message", "Bạn đã tạo tài khoàn thành công. Mời bạn đăng nhập <a href='/do-an-java/view/client/login'>tại đây!</a>");
				RequestDispatcher rd = req.getRequestDispatcher("/view/client/register.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("errMessage", "Tạo tài khoản thất bại. Hãy thử lại !!!");
				RequestDispatcher rd = req.getRequestDispatcher("/view/client/register.jsp");
				rd.forward(req, resp);
			}
		}
		
	}
}
