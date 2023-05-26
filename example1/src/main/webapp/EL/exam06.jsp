<%@page import="book.Book"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%
    // books 리스트 생성
    ArrayList<Book> books = new ArrayList<>();
    // books 리스트에 Book 객체 추가 (임의의 데이터)
    books.add(new Book("성공"));

    // JSP 페이지의 request 객체에 books 리스트를 속성으로 설정
    request.setAttribute("books", books);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- 성공 출력 --%>
	성공/실패?? ${ books[0].title }<br>
</body>
</html>