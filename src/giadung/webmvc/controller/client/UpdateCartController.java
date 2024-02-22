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

import giadung.webmvc.model.Item;
import giadung.webmvc.model.Order;


public class UpdateCartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher dispatcher = req.getRequestDispatcher(req.getContextPath() + "/view/client/cart");
		dispatcher.forward(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		Order order = (Order) session.getAttribute("order");
		List<Item> listItems = order.getItems();
		order.setSumPrice(0);
		for(Item item: listItems)
		{
			item.setQty(Integer.parseInt(req.getParameter("qty" + item.getProduct().getId())));
			item.setPrice((Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100))*Double.parseDouble(req.getParameter("qty" + item.getProduct().getId())));
			order.setSumPrice(order.getSumPrice() + item.getPrice());
		}
		order.setItems(listItems);
		int n = listItems.size();
		session.setAttribute("length_order",n);
		session.setAttribute("order", order);
		session.setAttribute("sumprice", order.getSumPrice());
		resp.sendRedirect(req.getContextPath() + "/view/client/cart");
	}
}
