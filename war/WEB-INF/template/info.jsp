<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="https://engawa.jp/s3/engawa.gs.tld" prefix="en"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./include/include.jsp" />
</head>
<body>
	<jsp:include page="./include/header.jsp" />
	<h2><en:label>{title}</en:label></h2>
	<div class="container">
		<div class="control">
			<div class="control_item"><en:label link="./{name}s.do">List</en:label></div>
			<div class="control_item"><en:label link="./{name}_edit.do?id={id}">Edit</en:label></div>
			<div class="clear"></div>
		</div>
	
		<div class="block">
			<div class="frm">
{frm}
			</div><!-- frm -->
		</div><!-- block -->	
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>