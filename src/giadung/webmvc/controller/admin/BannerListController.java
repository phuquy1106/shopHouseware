package giadung.webmvc.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.Banner;
import giadung.webmvc.service.IBannerService;
import giadung.webmvc.service.impl.BannerServicesImpl;

/**
 * Servlet implementation class BannerListController
 */
//@WebServlet(urlPatterns = { "/admin/banner/list" })
public class BannerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       IBannerService bannerService = new BannerServicesImpl();
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Banner> bannerList = bannerService.getAll();
		req.setAttribute("bannerList", bannerList);
		RequestDispatcher dp = req.getRequestDispatcher("/view/admin/banner/show-banner.jsp");
		dp.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
