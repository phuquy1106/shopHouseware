package giadung.webmvc.controller.client;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import giadung.webmvc.model.Item;
import giadung.webmvc.model.Order;
import giadung.webmvc.model.Product;
import giadung.webmvc.service.ProductService;
import giadung.webmvc.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class AddtoCartController
 */
public class AddtoCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		int n= 0;
		int qty = 1;
		String id;
		if(req.getParameter("product-id")!=null) {
			id = req.getParameter("product-id");
			Product product = productService.get(Integer.parseInt(id));;
			if(product != null) {
				if(req.getParameter("aquantity")!=null) {
					qty = Integer.parseInt(req.getParameter("aquantity"));
				}
				
				HttpSession session = req.getSession();
				if(session.getAttribute("order") == null) {
					Order order = new Order();
					List<Item> listItems = new ArrayList<Item>();
					Item item = new Item();
					item.setQty(qty);
					item.setProduct(product);
					item.setPrice((Double.parseDouble(product.getPrice()) - Double.parseDouble(product.getPrice())*(Double.parseDouble(product.getDiscount())/100))*qty);
					order.setSumPrice(0);
					order.setSumPrice(order.getSumPrice() + item.getPrice());
					listItems.add(item);
					order.setItems(listItems);
					n = listItems.size();
					session.setAttribute("length_order",n);
					session.setAttribute("order", order);
					session.setAttribute("sumprice", order.getSumPrice());
				} else {
					Order order = (Order) session.getAttribute("order");
					List<Item> listItems = order.getItems();
					boolean check = false;
					for(Item item : listItems) {
						if(Integer.parseInt(item.getProduct().getId()) == Integer.parseInt(product.getId())) {
							item.setQty(item.getQty() + qty);
							order.setSumPrice(order.getSumPrice() + (Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100))*qty);
							item.setPrice(item.getPrice() + ((Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100)))*qty);
							check = true;
						}
					}
					if(check == false) {
						Item item = new Item();
						item.setQty(qty);
						item.setProduct(product);
						item.setPrice((Double.parseDouble(product.getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100))*qty);
						order.setSumPrice(order.getSumPrice() + (Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100))*qty);
						listItems.add(item);
					}
					n = listItems.size();
					session.setAttribute("length_order",n);
					session.setAttribute("order", order);
					Double tong = order.getSumPrice();
					session.setAttribute("sumprice", tong);
				}
			}
		} 
		resp.getWriter().print(n);
	}

}
