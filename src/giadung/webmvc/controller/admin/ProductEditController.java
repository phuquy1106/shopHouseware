package giadung.webmvc.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import giadung.webmvc.model.Catalog;
import giadung.webmvc.model.Product;
import giadung.webmvc.service.CategoryService;
import giadung.webmvc.service.ProductService;
import giadung.webmvc.service.impl.CategoryServicesImpl;
import giadung.webmvc.service.impl.ProductServiceImpl;
import giadung.webmvc.util.FileUtil;


/**
 * Servlet implementation class ProductEditController
 */
@MultipartConfig
public class ProductEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Catalog> cateList = cateService.getAll();
		req.setAttribute("catelist", cateList);
		
		String id = req.getParameter("id");
		Product product = productService.get(Integer.parseInt(id));
		req.setAttribute("product", product);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/product/editproduct.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		Product product = new Product();
		
		String id = req.getParameter("product-sku");
		String product_cate = req.getParameter("product-cate");
		String product_name = req.getParameter("product-name");
		String product_price = req.getParameter("product-price");
		String product_status = req.getParameter("product-status");
		String product_desc = req.getParameter("product-desc");
		String product_content = req.getParameter("product-content");
		String product_discount = req.getParameter("product-discount");
		
		if(product_cate.equals("")||product_name.equals("")||product_price.equals("")||product_status.equals("")||product_desc.equals("")||product_content.equals("")||product_discount.equals("")) {
			product = new Product(id, product_cate, product_name, product_price, product_status, product_desc, product_content, product_discount, null, null);
			req.setAttribute("product",product);
			req.setAttribute("error", "Vui lòng nhập đủ thông tin");
			List<Catalog> cateList = cateService.getAll();
			req.setAttribute("catelist", cateList);
			req.getRequestDispatcher("/view/admin/product/editproduct.jsp").forward(req, resp);
			return;
		}

		try {
			int ktprice = Integer.parseInt(product_price); 
	
		} catch (NumberFormatException e) {
			req.setAttribute("error2", "Vui lòng nhập số");
			product = new Product(id, product_cate, product_name, product_price, product_status, product_desc, product_content, product_discount, null, null);
			req.setAttribute("product",product);
			List<Catalog> cateList = cateService.getAll();
			req.setAttribute("catelist", cateList);
			req.getRequestDispatcher("/view/admin/product/editproduct.jsp").forward(req, resp);
			return;
		}
		try {
		
			int discount = Integer.parseInt(product_discount);
			if(discount>100||discount<0) {
				req.setAttribute("error4", "Vui lòng nhập từ 0 đến 100");
				product = new Product(id, product_cate, product_name, product_price, product_status, product_desc, product_content, product_discount, null, null);
				req.setAttribute("product",product);
				List<Catalog> cateList = cateService.getAll();
				req.setAttribute("catelist", cateList);
				req.getRequestDispatcher("/view/admin/product/editproduct.jsp").forward(req, resp);
				return;
			}
		} catch (NumberFormatException e) {
			req.setAttribute("error3", "Vui lòng nhập số");
			product = new Product(id, product_cate, product_name, product_price, product_status, product_desc, product_content, product_discount, null, null);
			req.setAttribute("product",product);
			List<Catalog> cateList = cateService.getAll();
			req.setAttribute("catelist", cateList);
			req.getRequestDispatcher("/view/admin/product/editproduct.jsp").forward(req, resp);
			return;
		}
		Part filePart = req.getPart("product-image");
		final String dirPartName = req.getServletContext().getRealPath("/files");
		File dirFile = new File(dirPartName);
		if(!dirFile.exists()){
			dirFile.mkdirs();
		}
		Product product2 = productService.get(Integer.parseInt(id));
		String fileName = FileUtil.getName(filePart);
		String picture = "";
		if(fileName.isEmpty()){
			picture = product2.getImage_link();
		} else{
			picture = FileUtil.rename(fileName);
		}
		
		String filePathName = dirPartName + File.separator + picture;
		product = new Product();
		
		
		product.setName(product_name);
		product.setCatalog_id(product_cate);
	
		product.setPrice(product_price);
		product.setStatus(product_status);
		product.setDescription(product_desc);
		product.setContent(product_content);
		product.setDiscount(product_discount);
		product.setImage_link(picture);
		product.setId(id);
		productService.edit(product);
		if(!fileName.isEmpty()){
			//xóa file cũ
			String oldFilePathName = dirPartName + File.separator + product2.getImage_link();
			File oldFile = new File(oldFilePathName);
			if(oldFile.exists()){
				oldFile.delete();
			}
			
			//ghi file
			filePart.write(filePathName);
		}
		resp.sendRedirect(req.getContextPath()+"/admin/product/list?msg=2");

	}
}