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
import giadung.webmvc.service.CategoryService;
import giadung.webmvc.service.impl.CategoryServicesImpl;

/**
 * Servlet implementation class CategoryAddController
 */
//@WebServlet(urlPatterns = { "" })
public class CategoryAddController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/catalog/addcate.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		
	    String cate_name = req.getParameter("cate-name");
		if(cate_name.equals("")) {
			req.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
			req.getRequestDispatcher("/view/admin/catalog/addcate.jsp").forward(req, resp);
			return;
		}
		List<Catalog> cateList = cateService.getAll();
		for (Catalog catalog : cateList) {
			if(cate_name.equalsIgnoreCase(catalog.getName())) {
				req.setAttribute("error2", "Tên danh mục đã tồn tại");
				req.setAttribute("cate_name", cate_name);
				req.getRequestDispatcher("/view/admin/catalog/addcate.jsp").forward(req, resp);
				return;
			}
		}
		Catalog category = new Catalog();
		category.setName(cate_name);
		cateService.insert(category);
		resp.sendRedirect(req.getContextPath() + "/admin/cate/list?msg=1");
	}

}
