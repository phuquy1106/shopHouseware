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
import giadung.webmvc.util.StringUtil;

public class UserEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_id = Integer.parseInt(req.getParameter("user-id"));
        User user = userService.get(user_id);
        req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/user/edituser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		int user_id = Integer.parseInt(req.getParameter("user-id"));
		String user_name = req.getParameter("user-name");
		String user_email = req.getParameter("user-email");
		String user_phone = req.getParameter("user-phone");
		if(user_name.equals("")) {
			User user = new User(user_id, null, null, user_phone, user_email,user_name,null);
			req.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
			req.setAttribute("user",user );
			req.getRequestDispatcher("/view/admin/user/edituser.jsp").forward(req, resp);
			return;
		}
		
		
		User user = new User();
		user.setName(user_name);
		user.setEmail(user_email);
		user.setPhone(user_phone);
		
		user.setId(user_id);
		userService.edit(user);
		User userl = userService.get(user_id);
		resp.sendRedirect(req.getContextPath() + "/admin/user/list?role=" + userl.getRole()+"&msg=2");
		//resp.sendRedirect(req.getContextPath() + "/view/admin/user.jsp");
	}

}
