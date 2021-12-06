<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="ch0701error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Error 테스트 페이지</h2>
	<%
		String str = "test";
		int i = Integer.parseInt(str);
	%>
</body>
</html>