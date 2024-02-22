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

/**
 * Servlet implementation class EditUserController
 */
@WebServlet("/view/client/edituser")
public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UserService userService = new UserServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null) {
			resp.sendRedirect(req.getContextPath() + "/view/client/login");
			return;
		}
		User user = userService.get(userLogin.getUsername());
		req.setAttribute("user",user);
		RequestDispatcher rd = req.getRequestDispatcher("/view/client/edituser.jsp");
		rd.forward(req, resp);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String username = req.getParameter("username");
		String role = req.getParameter("role");
		User user = new User(0, name, email, phone, username, null, null, role);
		userService.edituser(user);
		userLogin.setName(name);
		userLogin.setEmail(email);
		userLogin.setPhone(phone);
		req.setAttribute("user",userLogin);
		req.setAttribute("msguser", "Cập nhật thành công");
		RequestDispatcher rd = req.getRequestDispatcher("/view/client/edituser.jsp");
		rd.forward(req, resp);
		return;
	}

}
