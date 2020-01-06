<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/12/2019
  Time: 9:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body class="container">
<div align="center">
    <h2>Quản lý Sinh viên</h2>
    <h3>
        <a href="/new">Thêm mới sinh viên</a>
        <a href="/list">Danh sách sinh viên</a>
    </h3>
</div>
<div align="center">
    <form action="search" method="post">
        <div class="input-group mb-3">
            <input type="text" name="q" class="form-control" aria-label="Recipient's username"
                   aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="button">Tìm kiếm</button>
            </div>
        </div>
    </form>
    <h4>Danh sách sinh viên</h4>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Mã sinh viên</th>
                <th scope="col">Họ và tên</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Chức năng</th>
            </tr>
        </thead>
        <tbody>
        <%--@elvariable id="listStudent" type="java.util.List<model.Student>"--%>
            <c:forEach var="st" items="${listStudent}">
                <tr>
                    <td><c:out value="${st.id}"></c:out></td>
                    <td><c:out value="${st.name}"></c:out></td>
                    <td><c:out value="${st.dob}"></c:out></td>
                    <td>
                        <a href="/edit?id=<c:out value='${st.id}'></c:out>">Sửa</a>
                        <a href="/delete?id=<c:out value='${st.id}'></c:out>">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>