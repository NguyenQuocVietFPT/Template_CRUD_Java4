<%@ include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap demo</title>
</head>
<body>
    <div class="mt-4">
      <section>
        <a href="/dong-vat/them" class="btn btn-success " tabindex="-1" role="button">
          Add
        </a>
      </section>
      <hr/>
          <table class="table">
            <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Tên</th>
              <th scope="col">Cân nặng</th>
              <th scope="col">Giới tính</th>
              <th scope="col">Năm sinh</th>
              <th scope="col">Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dongVats}" var="dongvat">
              <tr>
                <td>${dongvat.id}</td>
                <td>${dongvat.ten}</td>
                <td>${dongvat.can_nang}</td>
                <c:choose>
                  <c:when test="${dongvat.gioi_tinh == true}">
                    <td>Nam</td>
                  </c:when>
                  <c:otherwise>
                    <td>Nữ</td>
                  </c:otherwise>
                </c:choose>
                <td>${dongvat.nam_sinh}</td>
                <td>
                  <a href="/dong-vat/detail?id=${dongvat.id}" class="btn btn-primary " tabindex="-1" role="button">
                  Detail
                  </a>
                  <a href="/dong-vat/update?id=${dongvat.id}" class="btn btn-success " tabindex="-1" role="button">
                    Update
                  </a>
                  <a href="/dong-vat/delete?id=${dongvat.id}" class="btn btn-danger " tabindex="-1" role="button">
                    Remove</a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
    </div>
</body>
</html>