package giadung.webmvc.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.Boardnew;
import giadung.webmvc.service.BoardnewService;
import giadung.webmvc.service.impl.BoardnewServicesImpl;

/**
 * Servlet implementation class CategoryListController
 */
//@WebServlet(urlPatterns = { "/admin/new/list" })
public class BoardnewListController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BoardnewService newService = new BoardnewServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int count = newService.getTotalBoardnew();
		System.out.println(count);
		int sizePage = 6;
		int endPage = count/sizePage;
		if(count/sizePage!=0) {
			endPage++;
		}
		req.setAttribute("endPage", endPage);
		String indexPage = req.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		req.setAttribute("index", index);
		List<Boardnew> boardnewList = newService.getAll(sizePage,index);
		req.setAttribute("boardnewlist", boardnewList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/boardnew/show-new.jsp");
		dispatcher.forward(req, resp);
	}
}
