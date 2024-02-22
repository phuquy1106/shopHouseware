<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Start header section -->
  <jsp:include page = "../header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Chuyên mục: Đổi mật khẩu</div>
                <hr>
	         <form action="${pageContext.request.contextPath}/admin/editpass"  method="post"> 
	         
	         <div class="form-group">
	                    <label for="passcu">Mật khẩu cũ</label>
	                    <input type="password" class="form-control"  id="passcu"  name="passcu" >
	                  </div>
	                  <div class="form-group">
	                    <label for="passmoi">Mật khẩu mới</label>
	                    <input type="password" class="form-control" id="passmoi"  name="passmoi" ">
	                  </div>
	                    <div class="error">${error2} </div>
	                     <div class="error">${error3} </div>
	                  <div class="form-group">
	                    <label for="passlai">Nhập lại mật khẩu</label>
	                    <input type="password" class="form-control" id="passlai"  name="passlai" ">
	                  </div>
	                  <div class="error">${error} </div>
	                    <p style="color:red; display: block;"><%=(request.getAttribute("errMessage") == null) ? ""
        			: request.getAttribute("errMessage")%></p>
			        <p style="color:green; display: block;"><%=(request.getAttribute("Message") == null) ? ""
			        : request.getAttribute("Message")%></p>  
			           <p style="color:red; display: block;"><%=(request.getAttribute("errMessage2") == null) ? ""
        			: request.getAttribute("errMessage2")%></p>
		           <div class="form-footer">
	                 <a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/homepage">Huỷ</a>
	                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Sửa </button>
	                </div> 
	               
	                </form>
	                 
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>
  
    <jsp:include page = "../footer/footer.jsp" flush = "true" />