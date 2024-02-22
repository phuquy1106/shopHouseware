
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  <!-- / header section -->

<!--  content -->
<!-- catg header banner section -->
  <section id="aa-catg-head-banner">
   <img src="${pageContext.request.contextPath}/view/client/assets/images/banner-cart.png" alt="banner giỏ hàng">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Giỏ hàng</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}">Trang chủ </a></li>
          <li style="color:#fff">Thông tin giỏ hàng</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

 <!-- Cart view section -->
 <section id="cart-view">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="cart-view-area">
           <div class="cart-view-table">
               <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th>#</th>
                        <th>Tên sản phẩm</th>
                        <th>Tổng giá tiền</th>
                        <th>Ngày đặt hàng</th>
                        <th>Địa chỉ giao hàng</th>
                        <th>Phương thức thanh toán</th>
                        <th>Trạng thái</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listTra}" var="Tra">
	                    <tr>
	                 		<td>${Tra.id}</td>
	                 		<td>
	                 			<c:forEach items="${listOrder}" var="Order">
	                 				<c:if test="${Order.transaction_id == Tra.id }">
	                 							${Order.product_id} (x ${Order.qty}) <br />
	                 				</c:if>
	                 			</c:forEach>
	                 		</td>
	                 		<td>
	                 		<c:set var="p" value="${Tra.amount}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/> </span><span class="aa-product-price">
	                 		</td>
	                 		<td>${Tra.created}</td>
	                 		<td>${Tra.address}</td>
	                 		<td>
	                 			<c:if test="${Tra.payment == 1}">
	                 				Chuyển khoản
	                 			</c:if>
	                 			<c:if test="${Tra.payment != 1}">
	                 				Trực Tiếp
	                 			</c:if>
	                 		</td>
	                 		<td>${Tra.status}</td>  
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
 </section>
 <!-- / Cart view section -->

<!--  end content-->
  
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
