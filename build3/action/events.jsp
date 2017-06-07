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
	<h2><en:label>Event</en:label></h2>
	<div class="container">
		<%--
		<div class="control">
			<div class="control_item">
				<a href="./event_edit.do"><en:label>New</en:label></a>
			</div>
			<div class="clear"></div>
		</div>
		 --%>
		<table class="tbl">
			<tr>
				<th><en:label>ID</en:label></th>
				<th><en:label>Shop Id</en:label></th>
				<th><en:label>Target Id</en:label></th>
				<th><en:label>Event Dt</en:label></th>
				<th><en:label>Event Cd</en:label></th>
				<th><en:label>Event Status</en:label></th>
				<th><en:label>Status Dt</en:label></th>
				<th><en:label>Event Name</en:label></th>
				<th><en:label>Event Info</en:label></th>
				<th><en:label>Alert Status</en:label></th>
				<th><en:label>Alert Dt</en:label></th>
				<th><en:label>Registered</en:label></th>

			</tr>
			<en:iterator>
				<tr>
					<td><en:label link="./event.do?id={id}" name="id" /></td>
					<td><en:input type="label" name="shop_id" list="shops"/></td>
					<td><en:input type="label" name="target_id" list="targets"/></td>
					<td><en:label name="event_dt" /></td>
					<td><en:label name="event_cd" /></td>
					<td><en:input type="label" name="event_status" list="#{'0':'発生中','1':'解消済'}"/></td>
					<td><en:label name="status_dt" /></td>
					<td><en:label name="event_name" /></td>
					<td><en:label name="event_info" /></td>
					<td><en:input type="label" name="alert_status" list="#{'0':'未取得','2':'取得済'}"/></td>
					<td><en:label name="alert_dt" /></td>
					<td><en:label name="regist_dt" /></td>

				</tr>
			</en:iterator>
		</table>
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>