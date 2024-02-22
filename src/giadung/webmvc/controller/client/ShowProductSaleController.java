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

import giadung.webmvc.model.Catalog;
import giadung.webmvc.model.Product;
import giadung.webmvc.service.CategoryService;
import giadung.webmvc.service.ProductService;
import giadung.webmvc.service.impl.CategoryServicesImpl;
import giadung.webmvc.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ShowProductSaleController
 */
@WebServlet("/view/client/productsale")
public class ShowProductSaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductSaleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Catalog> cateList = cateService.getAll();
		req.setAttribute("catelist", cateList);
		List<Product> productList = productService.getAll();
		req.setAttribute("productlist", productList);
		List<Product> product_sale= new ArrayList<Product>();
		for(Product product: productList)
		{
			if(!product.getDiscount().equals("0")) {
				product_sale.add(product);
			}
		}
		int count = 0;
		for (Product giamgia : product_sale) {
			count++;
		}
		int endPage = count/6;
		if(count%6!=0) {
			endPage++;
		}
		req.setAttribute("endPage", endPage);
		int sizePage = 6;
		String indexPage = req.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		req.setAttribute("index", index);
		List<Product> productsale = productService.getAllProductSale(sizePage,index);
		
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
		req.setAttribute("product_sale", productsale);	

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/showproductsale.jsp");
		dispatcher.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
