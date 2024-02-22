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
import giadung.webmvc.model.Product;
import giadung.webmvc.service.BoardnewService;
import giadung.webmvc.service.impl.BoardnewServicesImpl;
import giadung.webmvc.util.FileUtil;

@MultipartConfig
public class BoardnewEditController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BoardnewService boardnewService = new BoardnewServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Boardnew boardnew = boardnewService.get(Integer.parseInt(id));
		req.setAttribute("boardnew", boardnew);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/boardnew/editboardnew.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		String new_id = req.getParameter("new-id");
		String new_title = req.getParameter("new-title");
		String new_content = req.getParameter("new-content");
		
		if(new_title.equals("")||new_content.equals("")) {
			
			Boardnew boardnew = new Boardnew(new_id, new_title, new_content, null,null);
			req.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
			req.setAttribute("boardnew",boardnew);
	
			req.getRequestDispatcher("/view/admin/boardnew/editboardnew.jsp").forward(req, resp);
			return;
		}
		Part filePart = req.getPart("new-image_link");
		final String dirPartName = req.getServletContext().getRealPath("/files");
		File dirFile = new File(dirPartName);
		if(!dirFile.exists()){
			dirFile.mkdirs();
		}
		Boardnew boardnew2 = boardnewService.get(Integer.parseInt(new_id));
		String fileName = FileUtil.getName(filePart);
		String picture = "";
		if(fileName.isEmpty()){
			picture = boardnew2.getImage_link();
		} else{
			picture = FileUtil.rename(fileName);
		}
		
		String filePathName = dirPartName + File.separator + picture;
		Boardnew boardnew = new Boardnew();
		boardnew.setId(new_id);
		boardnew.setTitle(new_title);
		boardnew.setContent(new_content);
		boardnew.setImage_link(picture);


		boardnewService.edit(boardnew);
		if(!fileName.isEmpty()){
			//xóa file cũ
			String oldFilePathName = dirPartName + File.separator + boardnew2.getImage_link();
			File oldFile = new File(oldFilePathName);
			if(oldFile.exists()){
				oldFile.delete();
			}
			
			//ghi file
			filePart.write(filePathName);
		}
		resp.sendRedirect(req.getContextPath()+"/admin/new/list?msg=2");

	}

}
