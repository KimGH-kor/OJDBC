<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
HashMap<String, Object> hm = null;
ArrayList<?> arr = (ArrayList<?>)request.getAttribute("student");

for(int i = 0; i < arr.size(); i++){
	hm = (HashMap<String, Object>)arr.get(i);
	if(arr.size()-1 != i){
	%>
	CODE => <%= hm.get("CODE") %><br>
	NAME => <%= hm.get("NAME") %><br>
	SCORE => <%= hm.get("SCORE") %><br>
<%
	}else{
		%>
	CNT => <%= hm.get("CNT") %><br>
	TOT => <%= hm.get("TOT") %><br>
	AVG => <%= hm.get("AVG") %><br>	
<%
}
}
%>


</body>
</html>