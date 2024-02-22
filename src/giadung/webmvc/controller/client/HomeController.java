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
import javax.servlet.http.HttpSession;

import giadung.webmvc.model.Banner;
import giadung.webmvc.model.Boardnew;
import giadung.webmvc.model.Product;
import giadung.webmvc.service.BoardnewService;
import giadung.webmvc.service.IBannerService;
import giadung.webmvc.service.OrderedService;
import giadung.webmvc.service.ProductService;
import giadung.webmvc.service.impl.BannerServicesImpl;
import giadung.webmvc.service.impl.BoardnewServicesImpl;
import giadung.webmvc.service.impl.OrderedServiceImpl;
import giadung.webmvc.service.impl.ProductServiceImpl;



public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IBannerService bannerService = new BannerServicesImpl();
	ProductService productService = new ProductServiceImpl();
	BoardnewService boardnewService = new BoardnewServicesImpl();
	OrderedService orderedService = new OrderedServiceImpl();
	DecimalFormat df = new DecimalFormat("#.000");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Boardnew> boardnewList = boardnewService.getAll();
		req.setAttribute("boardnewlist", boardnewList);
		
		
		// Product mới
		List<Product> product_new= productService.getAll();
		System.out.println(product_new.size());
		req.setAttribute("product_new", product_new);	
				
		
		List<Product> productList = productService.getAll();
		req.setAttribute("productlist", productList);	
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productList)
		{
			Product product1 = productService.get(Integer.parseInt(product.getId()));
			//Double numberp = ((Double.parseDouble(product.getPrice()) - (Double.parseDouble(product.getPrice()) * Double.parseDouble(product.getDiscount())) / 100 ));
			Double numberp = ((Double.parseDouble(product.getPrice())-(Double.parseDouble(product.getPrice())*Double.parseDouble(product.getDiscount()))/100));
			product1.setPrice(String.valueOf(numberp));
			productsList1.add(product1);
			
	      
	        
			
		}

		req.setAttribute("productlist1", productsList1);
		
		// Product giảm giá
		List<Product> product_sale= new ArrayList<Product>();
		for(Product product: productList)
		{
			if(!product.getDiscount().equals("0")) {
				product_sale.add(product);
			}
		}

		//san pham ban chay
		List<String> NameNhieu = orderedService.getIdPro();
		List<Product> listbanchay = new ArrayList<Product>();
		for (String name : NameNhieu) {
			Product probanchay = productService.get(name);
			listbanchay.add(probanchay);
		}
		req.setAttribute("listbanchay", listbanchay);
		
		
		req.setAttribute("productlist1", productsList1);
		req.setAttribute("product_sale", product_sale);	
		List<Banner> bannerList = bannerService.getAll();
		req.setAttribute("bannerList", bannerList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/index.jsp");
		dispatcher.forward(req, resp);
	}
}
