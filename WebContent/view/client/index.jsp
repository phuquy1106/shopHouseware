<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value = "/view/client/assets" var="url"/>
  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  <!-- / header section -->
  <!-- Start slider -->
  <jsp:include page = "./banner-slider/slider.jsp" flush = "true" />
  <!-- / slider -->
  
  	
  <!-- / Promo section -->
  <!-- Products section -->
 

  <!-- popular section -->
  <section id="aa-popular-category">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="row">
            <div class="aa-popular-category-area">
              <!-- start prduct navigation -->
             <ul class="nav nav-tabs aa-products-tab" >
                <li class="active"><a href="#sanphammoi" data-toggle="tab">Sản Phẩm Mới</a></li>
                <li><a href="#sanphambanchay" data-toggle="tab">Sản Phẩm Bán Chạy</a></li>
                <li><a href="#sanphamgiamgia" data-toggle="tab">Sản Phẩm Giảm Giá</a></li>                    
              </ul>
              <!-- Tab panes -->
              <div class="tab-content">
                <!-- Start men popular category -->
                <div class="tab-pane fade in active" id="sanphammoi">
                  <ul class="aa-product-catg aa-popular-slider">
                    <!-- start single product item -->
                   	 <c:forEach items="${product_new}" var="product">
                   	   <c:if test="${product.status==1}">
                        <li class="ds">
                          <figure>
                            <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}"><img src="<%=request.getContextPath() %>/files/${product.image_link}" ></a>
                            <a class="aa-add-card-btn" href="javascript:void(0)" onclick="return getOrder(${product.id})"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                            	<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price">
	                       	<c:set var="p" value="${product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/>
	                      </span><span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price">
		                      	<c:set var="p" value="${product1.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/> 
								</span>
		                   </br>   <span class="aa-product-price">
		                      <del>
		                      <c:set var="p" value="${product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/> 
		                      </del>
		                      </span>
	                      </c:if>
	                      </c:forEach>
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
                        <!-- start single product item -->
                     <!-- start single product item -->
                                                                                         
                  </ul>
                
                </div>
                <!-- / popular product category -->
                
                <!-- start featured product category -->
                <div class="tab-pane fade" id="sanphambanchay">
                	<ul class="aa-product-catg aa-popular-slider">
                    <!-- start single product item -->
                   	 <c:forEach items="${listbanchay}" var="product" end="4">
                   	   <c:if test="${product.status==1}">
                        <li>
                          <figure>
                            <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}"><img src="<%=request.getContextPath() %>/files/${product.image_link}" ></a>
                            <a class="aa-add-card-btn"href="javascript:void(0)" onclick="return getOrder(${product.id})""><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                             	<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price">${product.price} </span><span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price">
		                      	<c:set var="p" value="${product1.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/>  </span>
		                     </br> <span class="aa-product-price"><del>
		                      	<c:set var="p" value="${product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/>  </del></span>
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
                        <!-- start single product item -->
                     <!-- start single product item -->
                                                                                         
                  </ul>
                 
                </div>
                <!-- / featured product category -->

                <!-- start latest product category -->
                <div class="tab-pane fade" id="sanphamgiamgia">
                  
                  	<ul class="aa-product-catg aa-popular-slider">
                    <!-- start single product item -->
                   	 <c:forEach items="${product_sale}" var="product">
                   	   <c:if test="${product.status==1}">
                        <li>
                          <figure>
                            <a class="aa-product-img" href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}"><img src="<%=request.getContextPath() %>/files/${product.image_link}" ></a>
                            <a class="aa-add-card-btn"href="javascript:void(0)" onclick="return getOrder(${product.id})""><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                              <figcaption>
                              <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/view/client/product-detail?id=${product.id}">${product.name }</a></h4>
                             	<c:choose>
						<c:when test="${product.discount == 0}">
	                      <span class="aa-product-price">${product.price} </span><span class="aa-product-price"></span>
	                    </c:when>
	                    <c:otherwise>
	                      <c:forEach items="${productlist1}" var="product1">
	                      	<c:if test="${product1.id == product.id}">
		                      <span class="aa-product-price">
		                      	<c:set var="p" value="${product1.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/>  </span>
		                     </br> <span class="aa-product-price"><del>
		                      	<c:set var="p" value="${product.price}"/>
								<fmt:setLocale value="vi_VN"/>
								<fmt:formatNumber value="${p}" type="currency" maxFractionDigits="0"/>  </del></span>
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
                        <!-- start single product item -->
                     <!-- start single product item -->
                                                                                         
                  </ul>
                </div>
                <!-- / latest product category -->              
              </div>
               <div class="more-product">
                 	 <a class="aa-browse-btn" href="${pageContext.request.contextPath}/view/client/product">Xem Tất Cả Sản Phẩm <span class="fa fa-long-arrow-right"></span></a>
               </div>
            </div>
          </div> 
        </div>
      </div>
    </div>
  </section>
  <!-- / popular section -->
  <!-- Support section -->
  <section id="aa-support">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-support-area">
            <!-- single support -->
            <div class="col-md-4 col-sm-4 col-xs-12">
              <div class="aa-support-single">
                <span class="fa fa-truck"></span>
                <h4>MIỄN PHÍ VẬN CHUYỂN</h4>
                <P>Chúng tôi đã áp dụng gói miễn phí vận chuyển cho đơn hàng trên 280.000 VND</P>
              </div>
            </div>
            <!-- single support -->
            <div class="col-md-4 col-sm-4 col-xs-12">
              <div class="aa-support-single">
                <span class="fa fa-clock-o"></span>
                <h4>GIAO HÀNG NHANH</h4>
                <P>Chúng tôi đảm bảo hàng đến tay khách hàng nhanh và đảm bảo sản phẩm an toàn.</P>
              </div>
            </div>
            <!-- single support -->
            <div class="col-md-4 col-sm-4 col-xs-12">
              <div class="aa-support-single">
                <span class="fa fa-phone"></span>
                <h4>HỖ TRỢ 24/7</h4>
                <P>Hỗ trợ tư vấn và đặt hàng mọi lúc mọi nơi, đảm bảo thời gian cho khách hàng.</P>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- / Support section -->
  <!-- Testimonial -->
  <section id="aa-testimonial">  
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-testimonial-area">
            <ul class="aa-testimonial-slider">
              <!-- single slide -->
              <li>
                <div class="aa-testimonial-single">
                <img class="aa-testimonial-img" src="${url}/images/avatar_1.jpg" alt="avatar 1">
                  <span class="fa fa-quote-left aa-testimonial-quote"></span>
                  <p>Tôi đã mua hàng ở cửa hàng khá nhiều lần rồi, và tôi cảm thấy sản phẩm của cửa hàng 
                    được giao khá nhanh và sản phẩm thì tốt.</p>
                  <div class="aa-testimonial-info">
                    <p>Ngọc Huy</p>
                    <span>Nhân viên kinh doanh</span>
                  </div>
                </div>
              </li>
              <!-- single slide -->
              <li>
                <div class="aa-testimonial-single">
                <img class="aa-testimonial-img" src="${url}/images/avatar_2.jpg" alt="avatar 2">
                  <span class="fa fa-quote-left aa-testimonial-quote"></span>
                  <p> Về chất lượng của sản phẩm thì khỏi phải bàn, hàng hoá rất tốt, bền bỉ. Tôi sẽ mua hàng ở đây thường xuyên<p>
                  <div class="aa-testimonial-info">
                    <p>Mỹ Tâm</p>
                    <span>Diễn Viên</span>
                  </div>
                </div>
              </li>
               <!-- single slide -->
              <li>
                <div class="aa-testimonial-single">
                <img class="aa-testimonial-img" src="${url}/images/avatar_3.jpg" alt="avatar 3">
                  <span class="fa fa-quote-left aa-testimonial-quote"></span>
                  <p>Nhiều lần đi làm bận rộn, nên tôi thường mua hàng online ở đây. Chất lượng sản phẩm và dịch vụ ở đây rất là tốt!</p>
                  <div class="aa-testimonial-info">
                    <p>Phạm Anh</p>
                    <span>Sinh viên</span>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- / Testimonial -->

  <!-- Latest Blog -->
  <section id="aa-latest-blog">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-latest-blog-area">
            <h2>TIN TỨC</h2>
            <div class="row">
              <!-- single latest blog -->
              <c:forEach items="${boardnewlist}" var="boardnew" end="2">
              <div class="col-md-4 col-sm-4">
                <div class="aa-latest-blog-single">
                  <figure class="aa-blog-img">                    
                    <a href="${pageContext.request.contextPath}/view/client/news-list-detail?id=${boardnew.id}"><img src="<%=request.getContextPath() %>/files/${boardnew.image_link}" alt="Tin tức ${boardnew.title}"></a>  
                      <figcaption class="aa-blog-img-caption">
                      <span href="#"><i class="fa fa-clock-o"></i>${boardnew.created}</span>
                    </figcaption>                          
                  </figure>
                  <div class="aa-blog-info">
                    <h3 class="aa-blog-title"><a href="${pageContext.request.contextPath}/view/client/news-list-detail?id=${boardnew.id}">${boardnew.title}</a></h3>
                    <p class="desc-boardnews">${boardnew.content}</p> 
                    <a href="${pageContext.request.contextPath}/view/client/news-list-detail?id=${boardnew.id}" class="aa-read-mor-btn">Xem thêm<span class="fa fa-long-arrow-right"></span></a>
                  </div>
                </div>
              </div>
              </c:forEach>
            </div>
          </div>
        </div>    
      </div>
    </div>
  </section>
  <!-- / Latest Blog -->

  <!-- Client Brand -->

  <!-- / Client Brand -->  
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->

