<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>도서삭제</title>
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
	<h1>도서삭제</h1>
	<div class="form-container">
	    <form action="deleteBook.do" method="post">
    		<div>
    			<label for="name">도서명</label>
    			<input type="text" id="name" name="name" />
    		</div>
    		<div>
    			<input type="submit" value="도서삭제" />
    		</div>
	    </form>
	</div>
	<div class="link">
	    <a href="/WebMyLibProject/login.jsp">로그인</a>
    </div>
</body>
</html>