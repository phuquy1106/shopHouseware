<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  
  
  <section id="aa-catg-head-banner">
   <img src="${pageContext.request.contextPath}/view/client/assets/images/banner_gt.jpg" width="100%" height="350px" alt="banner sản phẩm">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Giới thiệu</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>      
          <li style="color:#fff">Giới thiệu</li>   
        </ol>
      </div>
     </div>
   </div>
  </section>
  <section id="aa-product-category">
    <div class="container">
      <div class="row">
      	<div>
      		<h1 style ="text-align: center; color: red;">Gia Dụng</h1>
      		<p>Chúng tôi hi vọng tất cả người tiêu dùng Việt nam sẽ được sử dụng những dụng cụ chất lượng, chính hãng tại cửa hàng cung
      		 cấp đồ <strong>Gia Dụng</strong>.Với sứ mệnh trở thành một trong những nhà cung cấp đồ gia dụng hàng đầu tại
      		 Việt Nam đưa đến người tiêu dùng tất cả các đồ gia dụng tốt với mục đích là 
      		<strong>“Chất lượng cuộc sống của bạn phụ thuộc vào chất lượng đồ gia dụng bạn sử dụng hàng ngày.”</strong>. </p>
      		<img src="${url}/images/banner_gt1.jpg" height="500px" width="1124px" /> <br/> <br>
      		<p>Với triết lý trong kinh doanh là tuân thủ và đảm bảo được chất lượng tốt nhất, nguồn gốc xuất xứ về sản phẩm rõ ràng.Chúng tôi cam kết không sử dụng
      		các mặt hàng kém chất lượng, không rõ nguồn gốc.  <strong>Gia Dụng </strong>
      		đảm bảo an toàn nhất.</p>
      		<p>Với cam kết chỉ phân phối những hàng hóa được cung cấp từ những nhà sản xuất có uy tín.</p>
      		<img src="${url}/images/banner_gt3.jpg" height="500px" width="1124px"/> <br/> <br>
      		<strong>Dưới đây, chúng tôi xin điểm qua những mặt hàng đang được ưa chuộng:</strong><br/>
      		<p> <strong>Tủ lạnh: </strong>
			Là một thiết bị gia dụng cần thiết để giữ thực phẩm tươi ngon và tránh bị hỏng. Các thương hiệu nổi tiếng như LG, Samsung, Electrolux, Bosch,..được khách hàng tin dùng.</p>
      		<p> <strong>Máy giặt: </strong>
      		Thiết bị giúp giặt và làm sạch quần áo, vải. Các thương hiệu như Panasonic, LG, Electrolux, Bosch,..được khách hàng tin dùng.
      		</p>
      		<p> <strong>Máy hút bụi: </strong>
      		Thiết bị giúp làm sạch các loại bụi và rác trên sàn nhà. Các thương hiệu như Dyson, Philips, LG, Samsung,..được khách hàng tin dùng.
      		</p>
      		<p> <strong>Lò vi sóng: </strong>Thiết bị giúp nấu nhanh các món ăn và hâm nóng thức ăn. Các thương hiệu như Panasonic, LG, Samsung, Electrolux, Bosch,..được khách hàng tin dùng.</p>
      		<p> <strong>Với giá cả hợp lý, chúng tôi tin tưởng cửa hàng chúng tôi là sự lựa chọn rất hợp lý đối với khách hàng. </strong></p>
      		<br />
      	</div>
      </div>
     </div>
    </section>
    
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
      