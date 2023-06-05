<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>도서 목록</title>
</head>
<body>
    <h1>도서 목록</h1>

    <form action="searchBook" method="GET">
        <input type="text" name="bookinfo" placeholder="도서 정보 입력">
        <input type="submit" value="검색">
    </form>

    <table>
        <thead>
            <tr>
                <th>ISBN</th>
                <th>도서명</th>
                <th>저자</th>
                <th>출판사</th>
                <th>수령일</th>
                <th>대여 가능 여부</th>
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