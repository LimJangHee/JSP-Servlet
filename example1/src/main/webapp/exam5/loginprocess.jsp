<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String inputId = request.getParameter("id"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
// JavaBean 객체를 잠초하기 위한 이름을 login으로 지정
// JavaBean 클래스의 경로를 지정

// 위에서 지정한 객체의 명이 login이라서 name을 login으로 불러와서 사용, id & password 속성을 설정
%>
<jsp:useBean id="login" class="ex10.LoginBean"/>
<jsp:setProperty name = "login" property="id"/>
<jsp:setProperty name = "login" property="password"/>
<%
if(login.dbCheck()){
	HttpSession loginSession = request.getSession();
	loginSession.setAttribute("userId", inputId);
	response.sendRedirect("main.jsp");
	 
}else{
	response.sendRedirect("error.jsp");
}
%>

</body>
</html>