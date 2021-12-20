<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 등록</h2>
	<form method="POST" action="/Myjsp/UITestController?CMD=INT">
		<table border="1">
			<tr>
				<td>코드</td>
				<td>성명</td>
				<td>목표체중</td>
			<tr>
				<td><input type="text" name="code"></td>
				<td><input type="text" name="name"></td>
				<td><input type="text" name="weight"></td>
			</tr>

		</table>
		<input type="submit" value="등록"> 
		<input type="reset"	value="다시작성"> 
		<a href="/Myjsp/UITestController?CMD=SEL"><input type="button" value="회원 조회"></a>
	</form>
</body>
</html>