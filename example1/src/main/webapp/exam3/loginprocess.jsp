<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // 1. 입력받은 ID와 비밀번호 가져오기
    String inputId = request.getParameter("id");
    String inputPassword = request.getParameter("password");

    // 2. 등록된 ID와 비밀번호와 비교
    String registeredId = "abcd";
    String registeredPassword = "abcd";

    if (inputId.equals(registeredId) && inputPassword.equals(registeredPassword)) {
        // 3. 등록되어 있는 경우 main.jsp로 이동
        HttpSession loginSession = request.getSession();
        loginSession.setAttribute("userId", inputId);
        response.sendRedirect("main.jsp");
    } else {
        // 2. 등록되어 있지 않은 경우 error.jsp로 이동
        response.sendRedirect("error.jsp");
    }
%>