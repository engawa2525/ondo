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
			<div class="control_item"><en:label link="./targetdefs.do">List</en:label></div>
			<div class="control_item"><en:label link="./targetdef_edit.do?id={id}">Edit</en:label></div>
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
					<div class="frmtitle"><en:label>Target Def Name</en:label></div>
					<div class="frmfield"><en:input type="label" name="target_def_name"/></div>
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
					<div class="frmtitle"><en:label>Alert Err Cnt</en:label></div>
					<div class="frmfield"><en:input type="label" name="alert_err_cnt"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Normal Interval</en:label></div>
					<div class="frmfield"><en:input type="label" name="normal_interval"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Alert Interval</en:label></div>
					<div class="frmfield"><en:input type="label" name="alert_interval"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Graph Option</en:label></div>
					<div class="frmfield"><en:input type="label" name="graph_option"/></div>
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