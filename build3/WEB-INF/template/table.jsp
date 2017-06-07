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
			<div class="control_item">
				<a href="./{name}_edit.do"><en:label>New</en:label></a>
			</div>
			<div class="clear"></div>
		</div>
		<table class="tbl">
			<tr>
{tblth}
			</tr>
			<en:iterator>
				<tr>
{tbltd}
				</tr>
			</en:iterator>
		</table>
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>