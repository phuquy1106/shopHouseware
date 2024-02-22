package giadung.webmvc.controller.admin;

import java.io.File;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import giadung.webmvc.model.Boardnew;
import giadung.webmvc.service.BoardnewService;
import giadung.webmvc.service.impl.BoardnewServicesImpl;
import giadung.webmvc.util.FileUtil;
@MultipartConfig
public class BoardnewAddController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BoardnewService boardnewService = new BoardnewServicesImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/boardnew/addboardnew.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String new_title = req.getParameter("new-title");
		String new_content = req.getParameter("new-content");
	
		String new_created = String.valueOf(java.time.LocalDate.now());
		
		if(new_title.equals("")||new_content.equals("")) {
			req.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
			req.setAttribute("new_title",new_title);
			req.setAttribute("new_content",new_content);
			req.getRequestDispatcher("/view/admin/boardnew/addboardnew.jsp").forward(req, resp);
			return;
		}
		Part filePart = req.getPart("new-image_link");
		final String dirPartName = req.getServletContext().getRealPath("/files");
		File dirFile = new File(dirPartName);
		if(!dirFile.exists()){
			dirFile.mkdirs();
		}
		String fileName = FileUtil.getName(filePart);
		String picture = FileUtil.rename(fileName);
		String filePathName = dirPartName + File.separator + picture;
		System.out.println(filePathName);
		Boardnew boardnew = new Boardnew();
		boardnew.setTitle(new_title);
		boardnew.setContent(new_content);
		boardnew.setImage_link(picture);
		boardnew.setCreated(new_created);
		boardnewService.insert(boardnew);
		if(!fileName.isEmpty()){
			filePart.write(filePathName);
		}
		resp.sendRedirect(req.getContextPath() + "/admin/new/list?msg=1");
	}

}
