<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과는 ${msg}<br>
결과는 ${requestScope.msg }<br>
<%
String s = (String) request.getAttribute("msg");
out.println("결과는 " + s);
%>
</body>
</html>