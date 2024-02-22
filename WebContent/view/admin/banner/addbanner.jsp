<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Start header section --> 
  <jsp:include page = "../header/header.jsp" flush = "true" /> 
    <div class="content-wrapper"> 
      <div class="container-fluid"> 
 
        <div class="row mt-3"> 
          <div class="col-lg-8"> 
            <div class="card"> 
              <div class="card-body"> 
                <div class="card-title">Thêm Banner</div> 
                <hr> 
                <form action="${pageContext.request.contextPath}/admin/banner/add" class="ban" method="post" enctype="multipart/form-data"> 
                           
                  <div class="form-group"> 
                    <label for="input-1">name</label> 
                    <input type="text" class="form-control" id="banner-name" placeholder="Tên banner" value="${name}"  name="name"> 
                  </div> 
                                
                 <div class="form-group"> 
                    <label for="input-1">Ghi chú</label> 
                    <input type="text" class="form-control" id="banner-note" placeholder="Nội dung" value="${note}" name="note"> 
                  </div>	
                   <div class="form-group">
                    <label for="input-3">Hình ảnh</label>
                    <input type="file" class="form-control" id="banner-img"  name="img">
                  </div>
                  <div class="error">${error}</div>
                  <div class="form-footer"> 
                   <a  class="btn btn-danger" href="${pageContext.request.contextPath}/admin/banner/list"><i class="fa fa-times"></i> Hủy</a>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Thêm</button>
                </div>  
                </form> 
              </div> 
            </div> 
          </div> 
        </div> 
        <div class="overlay toggle-menu"></div> 
      </div> 
    </div> 
        <script type="text/javascript">
    jQuery(document).ready(function($){
            $('.ban').validate({
                rules:{
                	banner-name:{
                        required: true,
                    },
                    banner-note:{
                        required: true,
                    },
                    banner-img:{
                        required: true,
                    }
            
                },
                messages:{
                	banner-name:{
                        required: 'Vui lòng nhập username',
                    },
                    banner-note:{
                        required: 'Vui lòng nhập passworld',
                    },
                    banner-img:{
                        required: 'Vui lòng nhập tên admin',
                    }
                }
            });
        });
    </script>
    <jsp:include page = "../footer/footer.jsp" flush = "true" />