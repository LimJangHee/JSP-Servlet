<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // 1. 현재 로그인 상태인지 확인
    HttpSession currentSession = request.getSession(false);
    boolean isLoggedIn = (currentSession != null && currentSession.getAttribute("userId") != null);

    if (isLoggedIn) {
        // 2. 로그인 상태이면 main.jsp로 이동
        response.sendRedirect("main.jsp");
    } else {
        // 3. 로그인 상태가 아니면 ID, PW 입력 폼 보여주기
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form method="get" action="../Login2">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
<%
    }
%>