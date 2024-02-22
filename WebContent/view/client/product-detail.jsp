<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  <!-- / header section -->
  
<!--  content -->
   <!-- catg header banner section -->
  <section id="aa-catg-head-banner">
     <img src="${pageContext.request.contextPath}/view/client/assets/images/bg_giohang.jpg" width="100%" height="350px" alt="banner sản phẩm">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Chi tiết sản phẩm</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>         
          <li><a href="${pageContext.request.contextPath}/view/client/product">Sản phẩm</a></li>
          <li style="color:#fff">${detail_product.name }</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

  <!-- product category -->
  <section id="aa-product-details">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-product-details-area">
            <div class="aa-product-details-content">
              <div class="row">
                <!-- Modal view slider -->
             
                <div class="col-md-5 col-sm-5 col-xs-12">                              
                  <div class="aa-product-view-slider">                                
                    <div id="demo-1" class="simpleLens-gallery-container">
                      <div class="simpleLens-container">
                        <div class="simpleLens-big-image-container"><a data-lens-image="<%=request.getContextPath() %>/files/${detail_product.image_link}" class="simpleLens-lens-image"><img src="<%=request.getContextPath() %>/files/${detail_product.image_link}" class="simpleLens-big-image"></a></div>
                      </div>
                    
                    </div>
                  </div>
                </div>
                <!-- Modal view content -->

                <div class="col-md-7 col-sm-7 col-xs-12">
                  <div class="aa-product-view-content">
                    <h3>${detail_product.name }</h3>
                    <div class="aa-price-block">
                    <c:choose>
						<c:when test="${detail_product.discount == 0}">
	                      <span class="aa-product-price">
	                      <c:set var="p" value="${detail_product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/> </strong></span>
	                     <span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == detail_product.id}">
		                      <span class="aa-product-price"><strong><c:set var="p" value="${product1.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/> </strong></span>
		                     </br>
		                      <span class="aa-product-price"><del>
		                      <c:set var="p" value="${detail_product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/> 
		                      </del></span>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
                   
                  
                    </div>
                    <p>${detail_product.description}</p>
                    <div class="aa-prod-quantity">                  
                     
                      <p class="aa-prod-category">
                       <c:forEach items="${name_cate_of_product}" var="name_cate">
                        <strong>Danh mục:</strong> <a href="product.jsp">${name_cate.name }</a>
                        </c:forEach>
                      </p>
                    </div>
                    <div class="dc_quantity_input">
                        <input type="number" id="quantity" class="input-text qty text" step="1" min="1" max="" name="quantity" value="1" title="SL" size="4" pattern="[0-9]*" inputmode="numeric" aria-labelledby="GST-S110-1ADR số lượng"  style="width: 50px"/>
                    </div>
                    <div class="aa-prod-view-bottom">
                      <a class="aa-add-to-cart-btn" href="javascript:void(0)" onclick="return getOrder(${detail_product.id})">Thêm vào giỏ hàng</a>
                    </div>
                  </div>
                </div>
              </div>

            </div>
            <div class="aa-product-details-bottom">
              <ul class="nav nav-tabs aa-products-tab" id="myTab2">
                <li class="active"><a href="#description" data-toggle="tab" class="">Mô tả</a></li>
                <li><a href="#review" data-toggle="tab">Đánh giá</a></li>                
              </ul>

              <!-- Tab panes -->
              <div class="tab-content">
                <div class="tab-pane fade in active" id="description">
                  <p>${detail_product.content }</p>
                </div>
                <div class="tab-pane fade " id="review">
                 <div class="aa-product-review-area">
                   <ul class="aa-review-nav">
                   <c:forEach items="${reviewbyid}" var="review" >
                     <li>
                        <div class="media">
                          <div class="media-body">
                            <h4 class="media-heading"><strong>${review.name}</strong> - <span>${review.created}</span></h4>
                         
                            <p>${review.content}</p>
                          </div>
                        </div>
                      </li>
                      </c:forEach>
                   </ul>
                   <h4>Thêm đánh giá</h4>
                  
                   <!-- review form -->
                   <form action="${pageContext.request.contextPath}/view/client/review?id=${detail_product.id}" method="post" class="aa-review-form">
                      <div class="form-group">
                        <label for="name">Tên</label>
                        <input type="text" class="form-control" id="name" required="required" placeholder="Name" name="name">
                      </div>  
                      <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email"  placeholder="example@gmail.com" name="email">
                      </div>
                      <div class="form-group">
                        <label for="message">Đánh giá của bạn</label>
                        <textarea class="form-control" rows="3" id="content" required="required" name="content"></textarea>
                      </div>

                      <button type="submit" class="btn btn-default aa-review-submit">Gửi</button>
                   </form>
                 </div>
                </div>            
              </div>
            </div>
            <!-- Related product -->
            <div class="aa-product-related-item">
              <h3>SẢN PHẨM LIÊN QUAN</h3>
              <ul class="aa-product-catg aa-related-item-slider">
                <!-- start single product item -->
                <c:forEach items="${productById}" var="product">
	                <li>
	                  <figure>
	                    <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}"><img src="<%=request.getContextPath() %>/files/${product.image_link}" ></a>
	                    <a class="aa-add-card-btn" href="javascript:void(0)" onclick="return getOrder(${product.id})"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
	                     <figcaption>
	                      <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name}</a></h4>
	                     
						<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price"><c:set var="p" value="${product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/> </span><span class="aa-product-price"></span> 
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price"> <span class="aa-product-price"><c:set var="p" value="${product1.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/> </span><span class="aa-product-price"></span>
		                      </br>	 <span class="aa-product-price"> <span class="aa-product-price">
		                      <del>
		                     
		                      <c:set var="p" value="${product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/>
								</del> </span><span class="aa-product-price"></span>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
	                    </figcaption>
	                  </figure>                     
	                
	                   <c:if test="${product.discount != 0}">
	                  	<!-- product badge -->
	                  <span class="aa-badge aa-sale">- ${product.discount}%</span>
	                  </c:if>
	                </li>
                </c:forEach>
                 <!-- start single product item -->                                                                                   
              </ul>
             
            </div>  
          </div>
        </div>
      </div>
    </div>
  </section>
  <script type="text/javascript">
							function getOrder(id) {
								var quantity = $("#quantity").val();
								if (quantity === "0" || quantity < 0) {
								    alert('Số lượng không hợp lệ');
								    return false;
								  }
								$.ajax({
									url: '<%=request.getContextPath()%>/view/client/add-cart?product-id='+ id,
									type: 'POST',
									cache: false,
									data:{
										aquantity:quantity
										},
									success: function(data) {
										$(".num").html(data);
										alert('Thêm vào giỏ hàng thành công');
									},
									error: function() {
										alert('Có lỗi xảy ra');
									}
									});
								return false;
							}
	                      </script>
  <!-- / product category -->
<!--  end content-->
  
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
 
  
