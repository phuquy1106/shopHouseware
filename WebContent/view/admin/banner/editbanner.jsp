<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Start header section -->
  <jsp:include page = "../header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Sửa Banner</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/banner/edit" method="post" enctype="multipart/form-data">
                 <div class="form-group">
                    <label for="input-1">ID</label>
                    <input type="text" class="form-control" readonly id="input-1" placeholder="ID" value="${banner.id}" name="id">
                  </div>
                  <div class="form-group">
                    <label for="input-1">Tên Banner</label>
                    <input type="text" class="form-control" id="input-1" placeholder="name" value="${banner.name}"name="name">
                  </div>
                  <div class="form-group">
                    <label for="input-2">Nội dung</label>
                    <input type="text" class="form-control" id="input-2" placeholder="note" value="${banner.note}"name="note">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Hình ảnh</label>
                    <input type="file" class="form-control" id="input-3"  name="img">
                  </div>
                  <div class="error">${error}</div>
                 <div class="form-footer">
                   <a  class="btn btn-danger" href="${pageContext.request.contextPath}/admin/banner/list"><i class="fa fa-times"></i> Hủy</a>
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