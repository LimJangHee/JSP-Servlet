<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // 로그인 세션 확인
    HttpSession currentSession = request.getSession(false);
    String userId = null;
    if (currentSession != null && currentSession.getAttribute("userId") != null) {
        userId = (String) currentSession.getAttribute("userId");
    } else {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main</title>
</head>
<body>
    <h1>Main</h1>
    <p><%= userId %>님 환영합니다!</p>
    <form method="POST" action="main.jsp">
        <input type="hidden" name="logout" value="true">
        <button type="submit">로그아웃</button>
    </form>
</body>
</html>
<%
    // 로그아웃 처리
    String logoutValue = request.getParameter("logout");
    if (logoutValue != null && logoutValue.equals("true")) {
        // 세션 무효화
        if (currentSession != null) {
            currentSession.invalidate();
        }
        // 로그인 페이지로 리다이렉트
        response.sendRedirect("login.jsp");
    }
%>