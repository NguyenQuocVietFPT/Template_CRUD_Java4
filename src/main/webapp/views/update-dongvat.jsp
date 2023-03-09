<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Thay đổi thông tin động vật</title>
    </head>
    <body>
        <div class="mt-4">
            <h3 class="text-center">Thay đổi thông tin động vật</h3>
            <hr/>
            <form method="post" action="/dong-vat/update-dongvat?id=${dongvat.id}">
                <div class="mb-3">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" value="${dongvat.ten}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Cân nặng</label>
                    <input type="text" class="form-control" name="canNang" value="${dongvat.can_nang}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Năm sinh</label>
                    <input type="text" class="form-control" name="namSinh" value="${dongvat.nam_sinh}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Giới tính</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="gioiTinh" value="true"
                            ${dongvat.gioi_tinh == true ? "checked": ""} required>
                            <label class="form-check-label">
                                Nam
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="gioiTinh" value="false"
                            ${dongvat.gioi_tinh == false ? "checked": "" } required>
                            <label class="form-check-label">
                                Nữ
                            </label>
                        </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <a class="btn btn-danger" href="/dong-vat/hien-thi">Quay lại</a>
            </form>
        </div>
    </body>
</html>
