package giadung.webmvc.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminHomePage() {
        super();
    }	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/index.jsp");
		dispatcher.forward(req,resp);
	}

}
