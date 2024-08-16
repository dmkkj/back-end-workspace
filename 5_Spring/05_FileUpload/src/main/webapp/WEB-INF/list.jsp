<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous" />
</head>
<body>
	<div class="container">
	
		<div class="header">
			<h1>List Page</h1>
			<a href="/write" class="btn btn-outline-warning">게시글 등록</a>
		</div>
		
		<table class="table">
			<thead>
				<tr>
					<th>#번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성시간</th>
				</tr>
			</thead>
			<tbody>
				<!-- 리스트 가져다가 뿌려주세요! -->
				<c:forEach var="board" items="${boards}">
					<tr>
						<td>${board.no}</td>
						<td>${board.title}</td>
						<td>${board.content}</td>
						<td>${board.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>