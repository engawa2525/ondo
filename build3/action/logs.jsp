<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="https://engawa.jp/s3/engawa.gs.tld" prefix="en"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./include/include.jsp" />
<style>
.tbl {
	margin:10px;
	border-collapse: collapse;
}
.tbl th {
	font-weight: normal;
	border:solid 1px #888888;
	padding-left:5px;
	padding-right:5px;
	background-color: #eeeeff;
	font-size:small;
	white-space: nowrap;
}
.tbl .thsecond {
	background-color: #eeffee;	
}
.tbl td {
	border:solid 1px #888888;
	padding-left:5px;
	padding-right:5px;
	font-size:small;
	white-space: nowrap;	
	vertical-align: top;
}
.tbl .right {
	text-align: right;
}
</style>
</head>
<body>
	<jsp:include page="./include/header.jsp" />
	<h2><en:label>Log</en:label></h2>
	<div class="container">
		<table class="tbl">
			<tr>
				<th><en:label>ID</en:label></th>
				<th><en:label>Status Kbn</en:label></th>
				<th><en:label>Ymd</en:label></th>
				<th><en:label>Log Key</en:label></th>
				<th><en:label>Field1</en:label></th>
				<th><en:label>Field2</en:label></th>
				<th><en:label>Field3</en:label></th>
				<th><en:label>Registered</en:label></th>

			</tr>
			<en:iterator>
				<tr>
					<td><en:label name="id" /></td>
					<td><en:label name="status_kbn" /></td>
					<td><en:label name="ymd" /></td>
					<td><en:label name="log_key" /></td>
					<td class="right"><en:label name="field1" /></td>
					<td class="right"><en:label name="field2" /></td>
					<td class="right"><en:label name="field3" /></td>
					<td><en:label name="regist_dt" /></td>

				</tr>
			</en:iterator>
		</table>
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />	
</body>
</html>