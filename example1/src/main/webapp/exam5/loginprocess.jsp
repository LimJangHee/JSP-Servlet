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
// JavaBean ��ü�� �����ϱ� ���� �̸��� login���� ����
// JavaBean Ŭ������ ��θ� ����

// ������ ������ ��ü�� ���� login�̶� name�� login���� �ҷ��ͼ� ���, id & password �Ӽ��� ����
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