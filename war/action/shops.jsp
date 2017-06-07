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
	<h2><en:label>Shop</en:label></h2>
	<div class="container">
		<div class="control">
			<div class="control_item">
				<a href="./shop_edit.do"><en:label>New</en:label></a>
			</div>
			<div class="clear"></div>
		</div>
		<table class="tbl">
			<tr>
				<th><en:label>ID</en:label></th>
				<th><en:label>Shop Cd</en:label></th>
				<th><en:label>Shop Name</en:label></th>
				<th><en:label>Mail Addr</en:label></th>
				<th><en:label>Open Ymd</en:label></th>
				<th><en:label>Close Ymd</en:label></th>
				<th><en:label>Alert Status</en:label></th>
				<th><en:label>Registered</en:label></th>

			</tr>
			<en:iterator>
				<tr>
					<td><en:label link="./shop.do?id={id}" name="id" /></td>
					<td><en:label name="shop_cd" /></td>
					<td><en:label name="shop_name" /></td>
					<td><en:label name="mail_addr" /></td>
					<td><en:label name="open_ymd" /></td>
					<td><en:label name="close_ymd" /></td>
					<td><en:label name="alert_status" /></td>
					<td><en:label name="regist_dt" /></td>

				</tr>
			</en:iterator>
		</table>
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>