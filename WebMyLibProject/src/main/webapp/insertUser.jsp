<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    h1 {
        text-align: center;
        margin-top: 50px;
    }
    .form-container {
        width: 300px;
        margin: 0 auto;
    }
    .form-container input[type="text"],
    .form-container input[type="password"],
    .form-container input[type="email"],
    .form-container input[type="number"],
    .form-container input[type="submit"] {
        padding: 5px;
        width: 100%;
        box-sizing: border-box;
        margin-bottom: 10px;
    }
    .form-container input[type="radio"] {
        margin-right: 5px;
    }
    .form-container label {
        display: block;
        margin-bottom: 5px;
    }
    .form-container input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        cursor: pointer;
    }
    .form-container input[type="submit"]:hover {
        background-color: #0056b3;
    }
    .link {
        text-align: center;
        margin-top: 20px;
    }
</style>
</head>
<body>
	<h1>회원가입</h1>
	<div class="form-container">
	    <form action="insertUser.do" method="post">
    		<div>
    			<label for="id">아이디</label>
    			<input type="text" id="id" name="id" />
    		</div>
    		<div>
    			<label for="password">비밀번호</label>
    			<input type="password" id="password" name="password" />
    		</div>
    		<div>
    			<label for="name">이름</label>
    			<input type="text" id="name" name="name" />
    		</div>
    		<div>
    			<label for="birth">생년월일</label>
    			<input type="text" id="birth" name="birth" />
    		</div>
    		<div>
    			<label for="email">Email</label>
    			<input type="email" id="email" name="email" />
    		</div>
    		<div>
    			<label for="phone">휴대폰번호</label>
    			<input type="number" id="phone" name="phone" />
    		</div>
    		<div>
    			<label>권한</label>
    			<input type="radio" id="admin" name="role" value="admin" checked="checked" />
    			<label for="admin">관리자</label>
    			<input type="radio" id="user" name="role" value="User" />
    			<label for="user">사용자</label>
    		</div>
    		<div>
    			<input type="submit" value="회원가입" />
    		</div>
	    </form>
	</div>
	<div class="link">
	    <a href="/WebMyLibProject/login.jsp">로그인</a>
    </div>
</body>
</html>