<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	
	<form id="frm">
		아이디 : <input type="text" name="id" id="id"><br>
		비밀번호 : <input type="password" name="password" id="password"><br>
		이름 : <input type="text" name="name" id="name"><br>
		<input type="button" value="가입" id="btn">
	</form>
	
	<div id="result"></div>
	
	<script>
		$("#btn").click(() => {
			$.ajax({
				// *post 방식으로 보낼 때는 굳이 encoding(인코딩)이 필요 없음
				// post 방식으로
				type: "post",
				// /serial
				url: "/serial",
				// id, password, name 값 넘겨서 회원가입 하고(*여러 값을 담을 때는 객체 사용하기. 자바스크립트에서의 객체는 : {})
				/* 자바스크립트 객체 방식 {} 괄호로 보내는 것 알고 있어야 함. 프론트는 {} 이렇게 보낼거고. 백엔드는 {} 이렇게 받아야 하기 때문
				{
					키 : 값,
					키 : 값,
					...
				}
				*/
				//대부분이 이렇게 코딩했음. 이거를 객체 방식으로 바꿈
				//"id=" + $("#id").val(),
				//"password=" + $("#password").val(),
				//"name=" + $("#name").val(),
				/*
				data: {
					id: $("#id").val(),
					password: $("#password").val(),
					name: $("#name").val()
					},
				*/
				data: $("#frm").serialize(),
				
				// 돌아와서 result에 정보 기재
				success: function(result) {
					console.log(result);
					alert("회원가입 완료!");
					$("#result").html(result.name + "님이 회원가입 하셨습니다.");
				},
				error: function() {
					alert("회원가입 실패!");
				}
			});
		})
	</script>
</body>
</html>