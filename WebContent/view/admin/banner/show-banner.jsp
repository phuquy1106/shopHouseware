<%@page import="giadung.webmvc.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<jsp:include page="../header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">
		<!--End Row-->


		<div class="row">
			<div class="col-lg-12">
				<button class="add-catalog">
					<a href="${pageContext.request.contextPath}/admin/banner/add">Thêm
						Banner</a>
				</button>
			</div>
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Danh sách Banner</h5>
							<c:if test="${ param.msg == 1 }">
						<div id="alert" class="alert">
						    <!-- Nội dung thông báo -->
						    Thêm banner thành công
						
						    <!-- Nút đóng thông báo -->
						    <span class="closebtn" onclick="closeAlert()">&times;</span>
						</div>
						</c:if>
						<c:if test="${ param.msg == 2 }">
						<div id="alert" class="alert">
						    <!-- Nội dung thông báo -->
						    Cập nhật banner thành công
						
						    <!-- Nút đóng thông báo -->
						    <span class="closebtn" onclick="closeAlert()">&times;</span>
						</div>
						</c:if>
						<c:if test="${ param.msg == 3 }">
						<div id="alert" class="alert">
						    <!-- Nội dung thông báo -->
						    Xoá banner thành công
						
						    <!-- Nút đóng thông báo -->
						    <span class="closebtn" onclick="closeAlert()">&times;</span>
						</div>
						</c:if>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Name</th>
										<th scope="col">Ghi chú</th>
										<th scope="col">Hình ảnh</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bannerList}" var="banner">
										<tr>
											<td scope="row">${banner.id}</td>
											<td>${banner.name}</td>
											<td>${banner.note}</td>
											<td><img
												style="width: 110px; height: 67px; object-fit: cover; border: 1px solid #fff;"
												src="<%=request.getContextPath() %>/files/${banner.img}"></td>

											<td>
												<button class="btn btn-success">
													<a
														href="${pageContext.request.contextPath}/admin/banner/edit?id=${banner.id}">Sửa</a>
												</button>
												<button class="btn btn-danger">
													<a
														href="${pageContext.request.contextPath}/admin/banner/delete?id=${banner.id}">Xóa</a>
												</button>


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

<jsp:include page="../footer/footer.jsp" flush="true" />