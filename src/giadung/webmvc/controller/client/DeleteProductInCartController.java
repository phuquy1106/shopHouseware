package giadung.webmvc.controller.client;

import java.io.IOException;
import java.text.DecimalFormat;
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

public class DeleteProductInCartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService productservice = new ProductServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		HttpSession session = req.getSession(true);
		Product product = productservice.get(Integer.parseInt(id));
		Order order = (Order) session.getAttribute("order");
		List<Item> listItems = order.getItems();
		for(Item item: listItems)
		{
			if(Integer.parseInt(item.getProduct().getId()) == Integer.parseInt(product.getId()))
			{
				order.setSumPrice(order.getSumPrice() - item.getPrice());
				listItems.remove(item);
				break;
			}
		}
		order.setItems(listItems);
		int n = listItems.size();
		session.setAttribute("length_order",n);
		session.setAttribute("order", order);
		resp.sendRedirect(req.getContextPath() + "/view/client/cart");
		if(order.getSumPrice() == 0)
		{
			n = listItems.size();
			session.setAttribute("length_order",n);
			session.setAttribute("sumprice", "0");
		} else {
			n = listItems.size();
			session.setAttribute("length_order",n);
			session.setAttribute("sumprice", order.getSumPrice());
		}
		
	}
}
