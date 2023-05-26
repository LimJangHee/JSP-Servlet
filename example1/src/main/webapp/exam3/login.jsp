<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // 1. 현재 로그인 상태인지 확인
    // 현재 요청에 대한 세션 객체를 반환, false를 넣으면 객체가 존재하지 않을 경우 새로운 세션을 생성하지 않고 null 반환
    // 만약 false가 없으면 세션이 없을시 새로운 세션을 생성
    HttpSession currentSession = request.getSession(false);
	// 세션값이 null이 아니고 현재 세션의 userID라는 특성을 불러와서 그 값이 null이 아니면 true를 반환
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
    <form method="POST" action="loginprocess.jsp">
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