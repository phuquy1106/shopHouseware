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

public class UserDeleteController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServicesImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	   
		int user_id = Integer.parseInt(req.getParameter("user-id"));
		User userl = userService.get(user_id);
		userService.delete(user_id);
		resp.sendRedirect(req.getContextPath() + "/admin/user/list?role=" + userl.getRole()+"&msg=3");
	}
}