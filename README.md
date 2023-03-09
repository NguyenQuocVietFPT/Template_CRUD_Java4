# Template_CRUD_Java4

#Hướng dẫn config hibernate 

+ Đối với mssql (SQL Server):

        props.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");        
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");        
        props.put(Environment.URL, "jdbc:sqlserver://localhost:1433/databseName=template_crud_java4;encrypt=true;trustServerCertificate=true");      
        props.put(Environment.USER, "sa");
        props.put(Environment.PASS, your_sql_server_password);
        props.put(Environment.SHOW_SQL, "true");
        props.put(Environment.FORMAT_SQL, "true");
        props.put(Environment.HBM2DDL_AUTO, "update");
        

+ Đối với mysql (My SQL):

        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost:3306/template_crud_java4");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "28102003");
        props.put(Environment.SHOW_SQL, "true");
        props.put(Environment.FORMAT_SQL, "true");
        props.put(Environment.HBM2DDL_AUTO, "update");
        
        
+Lưu ý chỗ props.put(Environment.HBM2DDL_AUTO, "value")

  +,create :  Hibernate đầu tiên loại bỏ các bảng hiện có, sau đó tạo các bảng mới
  
  +,update : Mô hình đối tượng được tạo dựa trên ánh xạ (chú thích hoặc XML) được so sánh với lược đồ hiện có, sau đó Hibernate cập nhật lược đồ theo khác biệt. Nó   không bao giờ xóa các bảng hoặc cột hiện có ngay cả khi ứng dụng không yêu cầu chúng nữa
  
  +,create-drop : Tương tự như tạo, với sự bổ sung rằng Hibernate sẽ hủy cơ sở dữ liệu sau khi hoàn thành tất cả các thao tác. Thường được sử dụng để kiểm tra đơn vị
  
  +,validate : Hibernate chỉ xác thực xem các bảng và cột có tồn tại hay không, nếu không, nó sẽ đưa ra một ngoại lệ
  
  +,none : Giá trị này tắt hiệu quả việc tạo DDL
