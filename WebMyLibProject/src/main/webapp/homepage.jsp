<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장희도서관</title>
</head>
	<style>
		#top{
		 background-color: blue;
		}
		#title{
			margin: 0%
			font-size: large;
		}
	</style>
<header>
	<div id="top"></div>
    <div id="title">도서관</div>
    <hr/>
</header>
<body>
<section>
	<c:if test="${ user.role == 'admin' }">
		<a href="/WebMyLibProject/addBook.jsp">책입고</a>
		<a href="/WebMyLibProject/deleteBook.jsp">책삭제</a>
	</c:if>
	<c:choose>
		<c:when test="${ empty user }">
		    <h1><a href="/WebMyLibProject/login.do">로그인</a></h1>
		    <h3><a href="/WebMyLibProject/searchId.do">아이디 찾기</a> <a href="/WebMyLibProject/searchPassword.do">비밀번호 찾기</a> <a href="/WebMyLibProject/insertUser.do">회원가입</a></h3>
		</c:when>
		<c:otherwise>
			${ user.name }님
			<a href="/WebMyLibProject/getBookList.do">전체도서목록</a>
			<a href="/WebMyLibProject/searchBook.do">도서검색</a>
			<a href="/WebMyLibProject/logout.do">로그아웃</a>			 
		</c:otherwise>
	</c:choose>
</section>
</body>
</html>