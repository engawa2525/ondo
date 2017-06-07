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
			<div class="control_item"><en:label link="./shop_groups.do">List</en:label></div>
			<div class="control_item"><en:label link="./shop_group_edit.do?id={id}">Edit</en:label></div>
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
					<div class="frmtitle"><en:label>Group Cd</en:label></div>
					<div class="frmfield"><en:input type="label" name="group_cd"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Group Level</en:label></div>
					<div class="frmfield"><en:input type="label" name="group_level"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Group Name</en:label></div>
					<div class="frmfield"><en:input type="label" name="group_name"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Super Group Id</en:label></div>
					<div class="frmfield"><en:input type="label" name="super_group_id"/></div>
					<div class="clear"></div>
				</div>
				<div class="frmitem">
					<div class="frmtitle"><en:label>Group Desc</en:label></div>
					<div class="frmfield"><en:input type="label" name="group_desc"/></div>
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