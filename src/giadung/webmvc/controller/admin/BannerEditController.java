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
import giadung.webmvc.model.Boardnew;
import giadung.webmvc.service.IBannerService;
import giadung.webmvc.service.impl.BannerServicesImpl;
import giadung.webmvc.util.FileUtil;

/**
 * Servlet implementation class BannerEditController
 */
@MultipartConfig
@WebServlet(urlPatterns = { "/admin/banner/edit" })
public class BannerEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     IBannerService bannerService = new BannerServicesImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BannerEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		Banner banner =bannerService.get(id);
		req.setAttribute("banner", banner);
		RequestDispatcher dp = req.getRequestDispatcher("/view/admin/banner/editbanner.jsp");
		dp.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String note = req.getParameter("note");

		

			
			Banner banner1 = new Banner(id, name, note, null);
			req.setAttribute("banner",banner1);
	
		Part filePart = req.getPart("img");
		final String dirPartName = req.getServletContext().getRealPath("/files");
		File dirFile = new File(dirPartName);
		if(!dirFile.exists()){
			dirFile.mkdirs();
		}
		Banner banner2 = bannerService.get(Integer.parseInt(id));
		String fileName = FileUtil.getName(filePart);
		String picture = "";
		if(fileName.isEmpty()){
			picture = banner2.getImg();
		} else{
			picture = FileUtil.rename(fileName);
		}
		
		String filePathName = dirPartName + File.separator + picture;
		Banner banner = new Banner();
		banner.setId(id);
		banner.setName(name);
		banner.setNote(note);
		banner.setImg(picture);
		bannerService.edit(banner);
		if(!fileName.isEmpty()){
			//xóa file cũ
			String oldFilePathName = dirPartName + File.separator + banner2.getImg();
			File oldFile = new File(oldFilePathName);
			if(oldFile.exists()){
				oldFile.delete();
			}
			
			//ghi file
			filePart.write(filePathName);
		}
		resp.sendRedirect(req.getContextPath()+"/admin/banner/list?msg=2");
	}

}
