package giadung.webmvc.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.Catalog;
import giadung.webmvc.model.Product;
import giadung.webmvc.service.CategoryService;
import giadung.webmvc.service.ProductService;
import giadung.webmvc.service.impl.CategoryServicesImpl;
import giadung.webmvc.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductListController
 */
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int count = productService.getTotalProduct();
		int sizePage = 6;
		int endPage = count/sizePage;
		if(count%sizePage!=0) {
			endPage++;
		}
		req.setAttribute("endPage", endPage);
		
		
		String indexPage = req.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		req.setAttribute("index", index);
		List<Product> list = productService.getAllpt(sizePage,index);
		req.setAttribute("list", list);
//		List<Product> productList = productService.getAll();
//		req.setAttribute("productlist", productList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/product/show-product.jsp");
		dispatcher.forward(req, resp);
	}
}
