package giadung.webmvc.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.Ordered;
import giadung.webmvc.model.Product;
import giadung.webmvc.model.Transactions;
import giadung.webmvc.service.OrderedService;
import giadung.webmvc.service.ProductService;
import giadung.webmvc.service.TransactionService;
import giadung.webmvc.service.impl.OrderedServiceImpl;
import giadung.webmvc.service.impl.ProductServiceImpl;
import giadung.webmvc.service.impl.TransactionServicesImpl;

/**
 * Servlet implementation class OrderListController
 */

public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	TransactionService transactionService = new TransactionServicesImpl(); 
	private OrderedService orderedService = new OrderedServiceImpl();
    private ProductService productService = new ProductServiceImpl();
 
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		List<Transactions> transactionList = transactionService.getAll();
		List<Ordered> listOrder = orderedService.getAll();
		List<Product> listPro = productService.getAll();
		req.setAttribute("listPro", listPro);
		req.setAttribute("listOrder", listOrder);
		req.setAttribute("order", transactionList); 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/order/show-order.jsp"); 
		dispatcher.forward(req, resp); 
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("aid"));
		transactionService.setStatus(id);
		resp.getWriter().print("Đã xác nhận");
	}

}
