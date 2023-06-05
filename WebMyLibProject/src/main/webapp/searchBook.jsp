<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>���� ���</title>
</head>
<body>
    <h1>���� ���</h1>

    <form action="searchBook" method="GET">
        <input type="text" name="bookinfo" placeholder="���� ���� �Է�">
        <input type="submit" value="�˻�">
    </form>

    <table>
        <thead>
            <tr>
                <th>ISBN</th>
                <th>������</th>
                <th>����</th>
                <th>���ǻ�</th>
                <th>������</th>
                <th>�뿩 ���� ����</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.isbn}</td>
                    <td>${book.name}</td>
                    <td>${book.writer}</td>
                    <td>${book.publisher}</td>
                    <td>${book.receive}</td>
                    <td>${book.rentable}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>