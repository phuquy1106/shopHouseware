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
                <div class="card-title">Sửa User</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/user/edit" method="post">
                  <div class="form-group">
                    <label for="input-1">ID</label>
                    <input type="text" class="form-control" id="input-1" readonly="readonly" placeholder="ID" value="${user.id}" name="user-id">
                  </div>
                  <div class="form-group">
                    <label for="input-1">Họ tên</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Họ tên" value="${user.name}" name="user-name">
                  </div>
                  <div class="form-group">
                    <label for="input-2">Email</label>
                    <input type="email" class="form-control" id="input-3" placeholder="Địa chỉ Email" value="${user.email}" name="user-email">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Số điện thoại</label>
                    <input type="text" class="form-control" id="input-4" placeholder="Số điện thoại" value="${user.phone}" name="user-phone">
                  </div>
                <div class="error">${error}</div>
                  
                  <div class="form-group">
                      <a  class="btn btn-danger" href="${pageContext.request.contextPath}/admin/user/list"><i class="fa fa-times"></i> Hủy</a>
                         
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