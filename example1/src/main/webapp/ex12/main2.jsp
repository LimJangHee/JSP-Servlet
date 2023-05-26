<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("attr", "hello world");
%>

<%// 모두 동일한 결과값 %>
<%= request.getAttribute("attr") %><br/>
${requestScope["attr"]}<br/>
${requestScope.attr}<br/>

${requestScope["attr2"]}<br/>

<%
Map<String, String> map = new HashMap<>();
map.put("one", "hello");
map.put("two", "World");
pageContext.setAttribute("map", map);
%>
${map.get("one")}, ${map["one"]}, ${map.one }<br/>

${(10*10) ne 100}<br/>
${pageContext.request.contextPath }<br/>
</body>
</html>