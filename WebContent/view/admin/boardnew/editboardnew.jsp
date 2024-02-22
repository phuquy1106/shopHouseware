<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Start header section -->
  <jsp:include page = "../header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Sửa tin tức</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/new/edit" method="post" enctype="multipart/form-data">
                 <div class="form-group">
                    <label for="input-1">ID</label>
                    <input type="text" class="form-control" readonly id="input-1" placeholder="ID" value="${boardnew.id}" name="new-id">
                  </div>
                  <div class="form-group">
                    <label for="input-2">Tên tin tức</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Tên tin tức" value="${boardnew.title}"name="new-title">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Nội dung</label>
                    <textarea class="form-control" rows="4" id="input-17" name="new-content">${boardnew.content}</textarea>
                  </div>
                  <div class="form-group">
                    <label for="input-2">Hình ảnh</label>
                    <input type="file" class="form-control" id="input-10"  name="new-image_link">
                  </div>
	             <div class="error">${error}</div>
                  </div>
                  </div>
                 <div class="form-footer">
                   <a  class="btn btn-danger" href="${pageContext.request.contextPath}/admin/new/list"><i class="fa fa-times"></i> Hủy</a>
                     <button class="btn btn-success">Cập nhật</button>
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