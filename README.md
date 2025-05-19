# Spring MVC CRUD Demo
> Demo đơn giản về Spring MVC để minh họa các khái niệm cơ bản và luồng xử lý request.

## Giới thiệu
Đây là một ứng dụng web đơn giản được xây dựng bằng Spring MVC để quản lý thông tin sinh viên (CRUD - Create, Read, Update, Delete). Ứng dụng sử dụng cấu hình Java thay vì XML và lưu trữ dữ liệu trong bộ nhớ (không sử dụng cơ sở dữ liệu).

## Cấu trúc dự án
```
src/main/java/com/group10/
├── config/                  # Cấu hình Spring MVC
│   ├── AppConfig.java      # Cấu hình chính (ViewResolver, Resources...)
│   └── AppInitializer.java # Thay thế web.xml
├── controller/             # Các controller xử lý request
│   ├── HomeController.java # Xử lý request tới trang chủ
│   └── StudentController.java # Xử lý CRUD cho Student
├── dao/                    # Tầng truy cập dữ liệu
│   ├── StudentDAO.java    # Interface định nghĩa các thao tác CRUD
│   └── StudentDAOImpl.java # Triển khai sử dụng ArrayList
└── model/                 # Các lớp model
    └── Student.java      # Lớp đại diện cho thông tin sinh viên

src/main/webapp/
├── resources/             # Tài nguyên tĩnh (CSS, JS, Images)
│   └── css/
│       └── style.css     # File CSS chính
└── WEB-INF/
    └── view/             # Các file JSP
        ├── home.jsp      # Trang chủ
        ├── list-students.jsp # Danh sách sinh viên
        └── student-form.jsp  # Form thêm/sửa sinh viên
```

## Các công nghệ sử dụng
- Java 21
- Spring MVC 6.1.6
- Jakarta Servlet API 6.0.0
- JSP và JSTL
- Maven

## Cài đặt và chạy
1. Clone repository này về máy:
```bash
git clone https://github.com/NguyenNgocThanhSang/spring-mvc-crud-demo.git
cd spring-mvc-crud-demo
```

2. Chạy ứng dụng bằng Maven:
```bash
mvn jetty:run
```

3. Truy cập ứng dụng tại:
```
http://localhost:8080/spring-mvc-crud-demo/
```

## Tính năng
- **Xem danh sách sinh viên:** Hiển thị danh sách với các thông tin: Họ và tên, Ngày sinh, Email
- **Thêm sinh viên mới:** Form cho phép nhập thông tin sinh viên
- **Cập nhật thông tin:** Cho phép chỉnh sửa thông tin sinh viên hiện có
- **Xóa sinh viên:** Xóa sinh viên khỏi danh sách (có confirm dialog)

## Luồng xử lý request trong Spring MVC
1. **Client gửi request:** Ví dụ: GET `/student/list`
2. **DispatcherServlet:** Nhận request và tìm controller phù hợp
3. **Controller:** `StudentController` xử lý request, tương tác với `StudentDAO`
4. **Model:** Dữ liệu được đóng gói trong Model
5. **View:** JSP render dữ liệu từ Model và trả về HTML
6. **Response:** HTML được gửi về client

## Điểm nổi bật
- Sử dụng cấu hình Java (không XML)
- Dependency Injection với `@Autowired`
- Annotation-based mapping (`@Controller`, `@RequestMapping`)
- Spring Form Tags cho data binding
- PRG pattern (Post/Redirect/Get) để tránh form resubmission

## Mục đích học tập
Demo này giúp người học hiểu:
1. Cấu trúc cơ bản của ứng dụng Spring MVC
2. Cách Spring quản lý các bean và dependency injection
3. Luồng xử lý request từ client đến server và ngược lại
4. Cách sử dụng các annotation quan trọng của Spring MVC
5. Tổ chức code theo mô hình MVC

## Lưu ý
- Đây là demo đơn giản phục vụ mục đích học tập
- Dữ liệu được lưu trong bộ nhớ sẽ mất khi restart ứng dụng
- Chưa có validation và xử lý lỗi
- Phù hợp cho người mới bắt đầu tìm hiểu Spring MVC