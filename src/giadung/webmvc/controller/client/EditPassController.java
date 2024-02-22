package giadung.webmvc.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import giadung.webmvc.model.User;
import giadung.webmvc.service.UserService;
import giadung.webmvc.service.impl.UserServicesImpl;
import giadung.webmvc.util.StringUtil;



@WebServlet(urlPatterns = { "/view/client/editpass" })
public class EditPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServicesImpl();
    public EditPassController() {
        super();
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null) {
			resp.sendRedirect(req.getContextPath() + "/view/client/login");
			return;
		}
		RequestDispatcher rd = req.getRequestDispatcher("/view/client/editpassworld.jsp");
		rd.forward(req, resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String passwordcu = req.getParameter("passwordcu");
		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(!passwordcu.equals(userLogin.getPassword())) {
			req.setAttribute("errMessage", "Mật khẩu cũ không chính xác");
			RequestDispatcher rd = req.getRequestDispatcher("/view/client/editpassworld.jsp");
			rd.forward(req, resp);
			return;
		}
		String passwordlai = req.getParameter("passwordlai");
		String passmahoa = StringUtil.md5(passwordlai);
		User user = new User(0, userLogin.getUsername(), passmahoa, null, null, null, null);
		if(userService.editpass(user) > 0) {
			req.setAttribute("Message", "Thay đổi mật khẩu thành công");
			userLogin.setPassword(passwordlai);
			session.setAttribute("userLogin", userLogin);
			RequestDispatcher rd = req.getRequestDispatcher("/view/client/editpassworld.jsp");
			rd.forward(req, resp);
			return;
		}else {
			req.setAttribute("errMessage2", "Thay đổi mật khẩu thất bại");
			RequestDispatcher rd = req.getRequestDispatcher("/view/client/editpassworld.jsp");
			rd.forward(req, resp);
			return;
		}
	}

}
