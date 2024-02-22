<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Start header section -->
  <jsp:include page = "../header/header.jsp" flush = "true" />

    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Thêm User</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/user/add" method="post">
                
                  <div class="form-group">
                    <label for="input-1">Họ tên</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Nhập họ tên" name="user-name" value="${user.name}">
                  </div>
                  <div class="form-group">
                    <label for="input-2">Email</label>
                    <input type="text" class="form-control" id="input-3" placeholder="Nhập địa chỉ Email" name="user-email" value="${user.email}">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Số Điện Thoại</label>
                    <input type="text" class="form-control" id="input-4" placeholder="Nhập số điện thoại" name="user-phone" value="${user.phone}">
                  </div>
                  <div class="form-group">
                    <label for="input-3">UserName</label>
                    <div class="error">${error3}</div>
                    <input type="text" class="form-control" id="input-5" placeholder="Nhập User Name" name="user-userName" value="${user.username}">
                  </div>
                  <div class="form-group">
                    <label for="input-4">Mật khẩu</label>
                    <input type="password" class="form-control" id="myinput" placeholder="Nhập mật khẩu" name="user-password">
                    <div class="error">${error2}</div>
					<input type="checkbox" onclick="myFunction1()">Hiển thị mật khẩu
					<script>function myFunction1() {
                    	  var x = document.getElementById("myinput");
                    	  if (x.type === "password") {
                    	    x.type = "text";
                    	  } else {
                    	    x.type = "password";
                    	  }
                    	}
					</script> 
					<div class="form-group">
					<br />
                    <label for="input-3">Chức Vụ</label><br />
                    
                    <input type="radio" id="user" name="role" value="User">
					  <label for="html">User</label>
					  <input type="radio" id="admin" name="role" value="Admin" checked="checked">
					  <label for="css">Admin</label>
                  </div>                  
                  </div>
                  <div class="error">${error}</div>
               
                  <div class="form-group">
                       <a  class="btn btn-danger" href="${pageContext.request.contextPath}/admin/user/list"><i class="fa fa-times"></i> Hủy</a>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Thêm</button>
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