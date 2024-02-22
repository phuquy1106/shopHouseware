<%@page import="giadung.webmvc.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <jsp:include page = "../header/header.jsp" flush = "true" />
  
    <div class="content-wrapper">
      <div class="container-fluid">

		<div class="dropdown">
		  
		  <div class="dropdown-content">
		    <a <c:if test="${role.equals('User') }">id="${role}"</c:if>  href="${pageContext.request.contextPath}/admin/user/list?role=User" >User</a>
		   ||| <a <c:if test="${role.equals('Admin') }">id="${role}"</c:if> href="${pageContext.request.contextPath}/admin/user/list?role=Admin">Admin</a>
		  </div>
		</div>
			<c:if test="${ param.msg == 1 }">
						<div id="alert" class="alert">
						    <!-- Nội dung thông báo -->
						    Thêm người dùng thành công
						
						    <!-- Nút đóng thông báo -->
						    <span class="closebtn" onclick="closeAlert()">&times;</span>
						</div>
						</c:if>
						<c:if test="${ param.msg == 2 }">
						<div id="alert" class="alert">
						    <!-- Nội dung thông báo -->
						    Cập nhật người dùng thành công
						
						    <!-- Nút đóng thông báo -->
						    <span class="closebtn" onclick="closeAlert()">&times;</span>
						</div>
						</c:if>
						<c:if test="${ param.msg == 3 }">
						<div id="alert" class="alert">
						    <!-- Nội dung thông báo -->
						    Xoá người dùng thành công
						
						    <!-- Nút đóng thông báo -->
						    <span class="closebtn" onclick="closeAlert()">&times;</span>
						</div>
						</c:if>
        <div class="row mt-3">
          <div class="col-lg-12">
            <button class="add-catalog"><a href="${pageContext.request.contextPath}/admin/user/add">Thêm</a></button>
          </div>
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Danh sách User</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tên</th>
                        <c:if test="${!role.equals('Admin') }">
                        <th scope="col">Email</th>
                        <th scope="col">Số điện thoại</th>
                        </c:if>
                        <th scope="col">Username</th>
                        <th scope="col">Ngày tạo</th>
                        <th scope="col">Chức vụ</th> 
                         <th scope="col">Hành động</th>
             
                      </tr>
                    </thead>
                    <tbody>
                  <c:forEach items="${userList}" var="user">
                      <tr>
                        <td scope="row">${user.id}</td>
                        <td>${user.name }</td>
                        <c:if test="${!role.equals('Admin') }">
        				<td>${user.email }</td>
        				<td>${user.phone }</td>
        				</c:if>
        				<td>${user.username }</td>
        				<td>${user.created }</td>
        				<td>${user.role }</td>
        				 <td>
        				 
                      
                          <button class="btn btn-success"><a  href="${pageContext.request.contextPath}/admin/user/edit?user-id=${user.id}">Sửa</a></button>
                  		<c:if test="${role.equals('User')}">
                         <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/user/delete?user-id=${user.id}">Xóa</a></button>
                        </c:if>
                        </td>
                     </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>

  <script type="text/javascript">
		document.getElementById('${role}').style.color="red";
		document.getElementById('${role}').style.fontWeight = "bold";
    </script>
    <jsp:include page = "../footer/footer.jsp" flush = "true" />