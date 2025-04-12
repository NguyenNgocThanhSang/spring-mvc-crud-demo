<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> <%-- Import Spring Form tags --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Sinh viên</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>">
</head>
<body>
    <div class="form-container">
        <h1>Form Sinh viên</h1>

        <%--
            Sử dụng Spring Form tag (<form:form>) để binding dữ liệu với đối tượng 'student' trong model.
            Khi submit, form sẽ gửi POST request tới URL 'saveStudent'.
        --%>
        <form:form action="saveStudent" modelAttribute="student" method="POST">

            <%-- Trường ẩn để lưu ID của sinh viên (quan trọng cho việc cập nhật) --%>
            <%-- Spring Form tag sẽ tự động lấy giá trị từ student.id --%>
            <form:hidden path="id" />

            <div>
                <label for="firstName">Họ:</label>
                <%-- Input field cho firstName, được hiển thị trong cột Họ --%>
                <form:input path="firstName" id="firstName" />
            </div>

             <div>
                <label for="lastName">Tên:</label>
                <%-- Input field cho lastName, được hiển thị trong cột Tên --%>
                <form:input path="lastName" id="lastName" />
            </div>

            <div>
                <label for="email">Email:</label>
                <%-- Input field cho email, giá trị sẽ được bind với student.email --%>
                <form:input path="email" id="email" />
            </div>

            <div>
                <input type="submit" value="Lưu" class="button" />
            </div>

        </form:form>

        <div style="clear: both;"></div>

        <p>
            <a href="${pageContext.request.contextPath}/student/list">Quay lại Danh sách</a>
        </p>
         <p>
            <a href="${pageContext.request.contextPath}/">Quay lại Trang chủ</a>
        </p>

    </div>
</body>
</html>