<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Start header section -->
  <jsp:include page = "../header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Thêm tin tức</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/new/add" method="post" enctype="multipart/form-data">
                 
                  <div class="form-group">
                    <label for="input-2">Tên tin tức</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Tên tin tức" value="${new_title}" name="new-title">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Nội dung</label>
                    <textarea class="form-control" rows="4" id="input-17"  name="new-content">${new_content}</textarea>
                  </div>
                  <div class="form-group">
                    <label for="input-3">Hình ảnh</label>
                    <input type="file" class="form-control" id="input-18" placeholder="Địa chỉ hình ảnh"  name="new-image_link">
                  </div>
	    		<div class="error">${error}</div>
                 
                 <div class="form-footer">
                 	
                   <a  class="btn btn-danger" href="${pageContext.request.contextPath}/admin/new/list"><i class="fa fa-times"></i> Hủy</a>
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
  <script>
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		
		document.getElementById('the-date').value = today;
</script>
    <jsp:include page = "../footer/footer.jsp" flush = "true" />