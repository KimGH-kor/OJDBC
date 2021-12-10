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
<h2>고객정보 보기 PAGE_NO=${P_NUM } NEXT=${NEXT_PAGE }</h2>

<table border="1">
	<tr>
		<td>코드</td>
		<td>성명</td>
		<td>이메일</td>
		<td>전화번호</td>
		<td>체중</td>
	</tr>
	
	<c:forEach var="cust" items="${C_LIST }">
		<tr>
			<td>${cust.code }</td>
			<td>${cust.name }</td>
			<td>${cust.email }</td>
			<td>${cust.tel }</td>
			<td>${cust.weight }</td>
			<td><a href="/Myjsp/Ch20Controller?CMD=${cust.code }">상세보기</a><td>
		</tr>
	</c:forEach>
	
</table>

<c:if test="${NEXT_PAGE == true }"><a href="/Myjsp/Ch20Controller?PAGE_NO=${P_NUM+1 }">다음페이지</a></c:if>

</body>
</html>