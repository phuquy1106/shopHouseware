
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
        <section id="menu">
    <div class="container menusua">
      <div class="menu-area">
        <!-- Navbar -->
        <div class="navbar navbar-default" role="navigation">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>          
          </div>
          <div class="navbar-collapse collapse">
            <!-- Left nav -->
            <ul class="nav navbar-nav mwnuulsua">
            <li><a href="${pageContext.request.contextPath}/"><img src="${url}/images/logo_t1.png" alt="logo img" height="80px" width="250px"></a></li>
              <li><a href="${pageContext.request.contextPath}/">TRANG CHỦ</a></li>
              <li><a href="${pageContext.request.contextPath}/view/client/introduce">GIỚI THIỆU</a></li>
            <li><a href="${pageContext.request.contextPath}/view/client/product">SẢN PHẨM</span></a>
                
           
              <li><a href="${pageContext.request.contextPath}/view/client/news-list">TIN TỨC</a></li>
              <li><a href="${pageContext.request.contextPath}/view/client/security">CHÍNH SÁCH</a></li>
              <li><a href="${pageContext.request.contextPath}/view/client/contact">LIÊN HỆ</a></li>
              <li class="timkiem"><!-- search box -->
              <a class="aa-search-box">
                <form action="${pageContext.request.contextPath}/view/client/product/search" method="GET">
                  <input type="text" value="${param.s}" name="s" id="" placeholder="Tìm kiếm sản phẩm..">
                 <button class="serach-box"><span class="fa fa-search"></span></button>
                </form>
              </a>
              <!-- / search box -->
             </li>
             <li>

             <a class="aa-cart-link" href="${pageContext.request.contextPath}/view/client/cart" style="background: green;border-radius: 10px">
                  <span class="fas fa-cart-arrow-down"></span>
                  <span class="aa-cart-title">GIỎ HÀNG</span>
                  <c:if test="${order.items == null }">
               			<c:set value="0" var="length_order"> </c:set>
               		</c:if>
                  <c:if test="${length_order != NULL}">
                  	<div class="aa"><span class="aa-cart-notify num">${length_order}</span></div>
                  </c:if>
                  

                </a>
                
                
               </li>
            </ul>
          </div><!--/.nav-collapse -->
          
        </div>
      </div>       
    </div>
  </section>
