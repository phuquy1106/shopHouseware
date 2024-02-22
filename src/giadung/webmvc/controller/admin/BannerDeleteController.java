package giadung.webmvc.controller.admin;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.Banner;
import giadung.webmvc.service.IBannerService;
import giadung.webmvc.service.impl.BannerServicesImpl;

/**
 * Servlet implementation class BannerDeleteController
 */
@WebServlet(urlPatterns = { "/admin/banner/delete" })
public class BannerDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     IBannerService bannerService = new BannerServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BannerDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Banner banner = bannerService.get(id);
		
		bannerService.delete(id);
		final String dirPathName = req.getServletContext().getRealPath("/files");
		String picture = banner.getImg();
		if(!picture.isEmpty()){
			String filePathName = dirPathName + File.separator + picture;
			File file = new File(filePathName);
			if(file.exists()){
				file.delete();
			}
		}
		resp.sendRedirect(req.getContextPath() + "/admin/banner/list?msg=3");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
