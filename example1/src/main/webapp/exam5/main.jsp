<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // 로그인 세션 확인
    HttpSession currentSession = request.getSession(false);
    String userId = null;
    if (currentSession != null && currentSession.getAttribute("userId") != null) {
    	// 세션의 id속성값을 가져와서 변수에 저장 -> 이렇게 해줘야 다른데서 사용하고 싶을때 사용할 수 있음
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
	// 로그아웃 submit을 해주면 name="logout" value="true" 값을 넣어줌
    // 로그아웃 처리
    // value값은 true를 저장
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