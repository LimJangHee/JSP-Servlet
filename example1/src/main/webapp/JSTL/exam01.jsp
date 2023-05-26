<%@page import="book.BookVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	BookVO book = new BookVO("123-456", "JSTL", "홍길동");

	pageContext.setAttribute("book", book);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	ISBN : ${ book.isbn }<br>
	title : <a href="../el/exam06.jsp"><c:out value="${ book.title }"</a><br>
	writer : ${ book.writer }<br>
</body>
</html>