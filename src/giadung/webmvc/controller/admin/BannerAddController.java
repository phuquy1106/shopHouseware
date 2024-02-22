package giadung.webmvc.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import giadung.webmvc.model.Banner;
import giadung.webmvc.service.IBannerService;
import giadung.webmvc.service.impl.BannerServicesImpl;
import giadung.webmvc.util.FileUtil;

/**
 * Servlet implementation class BannerAddController
 */
@WebServlet(urlPatterns = { "/admin/banner/add" })
@MultipartConfig
public class BannerAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      IBannerService bannerService = new BannerServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BannerAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/banner/addbanner.jsp");
		dispatcher.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String name = req.getParameter("name");
		String note = req.getParameter("note");
			req.setAttribute("name",name);
			req.setAttribute("note",note);
	
		
		
		Part filePart = req.getPart("img");
		final String dirPartName = req.getServletContext().getRealPath("/files");
		File dirFile = new File(dirPartName);
		if(!dirFile.exists()){
			dirFile.mkdirs();
		}
		String fileName = FileUtil.getName(filePart);
		String picture = FileUtil.rename(fileName);
		String filePathName = dirPartName + File.separator + picture;
		Banner banner = new Banner();
		banner.setName(name);
		banner.setNote(note);
		banner.setImg(picture);
		bannerService.insert(banner);
		if(!fileName.isEmpty()){
			filePart.write(filePathName);
		}
		resp.sendRedirect(req.getContextPath()+"/admin/banner/list?msg=3");
	}

}
