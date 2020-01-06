<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/12/2019
  Time: 9:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <h1>Quản lý Sinh viên</h1>
    <h2>
        <a href="/new">Thêm mới sinh viên</a>
        <a href="/list">Danh sách sinh viên</a>

    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh sách sinh viên</h2></caption>
        <tr>
            <th>Mã sinh viên</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
        </tr>
        <c:forEach var="st" items="${students}">
            <tr>
                <td>${st.id}</td>
                <td>${st.name}</td>
                <td>${st.dob}</td>
                <td>
                    <a href="/edit?id=${st.id}">Sửa</a>
                    <a href="/delete?id=${st.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>