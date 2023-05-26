<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String[] nameArray = {"홍길동", "강길동", "고길동"};

	pageContext.setAttribute("names", nameArray);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	첫번째 이름 : <%= nameArray[0] %><br>
	첫번재 이름 : <%= ((String[])pageContext.getAttribute("names"))[0] %><br>
	
	EL 첫번째 이름 : ${ names[0] }<br>
	EL 네번째 이름 : ${ names[3] }<br>
	<%-- EL의 경우 없는 번지수이면 에러 뜨지 않고 empty로 나온다는 장점이 있음--%>
</body>
</html>