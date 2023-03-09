<%--
  Created by IntelliJ IDEA.
  User: xviet
  Date: 09/03/2023
  Time: 02:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Thêm động vật</title>
    </head>
    <body>
        <h3 class="text-center">Thêm động vật</h3>
        <hr/>
        <div class="mt-4">
            <form method="post" action="/dong-vat/add-new">
                <div class="mb-3">
                    <label class="form-label">Nhập tên</label>
                    <input type="text" class="form-control" name="ten" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Nhập cân nặng</label>
                    <input type="text" class="form-control" name="canNang" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Nhập năm sinh</label>
                    <input type="text" class="form-control" name="namSinh" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Chọn giới tính</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioiTinh" value="true" required>
                        <label class="form-check-label">
                            Nam
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioiTinh" value="false" required>
                        <label class="form-check-label">
                            Nữ
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </body>
</html>
