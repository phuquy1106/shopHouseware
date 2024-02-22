package giadung.webmvc.controller.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import giadung.webmvc.model.Ordered;
import giadung.webmvc.model.Product;
import giadung.webmvc.model.Transactions;
import giadung.webmvc.model.User;
import giadung.webmvc.service.OrderedService;
import giadung.webmvc.service.ProductService;
import giadung.webmvc.service.TransactionService;
import giadung.webmvc.service.impl.OrderedServiceImpl;
import giadung.webmvc.service.impl.ProductServiceImpl;
import giadung.webmvc.service.impl.TransactionServicesImpl;


@WebServlet("/view/client/showorder")
public class ShowOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TransactionService transactionService = new TransactionServicesImpl();
    private OrderedService orderedService = new OrderedServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    
    public ShowOrderController() {
        super();
        
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("userLogin");
        if(user.getUsername() == null || user.getUsername() == "") {
        	resp.sendRedirect(req.getContextPath() + "/view/client/login");
        	return;
        }
		ArrayList<Transactions> listTra = transactionService.getAllUser(user.getUsername());
		List<Ordered> listOrder = orderedService.getAll();
		List<Product> listPro = productService.getAll();
		req.setAttribute("listPro", listPro);
		req.setAttribute("listOrder", listOrder);
		req.setAttribute("listTra", listTra);
		RequestDispatcher rd = req.getRequestDispatcher("/view/client/showorder.jsp");
		rd.forward(req, resp);
	}
	

	

}
