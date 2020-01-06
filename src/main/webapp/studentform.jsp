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

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div align="center">
    <h2>Quản lý Sinh viên</h2>
    <h3>
        <a href="/new">Thêm mới sinh viên</a>
        <a href="/list">Danh sách sinh viên</a>
    </h3>
</div>
<div class="container">
    <c:if test="${student != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${student == null}">
        <form action="insert" method="post">
            </c:if>
            <c:if test="${student != null}">
                <h4>Sửa thông tin sinh viên </h4>
            </c:if>
            <c:if test="${student == null}">
                <h4>Thêm sinh viên </h4>
            </c:if>
            <div class="form-group">
                <label>Mã sinh viên:</label>
                <c:if test="${student != null}">
                    <input name="id" value="<c:out value='${student.id}' />" readonly/>
                </c:if>
                <c:if test="${student == null}">
                    <input name="id" value="<c:out value='${student.id}' />"/>
                </c:if>
            </div>
            <div class="form-group">
                <label>Họ và tên:</label>

                <input type="text" name="name" size="45"
                       value="<c:out value='${student.name}' />"
                />

            </div>
            <div class="form-group">
                <label>Ngày sinh:</label>
                <input type="date" name="dob"
                       value="<c:out value='${student.dob}' />"
                />
            </div>
            <button type="submit" class="btn btn-primary">Luu</button>

        </form>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
