package giadung.webmvc.controller.client;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.Catalog;
import giadung.webmvc.model.Product;
import giadung.webmvc.service.CategoryService;
import giadung.webmvc.service.ProductService;
import giadung.webmvc.service.impl.CategoryServicesImpl;
import giadung.webmvc.service.impl.ProductServiceImpl;

public class ProductSeachByNameController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();
	ProductService productService=new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("s");
		List<Catalog> cateList = cateService.getAll();
		req.setAttribute("catelist", cateList);	
		int count = productService.getTotalProductsearch(name);
		int sizePage = 6;
		int endPage1 = count/sizePage;
		if(count%sizePage!=0) {
			endPage1++;
		}
		req.setAttribute("endPage1", endPage1);
		String indexPage = req.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		req.setAttribute("index", index);
		req.setAttribute("name", name);
		
		List<Product> productSeachByName = productService.searchByNamept(name, sizePage, index);
		req.setAttribute("productlist", productSeachByName);
	
		List<Product> productAllList = productService.getAll();
		req.setAttribute("product_all", productAllList);
		
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productAllList)
		{
			Product product1 = productService.get(Integer.parseInt(product.getId()));
			product1.setPrice(String.valueOf(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(product.getDiscount())/100))));
			productsList1.add(product1);
			
		}

		req.setAttribute("productlist1", productsList1);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/product-search.jsp");
		dispatcher.forward(req, resp);

	}
}
