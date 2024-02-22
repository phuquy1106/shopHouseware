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
		<!--End Row-->


		<div class="row">

			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Danh sách đơn hàng</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Tên khách hàng</th>

										<th scope="col">Sản phẩm</th>

										<th scope="col">Email</th>

										<th scope="col">Địa chỉ</th>

										<th scope="col">Tổng tiền</th>

										<th scope="col">Trạng thái</th>


									</tr>
								</thead>
								<tbody>
									<c:forEach items="${order}" var="order">
										<tr>
											<td scope="row">${order.id}</td>
											<td>${order.user_name}</td>

											<td><c:forEach items="${listOrder}" var="Order">
													<c:if test="${Order.transaction_id == order.id }">
	                 							${Order.product_id} (x ${Order.qty}) <br />
													</c:if>
												</c:forEach></td>

											<td>${order.user_mail}</td>

											<td>${order.address}</td>

											<td><c:set var="p" value="${order.amount}" /> <fmt:setLocale
													value="vi_VN" /> <fmt:formatNumber value="${p}"
													type="currency" maxFractionDigits="0" /></td>



											<td class="xacnhan${order.id}"><c:if
													test="${order.status.equals('Chưa xác nhận')}">
													<a href="javascript:void(0)"
														style="background: red; padding: 5px; border-radius: 5px;"
														onclick="return getXacnhan(${order.id})">${order.status}</a>
												</c:if> <c:if test="${!order.status.equals('Chưa xác nhận')}">
                          	  	${order.status}
                          	  </c:if></td>

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
<script type="text/javascript">
								function getXacnhan(id) {
									$.ajax({
										url: '<%=request.getContextPath()%>/admin/order/list',
										type: 'POST',
										cache: false,
										data:{
											aid:id,
											},
										success: function(data) {
											$(".xacnhan" + id).html(data);
										},
										error: function() {
											alert('Có lỗi xảy ra');
										}
										});
									return false;
							}
	                      </script>
<jsp:include page="../footer/footer.jsp" flush="true" />