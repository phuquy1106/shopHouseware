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
        <h2>Tìm kiếm sản phẩm</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>         
          <li style="color:#fff">Kết quả tìm kiếm</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

  <!-- product category -->
  <section id="aa-product-category">
    <div class="container">
      <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-8 col-md-push-3">
          <div class="aa-product-catg-content">
            <div class="aa-product-catg-body">
            
            	<c:choose>
	            	<c:when test="${empty productlist}"> 
	                   <p style="display:none;">Kết quả tìm kiếm cho từ khóa: <strong>${param.s}</strong></p>
	                </c:when>
	                <c:otherwise>
				       <p style="margin-bottom:30px;">Kết quả tìm kiếm cho từ khóa: <strong>${param.s}</strong></p>
				    </c:otherwise>
               </c:choose>
              
              <ul class="aa-product-catg">
                <!-- start single product item -->
                <c:if test="${empty productlist}">
                 	<p style="margin-left: 30px">Không tìm thấy sản phẩm!</p>
                 </c:if>
               
                <c:forEach items="${productlist}" var="product">
 					 <c:if test="${product.status==1}">
	                <li>
	                  <figure>
	                    <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}"><img src="<%=request.getContextPath() %>/files/${product.image_link}" alt="${product.name}"></a>
	                    <a class="aa-add-card-btn" href="javascript:void(0)" onclick="return getOrder(${product.id})"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
	                    <figcaption>
	                      <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name}</a></h4>
	                      
	                    <c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price"><c:set var="p" value="${product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/></span><span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price"><c:set var="p" value="${product1.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/></span>
		                    </br>  <span class="aa-product-price"><del><c:set var="p" value="${product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/></del></span>
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
	                </c:if>
                </c:forEach>                                       
              </ul>
                
            </div>
          </div>
          <div>
	                <nav aria-label="Page navigation example">
	  				<ul class="pagination">
	  				
	    				 <li class="page-item">
	    				 <c:forEach begin="1" end="${endPage1}" var="i">
	    				 <a class="page-link" id="${i}" href="${pageContext.request.contextPath}/view/client/product/search?index=${i}&s=${name}">${i}</a>	
	    				  </c:forEach></li> 
	    			
	 			 </ul>
					</nav></div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
          <aside class="aa-sidebar">
            <!-- single sidebar -->
            <div class="aa-sidebar-widget">
              <h3>Danh mục</h3>
              <ul class="menu">
              <c:forEach items="${catelist}" var="cate">
              	<li><a id="${i}" href="${pageContext.request.contextPath}/view/client/product-id?id=${cate.id}">${cate.name}</a></li>
              </c:forEach>                
              </ul>
            </div>
          
          <script type="text/javascript">
							function getOrder(id) {
								$.ajax({
									url: '<%=request.getContextPath()%>/view/client/add-cart?product-id='+ id,
									type: 'POST',
									cache: false,
									data:{
										
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
		
            <!-- single sidebar -->
            <div class="aa-sidebar-widget">
              <h3>Sản phẩm gần đây</h3>
              <div class="aa-recently-views">
                <ul>
                 <c:forEach items="${product_all}" var="product" end="3">
                   <c:if test="${product.status==1}">
                  <li>
                    <a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}" class="aa-cartbox-img"><img  src="<%=request.getContextPath() %>/files/${product.image_link}"></a>
                    <div class="aa-cartbox-info">
                      <h4><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                      <c:choose>
						<c:when test="${product.discount == 0}">
	                        <p><del><c:set var="p" value="${product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/>
								</del></p>
	                    </c:when>
	                    <c:otherwise>
	                    

	                    
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                       <p><c:set var="p" value="${product1.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/></p>
								<p><del><c:set var="p" value="${product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/><del></p>
	                      </c:if>
	                      </c:forEach>
	                    </c:otherwise>
	                     </c:choose>
                    
                    </div>                    
                  </li>
                  </c:if>
                  </c:forEach>
                </ul>
              </div>                                 
            </div>
            <!-- single sidebar -->
           
          </aside>
        </div>
       
      </div>
    </div>
  </section>
   <script type="text/javascript">
		document.getElementById('${index}').style.color="red";
		document.getElementById('${index}').style.fontWeight = "bold";
    </script>
  <!-- / product category -->
<!--  end content-->
  
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
 

  
