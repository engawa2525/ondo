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
		<div class="control">
			<div class="control_item"><en:label link="./events.do">List</en:label></div>
			<div class="control_item"><en:label link="./event_edit.do?id={id}">Edit</en:label></div>
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
					<div class="frmtitle"><en:label>Shop</en:label></div>
					<div class="frmfield"><en:input type="label" name="shop_id"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Target</en:label></div>
					<div class="frmfield"><en:input type="label" name="target_id"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Event Dt</en:label></div>
					<div class="frmfield"><en:input type="label" name="event_dt"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Event Cd</en:label></div>
					<div class="frmfield"><en:input type="label" name="event_cd"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Event Status</en:label></div>
					<div class="frmfield"><en:input type="label" name="event_status"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Status Dt</en:label></div>
					<div class="frmfield"><en:input type="label" name="status_dt"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Event Name</en:label></div>
					<div class="frmfield"><en:input type="label" name="event_name"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Event Info</en:label></div>
					<div class="frmfield"><en:input type="label" name="event_info"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Alert Status</en:label></div>
					<div class="frmfield"><en:input type="label" name="alert_status"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Alert Dt</en:label></div>
					<div class="frmfield"><en:input type="label" name="alert_dt"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Mail Dt</en:label></div>
					<div class="frmfield"><en:input type="label" name="mail_dt"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Mail Status</en:label></div>
					<div class="frmfield"><en:input type="label" name="mail_status"/></div>
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