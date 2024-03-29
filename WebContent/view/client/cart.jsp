
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
             <form action="${pageContext.request.contextPath}/view/client/cart-update" method="post">
               <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Bỏ chọn</th>
                        <th>Mô tả</th>
                        <th>Sản phẩm</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                        <th>Giảm giá</th>
                        <th>Thành Tiền</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:if test="${order.items == null }">
               			<c:set value="0" var="sumprice"> </c:set>
               		</c:if>
                      <c:forEach items="${order.items}" var="item">
                      <tr>
                        <td><a class="remove" href="${pageContext.request.contextPath}/view/client/cart-delete?id=${item.product.id}"><fa class="fa fa-close"></fa></a></td>
                        <td><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${item.product.id}"><img src="<%=request.getContextPath() %>/files/${item.product.image_link}" alt="img${item.product.name }"></a></td>
                        <td><a class="aa-cart-title" href="${pageContext.request.contextPath}/view/client/product-detail?id=${item.product.id}">${item.product.name }</a></td>
                        <td><c:set var="p" value="${item.product.price}"/>
						<fmt:setLocale value="vi_VN"/>
						<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/>
                       </td>
                        <td><input class="aa-cart-quantity" type="number" name="qty${item.product.id}" value="${item.qty}" min=1></td>
                        <td>${item.product.discount} %</td>
                        <td>
                         <c:set var="p" value="${item.price}"/>
						<fmt:setLocale value="vi_VN"/>
						<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/>
                        </td>
                      </tr>
          			 </c:forEach>
          			 <tr>
                        <td colspan="6" class=""><strong>TỔNG TIỀN</strong></td>
                        
                       <td><strong>
                       <c:set var="p" value="${sumprice}"/>
						<fmt:setLocale value="vi_VN"/>
						<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/> 
                       </strong></td>
                      </tr>
                      
               		
                      <tr>
                      	<c:if test="${order.items != null }">
	                        <td colspan="7" class="aa-cart-view-bottom">
	                          <input class="aa-cart-view-btn" type="submit" value="Cập nhật giỏ hàng">
	                        </td>
                        </c:if>
                      </tr>
                     
                      </tbody>
                  </table>
                  </div>
             </form>
             <!-- Cart Total view -->
             <div class="cart-view-total">
               <h4>Thông tin giỏ hàng</h4>
               <table class="aa-totals-table">
                 <tbody>
                   <tr>
                     <th>Tạm tính</th>
                     <td> <c:set var="p" value="${sumprice}"/>
						<fmt:setLocale value="vi_VN"/>
						<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/></td>
                   </tr>
               
                   <tr>
                     <th>Tổng cộng</th>
                     
                    <td><strong>   <c:set var="p" value="${sumprice}"/>
						<fmt:setLocale value="vi_VN"/>
						<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/>
                    </strong></td>
                   </tr>
                 </tbody>
               </table>
               <c:if test="${order.items != null }">
               		<a href="${pageContext.request.contextPath}/view/client/checkout" class="aa-cart-view-btn">Thanh toán</a>
               </c:if>
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
