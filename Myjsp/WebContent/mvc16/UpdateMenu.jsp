<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/Myjsp/Ch20Controller?UPD=1">
		<table border="1">
			<tr>
				<td>코드
				<td>성명
				<td>이메일
				<td>전화번호
				<td>체중
			</tr>
			<tr>
				<td><input type="text" name="code" value="${I_USER.code}"readonly="readonly" >
				<td><input type="text" name="name" value="${I_USER.name}" >
				<td><input type="text" name="email" value="${I_USER.email}" >
				<td><input type="text" name="tel" value="${I_USER.tel}" >
				<td><input type="text" name="weight" value="${I_USER.weight}" >
			</tr>
		</table>
		<input type="submit" value="수정"> 
		<input type="reset"	value="다시작성"> 
		<a href="/Myjsp/Ch20Controller?PAGE_NO=1"><input type="button" value="고객정보 다건 조회"></a>
	</form>

</body>
</html>