<%@page import="giadung.webmvc.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	
	HttpSession session2 = request.getSession();
	Object userLoginObj = session.getAttribute("userLogin");
	if (userLoginObj == null) {
		response.sendRedirect(request.getContextPath() + "/view/client/login");
	} else {
		User userLogin = (User) userLoginObj;
		if (!userLogin.getRole().equals("Admin")) {
			response.sendRedirect(request.getContextPath() + "/");
		}
}
%>

<!-- Start header section -->
<jsp:include page="../header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-12">
				<button class="add-catalog">
					<a href="${pageContext.request.contextPath}/admin/product/add">Thêm
						sản phẩm</a>
				</button>
			</div>
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Danh sách sản phẩm</h5>
						<form action="">
						<button>tìm kiếm</button>
						</form>
						<c:if test="${ param.msg == 1 }">
							<div id="alert" class="alert">
								<!-- Nội dung thông báo -->
								Thêm sản phẩm thành công

								<!-- Nút đóng thông báo -->
								<span class="closebtn" onclick="closeAlert()">&times;</span>
							</div>
						</c:if>
						<c:if test="${ param.msg == 2 }">
							<div id="alert" class="alert">
								<!-- Nội dung thông báo -->
								Cập nhật sản phẩm thành công

								<!-- Nút đóng thông báo -->
								<span class="closebtn" onclick="closeAlert()">&times;</span>
							</div>
						</c:if>
						<c:if test="${ param.msg == 3 }">
							<div id="alert" class="alert">
								<!-- Nội dung thông báo -->
								Xoá sản phẩm thành công

								<!-- Nút đóng thông báo -->
								<span class="closebtn" onclick="closeAlert()">&times;</span>
							</div>
						</c:if>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Tên sản phẩm</th>
										<th scope="col">Hình ảnh</th>
										<th scope="col">ID danh mục</th>
										<th scope="col">Giá</th>
										<th scope="col">Status</th>
										<th scope="col">Giảm giá</th>
										<th scope="col">Ngày tạo</th>
										<th scope="col">Hành động</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="product">
										<tr>
											<th scope="row">${product.id }</th>
											<td>${product.name }</td>
											<td><img
												style="width: 110px; height: 67px; object-fit: cover; border: 1px solid #fff;"
												src="<%=request.getContextPath() %>/files/${product.image_link}"></td>
											<td>${product.catalog_id }</td>
											<td><c:set var="p" value="${product.price }" /> <fmt:setLocale
													value="vi_VN" /> <fmt:formatNumber value="${p}"
													type="currency" maxFractionDigits="0" /></td>
											<td><c:choose>
													<c:when test="${product.status == 1}">
														<c:out value="Còn hàng" />
													</c:when>
													<c:otherwise>
														<c:out value="Hết hàng" />
													</c:otherwise>
												</c:choose></td>
											<td>${product.discount }%</td>
											<td>${product.created }</td>
											<td>
												<button class="btn btn-success">
													<a
														href="${pageContext.request.contextPath}/admin/product/edit?id=${product.id}">Sửa</a>
												</button>
												<button class="btn btn-danger">
													<a
														href="${pageContext.request.contextPath}/admin/product/delete?id=${product.id}">Xóa</a>
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

		<div class="overlay toggle-menu"></div>
		<div>
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<c:forEach begin="1" end="${endPage}" var="i">
						<li class="page-item"><a class="page-link" id="${i}"
							href="${pageContext.request.contextPath}/admin/product/list?index=${i}">${i}</a>
						</li>
					</c:forEach>

				</ul>
			</nav>
		</div>
	</div>

</div>
<script type="text/javascript">
	document.getElementById('${index}').style.color = "red";
	document.getElementById('${index}').style.fontWeight = "bold";
</script>



<jsp:include page="../footer/footer.jsp" flush="true" />