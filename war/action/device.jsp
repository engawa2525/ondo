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
			<div class="control_item"><en:label link="./devices.do">List</en:label></div>
			<div class="control_item"><en:label link="./target_log.do?id={target_id}">Log</en:label></div>
			<div class="control_item"><en:label link="./device_edit.do?id={id}">Edit</en:label></div>
			<div class="clear"></div>
		</div>
	
		<div class="block">
			<div class="frm">
				<div class="frmitem">
					<div class="frmtitle"><en:label>ID</en:label></div>
					<div class="frmfield"><en:input type="label" name="id"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Device Cd</en:label></div>
					<div class="frmfield"><en:input type="label" name="device_cd"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Shop</en:label></div>
					<div class="frmfield"><en:input type="label" name="shop_id" list="shops"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Target</en:label></div>
					<div class="frmfield"><en:input type="label" name="target_id" list="targets"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Start Dt</en:label></div>
					<div class="frmfield"><en:input type="label" name="start_dt"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>End Dt</en:label></div>
					<div class="frmfield"><en:input type="label" name="end_dt"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Device Type</en:label></div>
					<div class="frmfield"><en:input type="label" name="device_type" list="#{'0':'温度計','1':'アラート'}"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Device Status</en:label></div>
					<div class="frmfield"><en:input type="label" name="device_status" list="#{'0':'稼働中','1':'停止中'}"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Last Access</en:label></div>
					<div class="frmfield"><en:input type="label" name="last_access"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Registered</en:label></div>
					<div class="frmfield"><en:input type="label" name="regist_dt"/></div>
					<div class="clear"></div>
				</div>

			</div><!-- frm -->
		</div><!-- block -->	
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>