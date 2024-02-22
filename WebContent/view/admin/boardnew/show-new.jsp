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
					<a href="${pageContext.request.contextPath}/admin/new/add">Thêm
						tin tức</a>
				</button>
			</div>
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Danh sách tin tức</h5>
						
						
						
						<c:if test="${ param.msg == 1 }">
						<div id="alert" class="alert">
						    <!-- Nội dung thông báo -->
						    Thêm tin tức thành công
						
						    <!-- Nút đóng thông báo -->
						    <span class="closebtn" onclick="closeAlert()">&times;</span>
						</div>
						</c:if>
						<c:if test="${ param.msg == 2 }">
						<div id="alert" class="alert">
						    <!-- Nội dung thông báo -->
						    Cập nhật tin tức thành công
						
						    <!-- Nút đóng thông báo -->
						    <span class="closebtn" onclick="closeAlert()">&times;</span>
						</div>
						</c:if>
						<c:if test="${ param.msg == 3 }">
						<div id="alert" class="alert">
						    <!-- Nội dung thông báo -->
						    Xoá tin tức thành công
						
						    <!-- Nút đóng thông báo -->
						    <span class="closebtn" onclick="closeAlert()">&times;</span>
						</div>
						</c:if>

						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Tiêu đề</th>
										<th scope="col">Nội dung</th>
										<th scope="col">Hình ảnh</th>
										<th scope="col">Ngày đăng</th>
										<th scope="col">Hành động</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${boardnewlist}" var="boardnew">
										<tr>
											<td scope="row">${boardnew.id}</td>
											<td>${boardnew.title}</td>
											<td>
											<c:if test="${boardnew.content.length() > 50}">
												${boardnew.content.substring(0, 50)}...
											</c:if>
											<c:if test="${boardnew.content.length() < 51}">
												${boardnew.content}
											</c:if>
											</td>
											<td><img
												style="width: 110px; height: 67px; object-fit: cover; border: 1px solid #fff;"
												src="<%=request.getContextPath() %>/files/${boardnew.image_link}"></td>
											<td>${boardnew.created}</td>
											<td>
											<button class="btn btn-success">
													<a
														href="${pageContext.request.contextPath}/admin/new/edit?id=${boardnew.id}">Sửa</a>
												</button>
												<button class="btn btn-danger">
													<a
														href="${pageContext.request.contextPath}/admin/new/delete?id=${boardnew.id}">Xóa</a>
												</button>

												
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:forEach begin="1" end="${endPage}" var="i">
								<li class="page-item"><a class="page-link" id="${i}"
									href="${pageContext.request.contextPath}/admin/new/list?index=${i}">${i}</a>
								</li>
							</c:forEach>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	document.getElementById('${index}').style.color = "red";
	document.getElementById('${index}').style.fontWeight = "bold";
</script>
<jsp:include page="../footer/footer.jsp" flush="true" />