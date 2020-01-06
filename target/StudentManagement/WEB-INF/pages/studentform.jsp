<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/12/2019
  Time: 9:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
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
    <c:if test="${student != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${student == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${student != null}">
                            Sửa thông tin sinh viên
                        </c:if>
                        <c:if test="${student == null}">
                            Thêm sinh viên
                        </c:if>
                    </h2>
                </caption>

                <tr>
                    <th>Mã sinh viên: </th>
                    <td>
                        <c:if test="${student != null}">
                            <input name="id" value="<c:out value='${student.id}' />" readonly/>
                        </c:if>
                        <c:if test="${student == null}">
                            <input name="id" value="<c:out value='${student.id}' />"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Họ và tên: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${student.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Ngày sinh: </th>
                    <td>
                        <input type="date" name="dob"
                               value="<c:out value='${student.dob}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Lưu" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
