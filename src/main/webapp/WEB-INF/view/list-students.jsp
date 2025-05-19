<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> <%-- Import Spring Form tags --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Sinh viên</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>">
</head>
<body>
    <div class="container">
        <h1>Danh sách Sinh viên</h1>

        <%-- Nút để thêm sinh viên mới --%>
        <input type="button" value="Thêm Sinh viên"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="button" />

        <br/><br/>

        <%-- Bảng hiển thị danh sách sinh viên --%>
        <table>
            <tr>
                <th>Họ và tên</th>
                <th>Ngày sinh</th>
                <th>Email</th>
                <th>Hành động</th> <%-- Cột chứa nút Sửa/Xóa --%>
            </tr>

            <%-- Lặp qua danh sách sinh viên được truyền từ Controller --%>
            <c:forEach var="tempStudent" items="${students}">

                <%-- Tạo link cho nút Update --%>
                <c:url var="updateLink" value="/student/showFormForUpdate">
                    <c:param name="studentId" value="${tempStudent.id}" />
                </c:url>

                <%-- Tạo link cho nút Delete --%>
                 <c:url var="deleteLink" value="/student/delete">
                    <c:param name="studentId" value="${tempStudent.id}" />
                </c:url>

                <tr>
                    <td> ${tempStudent.fullName} </td> <%-- Hiển thị Họ và tên --%>
                    <td> ${tempStudent.dateOfBirth} </td> <%-- Hiển thị Ngày sinh --%>
                    <td> ${tempStudent.email} </td>
                    <td>
                        <%-- Hiển thị link Update và Delete --%>
                        <a href="${updateLink}" class="button">Sửa</a>
                        |
                        <a href="${deleteLink}" class="button"
                           onclick="if (!(confirm('Bạn có chắc muốn xóa sinh viên này?'))) return false">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
         <br/>
         <p><a href="${pageContext.request.contextPath}/">Quay lại Trang chủ</a></p>
    </div>
</body>
</html>