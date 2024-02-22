package giadung.webmvc.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.User;
import giadung.webmvc.service.UserService;
import giadung.webmvc.service.impl.UserServicesImpl;

import java.util.List;

public class UserListController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServicesImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = req.getParameter("role");
		if(role == null) {
			role = "User";
		}
		List<User> users = userService.getAllRole(role);	
		req.setAttribute("userList", users);
		req.setAttribute("role", role);
		RequestDispatcher dispatcherUser  = req.getRequestDispatcher("/view/admin/user/user.jsp");
		dispatcherUser.forward(req, resp);
	}
}