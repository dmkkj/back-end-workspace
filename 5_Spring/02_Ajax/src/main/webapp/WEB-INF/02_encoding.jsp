<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery 사용하려면 있어야 하는 코드 -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h2>Encoding 처리하기</h2>
	닉네임 : <input type="text" id="nick">
	<!-- <input type="button" value="닉네임 보내기" id="btn" onClick="startRequest()"> -->
	<input type="button" value="닉네임 보내기" id="btn"> <!-- jQuery 방식에서 onClick 지움 -->
	<div id="result"></div>
	
	<!-- 자바스크립트 방식 -->
	<!-- get 방식으로 /encoding <-- 닉네임 보내서 : 요청
		해당 닉네임 받아서 result에 보여주기
	-->
	<!--
	<script>
	let xhr;
	function startRequest() {
		const nickname = document.querySelector("#nick").value;	// 닉네임 값(value)만 (nickname 변수에 담아서) 가져와서 콘솔에 찍어보기
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		// document.querySelector("#nick").value 값을 서버에 보내고 싶어 -> 물음표(?). 키값 뭘로 보낼까 nickname
		// xhr.open('get', '/encoding?nickname=' + document.querySelector("#nick").value);
		xhr.open('get', '/encoding?nickname=' + encodeURI(encodeURIComponent(nickname)));
		// 한글, 특수문자 입력 시 encoding 해서 보냈음. 보내면 encoding된 값을 받아옴
		xhr.send(null);	// 요청 끝나서 이때 들어감.
	}

	function callback() { // 서버로부터 데이터를 가져오는 과정의 콜백 함수
		if(xhr.readyState === 4) {	// readyState 4일 때가 제대로 완료된 상황
			if(xhr.status === 200) {
				const result = xhr.responseText;
				// 개발할 때 잘 받아오는지, 잘 나오는지 수시로 확인하면서 하기
				// alert(result); // 서버에 result 값이 잘 가서 그걸 그대로 받아서 alert에 그대로 뿌려주고 있음
				// document.querySelector("#result").innerHTML = result;
				document.querySelector("#result").innerText = decodeURI(decodeURIComponent(result));
				// 인코딩된 result 결과 값 받아와서 decode처리 하면 됨
				// .innerHTML -> <> 태그로 인식해서 닉네임에 '<?' 입력 시
				// .innerText -> text로 인식해서 닉네임에 '<?' 입력 시 그대로 <? 출력됨
			}
		}
	}
	</script>
	-->
	
	<!-- jQuery 방식 -->
	<script>
		$("#btn").click(() => {
			const nickname = $("#nick").val();
			$.ajax({
				// 요청
				type: "get",
				url: "/encoding",
				data: "nickname=" + encodeURI(encodeURIComponent(nickname)), // 해당하는 값 보내고자 할 때 data 사용
				
				// 응답
				success: function(result) { // 성공했을 때만 확인하니까. // alert(result); -> success가 성공했을 때 result를 보냄					
					$("#result").text(result);
				},
				// error : function() {} // 실패했을 땐 error로 받음. but, 쓸 일 거의 없음. 보통 back단에서 받아서 처리
			});
		});
		
	</script>
	
</body>
</html>