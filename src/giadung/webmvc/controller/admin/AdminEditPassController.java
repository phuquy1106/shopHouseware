package giadung.webmvc.controller.admin;

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

/**
 * Servlet implementation class AdminEditPassController
 */
@WebServlet("/admin/editpass")
public class AdminEditPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      UserService userService = new UserServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditPassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd  = request.getRequestDispatcher("/view/admin/user/editpassworld.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String passwordcu = req.getParameter("passcu");
		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		
		if(!passwordcu.equals(userLogin.getPassword())) {
			req.setAttribute("errMessage", "Mật khẩu cũ không chính xác");
			RequestDispatcher rd = req.getRequestDispatcher("/view/admin/user/editpassworld.jsp");
			rd.forward(req, resp);
			return;
		}
		String passwordmoi = req.getParameter("passmoi");
		String passwordlai = req.getParameter("passlai");
		if(passwordmoi.equals("")) {
			req.setAttribute("error3", "Mật khẩu không được để trống");
			RequestDispatcher rd = req.getRequestDispatcher("/view/admin/user/editpassworld.jsp");
			rd.forward(req, resp);
			return;
		}
		if(passwordmoi.length()<6) {
			req.setAttribute("error2", "Mật khẩu tối thiểu 6 ký tự");
			RequestDispatcher rd = req.getRequestDispatcher("/view/admin/user/editpassworld.jsp");
			rd.forward(req, resp);
			return;
		}
		if(!passwordmoi.equals(passwordlai)) {
			req.setAttribute("error", "Mật khẩu nhập lại không đúng");
			RequestDispatcher rd = req.getRequestDispatcher("/view/admin/user/editpassworld.jsp");
			rd.forward(req, resp);
			return;
		}
		String passmahoa = StringUtil.md5(passwordlai);
		User user = new User(0, null, null, null, userLogin.getUsername(), passmahoa, null, null);
		if(userService.editpass(user) > 0) {
			req.setAttribute("Message", "Thay đổi mật khẩu thành công");
			userLogin.setPassword(passwordlai);
			session.setAttribute("userLogin", userLogin);
			RequestDispatcher rd = req.getRequestDispatcher("/view/admin/user/editpassworld.jsp");
			rd.forward(req, resp);
			return;
		}else {
			req.setAttribute("errMessage2", "Thay đổi mật khẩu thất bại");
			RequestDispatcher rd = req.getRequestDispatcher("/view/admin/user/editpassworld.jsp");
			rd.forward(req, resp);
			return;
		}
	}
	

}
