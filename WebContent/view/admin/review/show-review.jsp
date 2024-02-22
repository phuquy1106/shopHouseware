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
        <!--End Row-->

          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Danh sách Review</h5>
                <c:if test="${ param.msg == 3 }">
						<div id="alert" class="alert">
						    <!-- Nội dung thông báo -->
						    Xoá bình luận thành công
						
						    <!-- Nút đóng thông báo -->
						    <span class="closebtn" onclick="closeAlert()">&times;</span>
						</div>
						</c:if>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Email</th>
                        <th scope="col">Id Sản Phẩm</th>
                        <th scope="col">Nội dung</th>
                        <th scope="col">Ngày đánh giá</th>
                        <th scope="col">Hành động</th>
                      </tr>
                    </thead>
                    <tbody>
                  <c:forEach items="${reviewlist}" var="review">
                      <tr>
                        <td scope="row">${review.id}</td>
                        <td>${review.name}</td>
        				<td>${review.email}</td>
        				<td>${review.product_id}</td>
        				<td>${review.content}</td>
        				<td>${review.created}</td>
        				 <td>
                         <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/review/delete?id=${review.id}">Xóa</a></button>
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
      </div>
    </div>
 
    <jsp:include page = "../footer/footer.jsp" flush = "true" />