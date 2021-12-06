<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%
	ArrayList<HashMap<String, Object>> arr = new ArrayList<HashMap<String, Object>>();
	HashMap<String, Object> hm = new HashMap<String, Object>();
	HashMap<String, Object> hm2 = new HashMap<String, Object>();
	HashMap<String, Object> hm3 = new HashMap<String, Object>();
	int code = 100;
	String name = "kim";
	double score = 91.1;
	
	hm.put("CODE", code);
	hm.put("NAME", name);
	hm.put("SCORE", score);
	
	arr.add(hm);
	
	int code2 = 101;
	String name2 = "lee";
	double score2 = 92.2;
	
	hm2.put("CODE", code);
	hm2.put("NAME", name);
	hm2.put("SCORE", score);
	
	arr.add(hm2);
	
	int cnt = arr.size();
	double tot = score+score2;
	double avg = tot/cnt;
	
	hm3.put("CNT",cnt);
	hm3.put("TOT",tot);
	hm3.put("AVG",avg);
	
	arr.add(hm3);
	
	request.setAttribute("student", arr);
	
%>

<jsp:forward page="ch0606getAttr.jsp"/>