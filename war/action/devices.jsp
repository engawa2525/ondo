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
	<h2><en:label>Device</en:label></h2>
	<div class="container">
		<div class="control">
			<div class="control_item">
				<a href="./device_edit.do"><en:label>New</en:label></a>
			</div>
			<div class="clear"></div>
		</div>
		<table class="tbl">
			<tr>
				<th><en:label>ID</en:label></th>
				<th><en:label>Device Cd</en:label></th>
				<th><en:label>Target</en:label></th>
				<th><en:label>Shop</en:label></th>
				<th><en:label>Start Dt</en:label></th>
				<th><en:label>End Dt</en:label></th>
				<th><en:label>Last Access</en:label></th>
				<th><en:label>Device Type</en:label></th>
				<th><en:label>Device Status</en:label></th>
				<th><en:label>Registered</en:label></th>

			</tr>
			<en:iterator>
				<tr>
					<td><en:label name="id" /></td>
					<td><en:label link="./device.do?id={id}" name="device_cd" /></td>
					<td><en:input type="label" name="target_id" list="targets"/></td>
					<td><en:input type="label" name="shop_id" list="shops"/></td>
					<td><en:label name="start_dt" /></td>
					<td><en:label name="end_dt" /></td>
					<td><en:label name="last_access" /></td>
					<td><en:input type="label" name="device_type" list="#{'0':'温度計','1':'アラート'}"/></td>
					<td><en:input type="label" name="device_status" list="#{'0':'稼働中','1':'停止中'}"/></td>
					<td><en:label name="regist_dt" /></td>

				</tr>
			</en:iterator>
		</table>
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>