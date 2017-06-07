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
	<h2><en:label>Targetdef</en:label></h2>
	<div class="container">
		<div class="control">
			<div class="control_item">
				<a href="./targetdef_edit.do"><en:label>New</en:label></a>
			</div>
			<div class="clear"></div>
		</div>
		<table class="tbl">
			<tr>
				<th><en:label>ID</en:label></th>
				<th><en:label>Target Def Name</en:label></th>
				<th><en:label>Min Temp</en:label></th>
				<th><en:label>Max Temp</en:label></th>
				<th><en:label>Alert Err Cnt</en:label></th>
				<th><en:label>Normal Interval</en:label></th>
				<th><en:label>Alert Interval</en:label></th>
				<th><en:label>Graph Option</en:label></th>
				<th><en:label>Registered</en:label></th>

			</tr>
			<en:iterator>
				<tr>
					<td><en:label link="./targetdef.do?id={id}" name="id" /></td>
					<td><en:label name="target_def_name" /></td>
					<td><en:label name="min_temp" /></td>
					<td><en:label name="max_temp" /></td>
					<td><en:label name="alert_err_cnt" /></td>
					<td><en:label name="normal_interval" /></td>
					<td><en:label name="alert_interval" /></td>
					<td><en:label name="graph_option" /></td>
					<td><en:label name="regist_dt" /></td>

				</tr>
			</en:iterator>
		</table>
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>