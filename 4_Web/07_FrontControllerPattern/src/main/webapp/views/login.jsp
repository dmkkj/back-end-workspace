<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/front" method="post">
		<input type="hidden" name="command" value="login">
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="password" name="password"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>