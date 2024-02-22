package giadung.webmvc.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.Catalog;
import giadung.webmvc.model.Product;
import giadung.webmvc.service.CategoryService;
import giadung.webmvc.service.impl.CategoryServicesImpl;

/**
 * Servlet implementation class CatagoryEditController
 */
public class CategoryEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Catalog catelist = cateService.get(Integer.parseInt(id));
		req.setAttribute("catelist", catelist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/catalog/editcate.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		if(name.equals("")) {
			Catalog catalog = new Catalog(id, name);
			req.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
			req.setAttribute("catelist", catalog);
			req.getRequestDispatcher("/view/admin/catalog/editcate.jsp").forward(req, resp);
			return;
		}
		Catalog category = new Catalog();
		category.setName(name);
		category.setId(id);	
		cateService.edit(category);
		
		resp.sendRedirect(req.getContextPath()+"/admin/cate/list?msg=2");

	}
}