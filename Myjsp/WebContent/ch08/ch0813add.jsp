<%@page import="java.util.ArrayList"%>
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
	request.setCharacterEncoding("UTF-8");
	String productname = request.getParameter("product");
	
	@SuppressWarnings("unchecked")
	ArrayList<String> list = (ArrayList<String>)session.getAttribute("productlist");
	if(list == null){
		list = new ArrayList<String>();
		session.setAttribute("productlist", list);
	}
	list.add(productname);
%>
	<script>
		alert("<%=productname%>이(가) 추가 되었습니다.!!");
		history.go(-1);
	</script>
</body>
</html>