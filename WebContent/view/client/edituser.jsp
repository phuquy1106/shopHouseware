<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />

  <section id="aa-catg-head-banner">
  <img src="${pageContext.request.contextPath}/view/client/assets/images/bg_lg.png" width="100%" height="350px" alt="banner blog">
    <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Cập nhật thông tin</h2>
        <ol class="breadcrumb">
        </ol>
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
                 <h4>Cập nhật thông tin</h4>
                 <form name="formRegister" class="aa-login-form dks" method="post" action="" >
                    <label for="">Họ tên</label>
                    <input type="text" placeholder="Name" name="name" id="name" value="${user.name}" >
                   
                     <label for="">Email </label>
                    <input type="text" placeholder="useremail@gmail.com" name="email" id="email" value="${user.email}" >
                    <label for="">Số điện thoại<span>*</span></label>
                    <input type="tel" placeholder="Số điện thoại" name="phone" id="phone" value="${user.phone}"  style="width: 100%; height: 40px"> 
                     <input type="hidden" id="role" name="role" value="${user.role}">
                     <label for="">Username</label>
                    <input type="text" placeholder="Username" readonly name="username" id="username" value="${user.username}" >
                    <p class="error">${erruser}</p>
                    <p class="sucress" style="color: green;">${msguser}</p>
			         <a class="aa-browse-btn"style="margin-top: 10px;padding-top: 5px !important;padding-bottom: 8px;">Huỷ</a>
                      <button type="submit" class="aa-browse-btn">Cập nhật</button>                         
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
                	name:{
                        required: true,
                    },
                    email:{
                        required: true,
                        email: true,
                    },
                    phone:{
                        required: true,
                    },
                    username:{
                        required: true,
                    },
                  
                },
                messages:{
                	name:{
                        required: 'Vui lòng nhập họ tên',
                    },
                    email:{
                        required: 'Vui lòng nhập email',
                        email: 'Email không chính xác',
                    },
                    phone:{
                        required: 'Vui lòng nhập số điện thoại',
                    },
                    username:{
                        required: 'Vui lòng nhập username',
                    },
                  
                }
            });
        });
</script>

 <jsp:include page = "./footer/footer.jsp" flush = "true" />

  
  
