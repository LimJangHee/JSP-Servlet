<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장희도서관 : 전체도서검색</title>
</head>
<header>
	전체도서검색
	<h3>${ user.name }님 환영합니다.</h3>
	<hr/>
</header>
<body>
	<section>
		<table border="1">
			<tr>
				<td>ISBN</td>
				<td>NAME</td>
				<td>WRITER</td>
				<td>PUBLISHER</td>
				<td>RECEIVE</td>
			</tr>
			<c:forEach var="book" items="${ bookList }">
				<tr>
					<td>${ book.isbn }</td>
					<td>${ book.name }</td>
					<td>${ book.writer }</td>
					<td>${ book.publisher }</td>
					<td>${ book.receive }</td>
				</tr>
			</c:forEach>
		</table>
	</section>
</body>
</html>