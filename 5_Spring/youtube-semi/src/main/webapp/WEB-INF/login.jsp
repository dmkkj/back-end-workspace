<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
	<div class="container"> <!-- 화면에 꽉 채우기 : <div class="container-fluid"> -->
		<h1>로그인</h1>
		<!-- /login에서 요청을 보내면 받아서 처리할 controller 필요 -->
		<form action="/login" method="post">
		  <div class="mb-3">
		    <label for="id" class="form-label">아이디</label>
		    <!-- 내가 보내고자 하는 key 필요함. name 속성 -->
		    <input type="text" class="form-control" id="id" name="id">
		    <div id="idCheck" class="form-text"></div>
		  </div>
		  <div class="mb-3">
		    <label for="password" class="form-label">비밀번호</label>
		    <input type="password" class="form-control" id="password" name="password">
		    <div id="pwdCheck" class="form-text"></div>
		  </div>
	 	 <button type="submit" class="btn btn-dark" id="login">로그인</button>
		  <!-- checkbox 필요 없어서 지움
		  <div class="mb-3 form-check">
		    <input type="checkbox" class="form-check-input" id="exampleCheck1">
		    <label class="form-check-label" for="exampleCheck1">Check me out</label>
		  </div>
		  -->
	</form>
	</div>
</body>
</html>