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
	<h2><en:label>Tlog</en:label></h2>
	<div class="container">
		<div class="control">
			<div class="control_item"><en:label link="./tlogs.do">List</en:label></div>
			<div class="control_item"><en:label link="./tlog_edit.do?id={id}">Edit</en:label></div>
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
					<div class="frmtitle"><en:label>Event Id</en:label></div>
					<div class="frmfield"><en:input type="label" name="event_id"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Log Id</en:label></div>
					<div class="frmfield"><en:input type="label" name="log_id"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Cur Tmp</en:label></div>
					<div class="frmfield"><en:input type="label" name="cur_tmp"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Log Dt</en:label></div>
					<div class="frmfield"><en:input type="label" name="log_dt"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Shop Id</en:label></div>
					<div class="frmfield"><en:input type="label" name="shop_id"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Target Id</en:label></div>
					<div class="frmfield"><en:input type="label" name="target_id"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Event Status</en:label></div>
					<div class="frmfield"><en:input type="label" name="event_status"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Device Id</en:label></div>
					<div class="frmfield"><en:input type="label" name="device_id"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Log Key</en:label></div>
					<div class="frmfield"><en:input type="label" name="log_key"/></div>
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