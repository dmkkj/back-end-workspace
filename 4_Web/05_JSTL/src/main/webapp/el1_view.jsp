<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1) 기존 방식</h2>
	<%-- request와 session과의 차이는
		request는 해당 페이지, 영역 내에서만 사용 가능. 'el1.jsp'에서만 끝나는 것
		만약 해당하는 것을 'el1_view.jsp'에서도 쓰고 싶어. 그러면 같이 보내야 함
		요청할 때 안 보내면 못 받음. request가 session보다 영역이 더 좁음 --%>
	<p>request : <%=request.getAttribute("result") %></p>
	<p>session : <%=session.getAttribute("result") %></p>
	
	<%--
		EL
		- Attribute에 바인딩된 값을 찾아오는 로직을 태그로 바꾼 기술
		- 바인딩한 ${값}이 사용한다.
	 --%>
	 <h2>2) EL</h2>
	 <p>request : ${requestScope.result}</p>
	 <p>session : ${sessionScope.result}</p>
	 <p>${result}</p>
	 <p>${result2}</p>
</body>
</html>