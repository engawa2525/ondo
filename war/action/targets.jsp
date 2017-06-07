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
	<h2><en:label>Target</en:label></h2>
	<div class="container">
		<div class="control">
			<div class="control_item">
				<a href="./target_edit.do"><en:label>New</en:label></a>
			</div>
			<div class="clear"></div>
		</div>
		<table class="tbl">
			<tr>
				<th><en:label>ID</en:label></th>
				<th><en:label>Shop</en:label></th>
				<th><en:label>Code</en:label></th>
				<th><en:label>Name</en:label></th>
				<th><en:label>Alert Num</en:label></th>
				<th><en:label>Desc</en:label></th>
				<th><en:label>Status</en:label></th>
				<th><en:label>Status Msg</en:label></th>
				<th><en:label>Target Def Id</en:label></th>		
				<th><en:label>Min Temp</en:label></th>
				<th><en:label>Max Temp</en:label></th>
				<th><en:label>Current Temp</en:label></th>
				<th><en:label>Err Cnt</en:label></th>
				<th><en:label>Last Report</en:label></th>
				<%--
				<th><en:label>Last Log Id</en:label></th>
				 --%>
				<th><en:label>Registered</en:label></th>

			</tr>
			<en:iterator>
				<tr>
					<td><en:label link="./target.do?id={id}" name="id" /></td>
					<td><en:input type="label" name="shop_id" list="shops"/></td>
					<td><en:label name="target_cd" /></td>
					<td><en:label name="target_name" /></td>
					<td><en:label name="alert_num" /></td>
					<td><en:label name="target_desc" /></td>
					<td><en:input type="label" name="target_status" list="{'0':'稼働中','1':'停止中'}"/></td>
					<td><en:label name="status_msg" /></td>
					<td><en:input type="label" name="target_def_id" list="defs"/></td>
					<td class="right"><en:label name="min_temp" /></td>
					<td class="right"><en:label name="max_temp" /></td>
					<td class="right"><en:label name="current_temp" /></td>
					<td class="right"><en:label name="err_cnt" /></td>
					<td><en:label name="last_report" /></td>
					<%--
					<td><en:label name="last_log_id" /></td>
					 --%>
					<td><en:label name="regist_dt" /></td>

				</tr>
			</en:iterator>
		</table>
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>