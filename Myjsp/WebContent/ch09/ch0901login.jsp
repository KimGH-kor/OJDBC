<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="login" class="ch09.Ch0901LoginBean" />
<!-- ch09.ch0901LoginBean login = new ch09.Ch0901LoginBean() -->
<!--  -->

<jsp:setProperty name="login" property="*" />

<!-- 
<jsp:setProperty name="login" property="userid" param="userid"/>
-->
<!-- login.setUserid(request.getParameter("userid")); -->
<!-- 
<jsp:setProperty name="login" property="passwd" param="passwd"/>
-->
<!-- login.setPasswd(request.getParameter("passwd")); -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h2>Login Example</h2>
<hr>

<%
   if(!login.checkUser()){
      out.println("login fail!");
   }else{
      out.println("login success!");
   }
%>

<hr>
사용자 아이디 : <jsp:getProperty name="login" property="userid"/><br>
<!-- login.getUserid(); -->
사용자 비밀번호 : <jsp:getProperty name="login" property="passwd"/>

</div>

</body>
</html>