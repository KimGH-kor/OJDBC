<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 조회</h2>

<table border="1">
	<tr>
		<td>코드</td>
		<td>성명</td>
		<td>목표체중</td>
	</tr>
	
	<c:forEach var="cust" items="${C_LIST }">
		<tr>
			<td>${cust.code }</td>
			<td>${cust.name }</td>
			<td>${cust.weight }</td>
		</tr>
	</c:forEach>
</table>
	건수  ${SIZE } <BR>
	평균체중  ${AVG } <BR>
	<a href="UITest/Insert.jsp"><input type="button" value="회원 등록"></a>
</body>
</html>