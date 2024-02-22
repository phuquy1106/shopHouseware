<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Start header section -->
  <jsp:include page = "../header/header.jsp" flush = "true" />

    <div class="content-wrapper">
      <div class="container-fluid">
        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Sửa sản phẩm</div>
                <hr>
                <form method="post" action="${pageContext.request.contextPath}/admin/product/edit" enctype="multipart/form-data">
                
                 <div class="form-group">
                    <label for="input-1">Mã sản phẩm</label>
                    <input type="text" class="form-control" readonly="readonly" id="input-1" placeholder="Mã sản phẩm" name="product-sku" value="${product.id}">
                  </div>
                  
                  <div class="form-group">
                    <label for="input-1">Tên sản phẩm</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Tên sản phẩm" name="product-name" value="${product.name}">
                  </div>
                  
        
                  <div class="form-group">
	                  <label for="input-2">Chuyên mục</label>
	                  <div>
	                    <select class="form-control valid" id="input-6" name="product-cate" aria-invalid="false">
	                    <c:forEach items="${catelist}" var="cate">
	                        <option value="${cate.id }" <c:if test="${cate.id.equals(product.catalog_id)}">selected="selected"</c:if>>${cate.name}</option>
	                    </c:forEach>
	                    </select>
	                  </div>
	                </div>
	                
	                <div class="form-group">
                    <label for="input-1">Giá</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Giá" name="product-price" value="${product.price}">
                  </div>
                  <div class="error">${error2}</div>
                    <div class="form-group">
	                  <label for="input-2">Trạng thái</label>
	                  <div>
	                    <select class="form-control valid" id="input-6" name="product-status" required aria-invalid="false">
	                        <option value="1" <c:if test="${product.status == 1}">selected="selected"</c:if>>Còn hàng</option>
	                        <option value="0" <c:if test="${product.status == 0}">selected="selected"</c:if>>Hết hàng</option>
	                    </select>
	                  </div>
	                </div>
	                 <div class="form-group">
		                <label for="input-2">Giảm giá</label>
		                <div class="input-group">
		                <input type="text" class="form-control" placeholder="Giảm ... %" name="product-discount" value="${product.discount}">
		                <div class="input-group-append">
		                <button class="btn btn-light" type="button">%</button>
		                </div>
		                </div>
	              </div>
	                  <div class="error">${error3}</div>
	              <div class="error">${error4}</div>
                 <div class="form-group">
                  <label for="input-2" class="col-form-label">Mô tả</label>
                  <div>
                    <textarea class="form-control" rows="4" id="input-17" name="product-desc">${product.description}</textarea>
                  </div>
                </div>
                <div class="form-group">
                  <label for="input-2" class="col-form-label">Nội dung</label>
                  <div>
                    <textarea class="form-control" rows="4" id="input-17" name="product-content">${product.content}</textarea>
                  </div>
                </div>
                
                <div class="form-group">
                    <label for="input-1">Ảnh đại diện</label>
                    <input type="file" class="form-control" id="input-1" name="product-image">
                  </div>
              
              	<div class="error">${error}</div>
          
               <div class="form-footer">
                   <a  class="btn btn-danger" href="${pageContext.request.contextPath}/admin/product/list"><i class="fa fa-times"></i> Hủy</a>
                         
                     <button type="submit" class="btn btn-success">Cập nhật</button>
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>
  
    <jsp:include page = "../footer/footer.jsp" flush = "true" />