package giadung.webmvc.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.User;
import giadung.webmvc.service.UserService;
import giadung.webmvc.service.impl.UserServicesImpl;

public class UserAddController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServicesImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/user/adduser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String user_name = req.getParameter("user-name");
		String user_email = req.getParameter("user-email");
		String user_phone = req.getParameter("user-phone");
		String user_userName = req.getParameter("user-userName");
		String user_password = req.getParameter("user-password");
		String user_created = String.valueOf(java.time.LocalDate.now());
		String role = req.getParameter("role");
		if(user_name.equals("")||user_userName.equals("")||user_password.equals("")) {
			User user = new User(0, user_name, user_email, user_phone, user_userName, user_password, null, role);
			req.setAttribute("error", "Vui lòng nhập đủ thông tin");
			req.setAttribute("user",user);
			req.getRequestDispatcher("/view/admin/user/adduser.jsp").forward(req, resp);
			return;
		}
		List<User> list = userService.getAll();
		for (User user : list) {
			if(user_userName.equals(user.getUsername())) {
				req.setAttribute("error3", "username đã tồn tại");
				req.setAttribute("user",user);
				req.getRequestDispatcher("/view/admin/user/adduser.jsp").forward(req, resp);
				return;
			}
		}
		if(user_password.length()<6) {
			User user = new User(0, user_name, user_email, user_phone, user_userName, user_password, null, role);
			req.setAttribute("error2", "Mật khẩu tối thiểu 6 chữ số");
			req.setAttribute("user",user);
			req.getRequestDispatcher("/view/admin/user/adduser.jsp").forward(req, resp);
			return;
		}
		
		User user = new User();
		user.setName(user_name);
		user.setEmail(user_email);
		user.setPhone(user_phone);
		user.setUsername(user_userName);
		user.setPassword(user_password);
		user.setCreated(user_created);
		user.setRole(role);
		userService.insert(user);
		

		resp.sendRedirect(req.getContextPath() + "/admin/user/list?role=" + role+"&msg=1");
		//resp.sendRedirect(req.getContextPath() + "/view/admin/user.jsp");
	}

}
