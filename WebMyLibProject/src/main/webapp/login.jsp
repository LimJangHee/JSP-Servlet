<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장희 도서관</title>
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
      .form-container input[type="submit"] {
        padding: 5px;
        width: 100%;
        box-sizing: border-box;
        margin-bottom: 10px;
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
    <h1>로그인</h1>
    <div class="form-container">
      <form action="login.do" method="post">
        <div>
          <label for="id">아이디</label>
          <input type="text" id="id" name="id" />
        </div>
        <div>
          <label for="password">비밀번호</label>
          <input type="password" id="password" name="password" />
        </div>
        <div>
          <input type="submit" value="로그인" />
        </div>
      </form>
    </div>
    <div class="link">
      <a href="insertUser.jsp">회원가입</a>
    </div>
</body>
</html>