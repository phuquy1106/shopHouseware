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

@MultipartConfig
public class ProductAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServicesImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Catalog> cateList = cateService.getAll();
		req.setAttribute("catelist", cateList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/product/addproduct.jsp");
		dispatcher.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=UTF-8");
			String product_cate = req.getParameter("product-cate");
			String product_name = req.getParameter("product-name");
			String product_price = req.getParameter("product-price");
			String product_status = req.getParameter("product-status");
			String product_desc = req.getParameter("product-desc");
			String product_content = req.getParameter("product-content");
			String product_discount = req.getParameter("product-discount");
			String product_day = String.valueOf(java.time.LocalDate.now());
			if(product_cate.equals("")||product_name.equals("")||product_price.equals("")||product_status.equals("")||product_desc.equals("")||product_content.equals("")||product_discount.equals("")) {
				
				req.setAttribute("error", "Vui lòng nhập đủ thông tin");

				req.setAttribute("productcate",product_cate);
				req.setAttribute("product_name",product_name);
				req.setAttribute("product_price",product_price);
				req.setAttribute("product_status",product_status);
				req.setAttribute("product_desc",product_desc);
				req.setAttribute("product_content",product_content);
				req.setAttribute("product_discount",product_discount);
				List<Catalog> cateList = cateService.getAll();
				req.setAttribute("catelist", cateList);
				req.getRequestDispatcher("/view/admin/product/addproduct.jsp").forward(req, resp);
				return;
			}

			try {
				int ktprice = Integer.parseInt(product_price); 
		
			} catch (NumberFormatException e) {
				req.setAttribute("error2", "Vui lòng nhập số");
				req.setAttribute("productcate",product_cate);
				req.setAttribute("product_name",product_name);
				req.setAttribute("product_price",product_price);
				req.setAttribute("product_status",product_status);
				req.setAttribute("product_desc",product_desc);
				req.setAttribute("product_content",product_content);
				req.setAttribute("product_discount",product_discount);
				List<Catalog> cateList = cateService.getAll();
				req.setAttribute("catelist", cateList);
				req.getRequestDispatcher("/view/admin/product/addproduct.jsp").forward(req, resp);
				return;
			}
			try {
			
				int discount = Integer.parseInt(product_discount);
				if(discount>100||discount<0) {
					req.setAttribute("error4", "Vui lòng nhập từ 0 đến 100");
					req.setAttribute("product-cate",product_cate);
					req.setAttribute("product_name",product_name);
					req.setAttribute("product_price",product_price);
					req.setAttribute("product_status",product_status);
					req.setAttribute("product_desc",product_desc);
					req.setAttribute("product_content",product_content);
					req.setAttribute("product_discount",product_discount);
					List<Catalog> cateList = cateService.getAll();
					req.setAttribute("catelist", cateList);
					req.getRequestDispatcher("/view/admin/product/addproduct.jsp").forward(req, resp);
					return;
				}
			} catch (NumberFormatException e) {
				req.setAttribute("error3", "Vui lòng nhập số");
				req.setAttribute("product-cate",product_cate);
				req.setAttribute("product_name",product_name);
				req.setAttribute("product_price",product_price);
				req.setAttribute("product_status",product_status);
				req.setAttribute("product_desc",product_desc);
				req.setAttribute("product_content",product_content);
				req.setAttribute("product_discount",product_discount);
				List<Catalog> cateList = cateService.getAll();
				req.setAttribute("catelist", cateList);
				req.getRequestDispatcher("/view/admin/product/addproduct.jsp").forward(req, resp);
				return;
			}
			
			Part filePart = req.getPart("product-image");
			final String dirPartName = req.getServletContext().getRealPath("/files");
			File dirFile = new File(dirPartName);
			if(!dirFile.exists()){
				dirFile.mkdirs();
			}
			String fileName = FileUtil.getName(filePart);
			String picture = FileUtil.rename(fileName);
			String filePathName = dirPartName + File.separator + picture;
			System.out.println(filePathName);
			
			Product product = new Product();
			product.setCatalog_id(product_cate);
			product.setName(product_name);
			product.setPrice(product_price);
			product.setStatus(product_status);
			product.setDescription(product_desc);
			product.setContent(product_content);
			product.setDiscount(product_discount);
			product.setImage_link(picture);
			product.setCreated(product_day);
			productService.insert(product);
			if(!fileName.isEmpty()){
				filePart.write(filePathName);
			}
			resp.sendRedirect(req.getContextPath() + "/admin/product/list?msg=1");

	}
}
