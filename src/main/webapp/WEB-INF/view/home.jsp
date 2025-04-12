<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%-- Import JSTL core library --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Demo</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"> <%-- Link tới file CSS (sẽ tạo sau) --%>
</head>
<body>
    <h1>Spring MVC Demo Cơ Bản</h1>

    <%-- Hiển thị message được truyền từ HomeController --%>
    <h2>${message}</h2>

    <p>Đây là một ứng dụng demo đơn giản sử dụng Spring MVC.</p>

    <%-- Thêm link để điều hướng tới phần quản lý Student (sẽ tạo sau) --%>
    <p><a href="<c:url value='/student/list'/>">Quản lý Sinh viên</a></p>

</body>
</html>