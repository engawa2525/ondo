<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib uri="https://engawa.jp/s3/engawa.gs.tld" prefix="en" %>
<%
String url = (String)request.getAttribute("request_url");
if(url == null) {
	url = "-";
}
String status = (String)request.getAttribute("status");
if(status == null) {
	status = "-";
}
%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h2>404 <en:label>File Not Found.</en:label></h2>
	<div class="container">
	<h3><%=url %></h3>
	<h4><%=status %></h4>
	</div><!-- container -->
</body>
</html>