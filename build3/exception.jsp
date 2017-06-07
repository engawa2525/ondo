<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib uri="https://engawa.jp/s3/engawa.gs.tld" prefix="en" %>
<%
int code = response.getStatus();
String msg = (String)request.getAttribute("msg");
Throwable th = (Throwable)request.getAttribute("throw");
%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h2><%=code %> <en:label><%=msg %></en:label></h2>
	<div class="container">
		
	</div><!-- container -->
</body>
</html>