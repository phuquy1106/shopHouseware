<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
       <section id="aa-slider">
    <div class="aa-slider-area">
      <div id="sequence" class="seq">
        <div class="seq-screen">
          <ul class="seq-canvas">
            <!-- single slide item -->
            <c:forEach items="${bannerList}" var="banner">
            <li>
              <div class="seq-model">
               <a href="${pageContext.request.contextPath}/view/client/productsale"> <img data-seq src="<%=request.getContextPath() %>/files/${banner.img}" /></a>
              </div>
           
              <div class="seq-title">   
              <c:if test="${banner.name!=''}">          
                <h2 data-seq><a href="${pageContext.request.contextPath}/view/client/productsale"> ${banner.name}</a></h2>   
                </c:if>              
                <p data-seq>${banner.note}</p>
              <!-- <a data-seq href="${pageContext.request.contextPath}/view/client/product" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
              -->
              </div>
            </li>
            </c:forEach>          
          </ul>
        </div>
        <!-- slider navigation btn -->
        <fieldset class="seq-nav" aria-controls="sequence" aria-label="Slider buttons">
          <a type="button" class="seq-prev" aria-label="Previous"><span class="fa fa-angle-left"></span></a>
          <a type="button" class="seq-next" aria-label="Next"><span class="fa fa-angle-right"></span></a>
        </fieldset>
      </div>
    </div>
  </section>
