<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	%>
	<jsp:useBean id="login" class="ex10.LoginBean"/>
	<jsp:setProperty name = "login" property="id"/>
	<jsp:setProperty name = "login" property="password"/>
	<%
	if(login.dbCheck()){
		Cookie idCookie = new Cookie("id", id);
		Cookie passwordCookie = new Cookie("password", password);

		session.setAttribute("id",id);
		session.setAttribute("password",password);
		
		idCookie.setMaxAge(3600);
		passwordCookie.setMaxAge(3600);

		response.addCookie(idCookie);
		response.addCookie(passwordCookie);

		response.sendRedirect("mainPage.jsp");
	}else{
	%>
	<jsp:forward page="login.html"/>
	<%
	}
	%>
</body>
</html>
  