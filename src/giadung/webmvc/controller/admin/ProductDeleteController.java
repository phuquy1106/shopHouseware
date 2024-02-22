package giadung.webmvc.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.Product;
import giadung.webmvc.service.OrderedService;
import giadung.webmvc.service.ProductService;
import giadung.webmvc.service.impl.OrderedServiceImpl;
import giadung.webmvc.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class CatagoryDeleteController
 */
//@WebServlet(urlPatterns = { "/admin/cate/delete" })
public class ProductDeleteController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	OrderedService orderedService = new OrderedServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product product = productService.get(Integer.parseInt(id));
		productService.delete(id);
		final String dirPathName = req.getServletContext().getRealPath("/files");
		String picture = product.getImage_link();
		if(!picture.isEmpty()){
			//tạo đường dẫn đầy đủ đến file được tải lên trên máy chủ.
			String filePathName = dirPathName + File.separator + picture;
			File file = new File(filePathName);
			if(file.exists()){
				file.delete();
			}
		}
		resp.sendRedirect(req.getContextPath() + "/admin/product/list?msg=3");
	}

}
