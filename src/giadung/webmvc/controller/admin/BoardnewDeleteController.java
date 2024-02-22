package giadung.webmvc.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giadung.webmvc.model.Boardnew;
import giadung.webmvc.service.BoardnewService;
import giadung.webmvc.service.impl.BoardnewServicesImpl;

//@WebServlet(urlPatterns = { "/admin/new/delete" })
public class BoardnewDeleteController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BoardnewService boardnewService = new BoardnewServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Boardnew boardnew = boardnewService.get(Integer.parseInt(id));
		boardnewService.delete(Integer.parseInt(id));
		final String dirPathName = req.getServletContext().getRealPath("/files");
		String picture = boardnew.getImage_link();
		if(!picture.isEmpty()){
			String filePathName = dirPathName + File.separator + picture;
			File file = new File(filePathName);
			if(file.exists()){
				file.delete();
			}
		}
		resp.sendRedirect(req.getContextPath() + "/admin/new/list?msg=3");
	}

}