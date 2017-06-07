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
	<h2><en:label>Shop_group</en:label></h2>
	<div class="container">
		<div class="control">
			<div class="control_item">
				<a href="./shop_group_edit.do"><en:label>New</en:label></a>
			</div>
			<div class="clear"></div>
		</div>
		<table class="tbl">
			<tr>
				<th><en:label>ID</en:label></th>
				<th><en:label>Group Cd</en:label></th>
				<th><en:label>Group Level</en:label></th>
				<th><en:label>Group Name</en:label></th>
				<th><en:label>Super Group Id</en:label></th>
				<th><en:label>Group Desc</en:label></th>
				<th><en:label>Registered</en:label></th>

			</tr>
			<en:iterator>
				<tr>
					<td><en:label link="./shop_group.do?id={id}" name="id" /></td>
					<td><en:label name="group_cd" /></td>
					<td><en:label name="group_level" /></td>
					<td><en:label name="group_name" /></td>
					<td><en:label name="super_group_id" /></td>
					<td><en:label name="group_desc" /></td>
					<td><en:label name="regist_dt" /></td>

				</tr>
			</en:iterator>
		</table>
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>