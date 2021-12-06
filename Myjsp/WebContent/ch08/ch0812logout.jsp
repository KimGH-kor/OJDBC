<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
//		Enumeration<String> enumeration = session.getAttributeNames();
//		while(enumeration.hasMoreElements()){
//			String sName = enumeration.nextElement().toString();
//			String sValue = (String)session.getAttribute(sName);
//			
//			if(sValue.equals("abcde")) session.removeAttribute(sName);
//		}
		//이건 벨류값을 지우는것
		//session.removeAttribute("id");
		//이건 세션을 지우는 것
		session.invalidate();
	%>
	
	<a href="ch0812sessiontest.jsp">세션 내용 보기</a>
</body>
</html>