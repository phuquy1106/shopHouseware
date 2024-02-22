<%@page import="giadung.webmvc.model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma" , "no-cache");
	response.setHeader("Expires" , "0");
	
	HttpSession session2 = request.getSession();
	Object userLoginObj = session.getAttribute("userLogin");
	if (userLoginObj==null){
		  response.sendRedirect(request.getContextPath() + "/view/client/login");
	}
	else{
		  User userLogin = (User) userLoginObj;
		  if (!userLogin.getRole().equals("Admin") ) {
	        response.sendRedirect(request.getContextPath() + "/");
	    }
	}
  %>
  
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>


  
    <jsp:include page = "./footer/footer.jsp" flush = "true" />