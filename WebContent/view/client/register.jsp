

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  <!-- / header section -->
<!--  content -->
 <!-- catg header banner section -->
  <section id="aa-catg-head-banner">
  <img src="${pageContext.request.contextPath}/view/client/assets/images/banner_dk.jpg" width="100%" height="350px" alt="banner blog">
    <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Đăng ký</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>                   
          <li style="color:#fff">Đăng ký tài khoản</li>
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
                 <h4>Đăng ký</h4>
                 <form name="formRegister" class="aa-login-form dks" method="post" action="${pageContext.request.contextPath}/view/client/register" >
                    <label for="">Họ tên<span>*</span></label>
                    <input type="text" placeholder="Name" name="name" id="name" value="${user.name}" >
                   
                     <label for="">Email <span>*</span></label>
                    <input type="text" placeholder="useremail@gmail.com" name="email" id="email" value="${user.email}" >
                    <label for="">Số điện thoại<span>*</span></label>
                    <input type="tel" placeholder="Số điện thoại" name="phone" id="phone" value="${user.phone}"  style="width: 100%; height: 40px"> 
                      
                     <label for="">Username<span>*</span></label>
                     
                    <input type="text" placeholder="Username" name="username" id="username" value="${user.username}" >
                    <p class="error">${erruser}</p>
                    <label for="">Mật khẩu<span>*</span></label>  
                    <input type="password" placeholder="Password" name="password" id="password">     
                    <input type="date" style="display: none" placeholder="Password" name="created" id="the-date">             
                      
                    <p style="color:red; display: block;"><%=(request.getAttribute("errMessage") == null) ? ""
        			: request.getAttribute("errMessage")%></p>
			        <p style="color:green; display: block;"><%=(request.getAttribute("Message") == null) ? ""
			        : request.getAttribute("Message")%></p>      
			         <button type="reset" class="aa-browse-btn" value="Reset">Đặt lại</button>  
                      <button type="submit" class="aa-browse-btn">Đăng ký</button>                         
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
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		
		document.getElementById('the-date').value = today;

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
                    password:{
                        required: true,
                        minlength: 6,
                    }
            
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
                    password:{
                        required: 'Vui lòng nhập password',
                        minlength: 'Mật khẩu tối thiểu 6 ký tự'
                    }
                }
            });
        });
</script>
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
  
  
