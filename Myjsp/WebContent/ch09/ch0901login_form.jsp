<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFFF">
	<div align = center>
		<h2>ch09 : 로그인</h2>
		<hr>
		
		<form method="post" action="ch0901login.jsp" name="forml">
			<table border="1">
				<tr>
					<td colspan="2" align="center">로그인</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" size=10></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="userid" size=10></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" 
					name="Submit" value="로그인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>