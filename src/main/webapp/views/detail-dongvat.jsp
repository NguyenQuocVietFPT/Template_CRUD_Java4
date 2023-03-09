<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iamviet.template_crud_java4.repositories.IDongVatrRepository" %>
<%@ page import="com.iamviet.template_crud_java4.repositories.impl.DongVatRepository" %>
<%@ page import="com.iamviet.template_crud_java4.entities.DongVat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hiển thị thông tin</title>
</head>
<body>
    <div class="mt-4">
        <h3 class="text-center">Hiển thị thông tin động vật</h3>
        <hr/>
        <form>
            <div class="mb-3">
                <label class="form-label">Id:</label>
                <h4 class="form-control">${dongvat.id}</h4>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên:</label>
                <h4 class="form-control">${dongvat.ten}</h4>
            </div>
            <div class="mb-3">
                <label class="form-label">Cân nặng:</label>
                <h4 class="form-control">${dongvat.can_nang}</h4>
            </div>
            <div class="mb-3">
                <label class="form-label">Giới tính:</label>
                <c:choose>
                    <c:when test="${dongvat.gioi_tinh == true}">
                        <h4 class="form-control">Nam</h4>
                    </c:when>
                    <c:otherwise>
                        <h4 class="form-control">Nữ</h4>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="mb-3">
                <label class="form-label">Năm sinh:</label>
                <h4 class="form-control">${dongvat.nam_sinh}</h4>
            </div>
            <a class="btn btn-primary" href="/dong-vat/hien-thi"> Quay lại</a>
        </form>
    </div>
</body>
</html>
