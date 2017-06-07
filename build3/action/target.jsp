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
			<div class="control_item"><en:label link="./targets.do">List</en:label></div>
			<div class="control_item"><en:label link="./target_log.do?id={id}">Log</en:label></div>
			<div class="control_item"><en:label link="./target_edit.do?id={id}">Edit</en:label></div>
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
					<div class="frmfield"><en:input type="label" name="shop_id" list="shops"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Target Cd</en:label></div>
					<div class="frmfield"><en:input type="label" name="target_cd"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Target Name</en:label></div>
					<div class="frmfield"><en:input type="label" name="target_name"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Target Desc</en:label></div>
					<div class="frmfield"><en:input type="label" name="target_desc"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Target Status</en:label></div>
					<div class="frmfield"><en:input type="label" name="target_status" list="{'0':'稼働中','1':'停止中'}"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Target Def Id</en:label></div>
					<div class="frmfield"><en:input type="label" name="target_def_id" list="defs"/></div>
					<div class="clear"></div>
				</div>				
				<div class="frmitem">
					<div class="frmtitle"><en:label>Alert Num</en:label></div>
					<div class="frmfield"><en:input type="label" name="alert_num"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Min Temp</en:label></div>
					<div class="frmfield"><en:input type="label" name="min_temp"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Max Temp</en:label></div>
					<div class="frmfield"><en:input type="label" name="max_temp"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Current Temp</en:label></div>
					<div class="frmfield"><en:input type="label" name="current_temp"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Err Cnt</en:label></div>
					<div class="frmfield"><en:input type="label" name="err_cnt"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Last Report</en:label></div>
					<div class="frmfield"><en:input type="label" name="last_report"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Last Log Id</en:label></div>
					<div class="frmfield"><en:input type="label" name="last_log_id"/></div>
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