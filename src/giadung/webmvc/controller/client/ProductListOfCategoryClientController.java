package giadung.webmvc.controller.client;

import java.io.IOException;
import java.text.DecimalFormat;
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

public class ProductListOfCategoryClientController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();
	ProductService productService = new ProductServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Catalog> cateList = cateService.getAll();
		req.setAttribute("catelist", cateList);
		String id = req.getParameter("id");
		List<Product> productList = productService.getProductById(Integer.parseInt(id));
		int count =0;
		int sizePage = 6;
		for (Product product : productList) {
			count++;
		}
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
		
		List<Product> productLists = productService.getAll(Integer.parseInt(id),sizePage,index);
		
		req.setAttribute("list", productLists);		
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productList)
		{
			Product product1 = productService.get(Integer.parseInt(product.getId()));
			product1.setPrice(String.valueOf(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(product.getDiscount())/100))));
			productsList1.add(product1);
			
		}
		req.setAttribute("productlist1", productsList1);
		List<Product> productList1s = productService.getAll();
		List<Product> productsList2 = new ArrayList<Product>();
		for(Product product: productList1s)
		{
			Product product1 = productService.get(Integer.parseInt(product.getId()));
			product1.setPrice(String.valueOf(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(product.getDiscount())/100))));
			productsList2.add(product1);
			
		}
		req.setAttribute("productlist", productsList2);
		req.setAttribute("productlist1", productList1s);
		
		req.setAttribute("idcate", id);
		req.setAttribute("phanbiet", "danhmuc");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/product.jsp");
		dispatcher.forward(req, resp);
	}

}
