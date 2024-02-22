<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  <!-- / header section -->
<!--  content -->
 <!-- catg header banner section -->
  <section id="aa-catg-head-banner">
  <img src="${pageContext.request.contextPath}/view/client/assets/images/bg_pw.jpg" width="100%" height="350px" alt="banner blog">
    <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Đổi Mật Khẩu</h2>
     <!--     <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>                   
        </ol>-->	
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

 <!-- Cart view section -->
 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row">
       			
              <div class="col-md-8 col-md-push-2">
                <div class="aa-myaccount-register">                 
                 <h4>Đổi mật khẩu</h4>
                 <form name="formRegister" class="aa-login-form dks" method="post" action="${pageContext.request.contextPath}/view/client/editpass" >
                    
                    <label for="">Mật khẩu cũ<span>*</span></label>  
                    <input type="password" placeholder="Password" name="passwordcu" id="passwordcu">     
                           
                    <label for="">Mật khẩu mới<span>*</span></label>  
                    <input type="password" placeholder="Password" name="passwordmoi" id="passwordmoi">     
                   
                     <label for="">Nhập lại mật khẩu mới<span>*</span></label>  
                    <input type="password" placeholder="Password" name="passwordlai" id="passwordlai">     
                  
                    <p style="color:red; display: block;"><%=(request.getAttribute("errMessage") == null) ? ""
        			: request.getAttribute("errMessage")%></p>
			        <p style="color:green; display: block;"><%=(request.getAttribute("Message") == null) ? ""
			        : request.getAttribute("Message")%></p>  
			           <p style="color:red; display: block;"><%=(request.getAttribute("errMessage2") == null) ? ""
        			: request.getAttribute("errMessage2")%></p> 
			         <a class="aa-browse-btn huys"  href="${pageContext.request.contextPath}/" style="margin-top: 10px;padding-top: 5px !important;padding-bottom: 8px;">Huỷ</a>
                     <button type="submit" class="aa-browse-btn">Đặt lại mật khẩu</button>                         
                  </form>
                </div>
              </div>
            </div>          
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- / Cart view section -->

<!--  end content-->
   <script type="text/javascript">

		jQuery(document).ready(function($){
            $('.dks').validate({
                rules:{
                	passwordmoi:{
                    	required: true,
                    	minlength: 6,
                    	},
                	passwordlai:{
						equalTo: "#passwordmoi",
                	}
                },
                messages:{
                	passwordmoi:{
                    	required: 'Mật khẩu mới không được trống',
                    	minlength: 'Mật khẩu tối thiểu 6 ký tự',
                    	},
                	passwordlai:{
						equalTo: 'Mật khẩu không trùng',
                	}
                }
            });
        });
</script>
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
  
  
