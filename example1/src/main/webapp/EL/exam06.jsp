<%@page import="book.Book"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%
    // books ����Ʈ ����
    ArrayList<Book> books = new ArrayList<>();
    // books ����Ʈ�� Book ��ü �߰� (������ ������)
    books.add(new Book("����"));

    // JSP �������� request ��ü�� books ����Ʈ�� �Ӽ����� ����
    request.setAttribute("books", books);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- ���� ��� --%>
	����/����?? ${ books[0].title }<br>
</body>
</html>