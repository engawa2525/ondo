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
			<en:if name="upd">
				<div class="control_item"><en:label link="./shop_group.do?id={id}">Info</en:label></div>
			</en:if>
			<div class="clear"></div>
		</div>
	
		<div class="block">
			<div class="frm">
				<form action="shop_group_edit.do" method="post">
					<en:if name="upd">
						<en:input type="hidden" name="id" />
						<div class="frmitem">
							<div class="frmtitle"><en:label>ID</en:label></div>
							<div class="frmfield"><en:input type="label" name="id" cssClass="textfield"/></div>
							<div class="clear"></div>
						</div>
					</en:if>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Group Cd</en:label></div>
						<div class="frmfield"><en:input type="text" name="group_cd" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<%--
					<div class="frmitem">
						<div class="frmtitle"><en:label>Group Level</en:label></div>
						<div class="frmfield"><en:input type="text" name="group_level" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					 --%>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Group Name</en:label></div>
						<div class="frmfield"><en:input type="text" name="group_name" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Super Group Id</en:label></div>
						<div class="frmfield"><en:input type="select" name="super_group_id" cssClass="selectfield" list="groups"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Group Desc</en:label></div>
						<div class="frmfield"><en:input type="textarea" name="group_desc" cssClass="textarea"/></div>
						<div class="clear"></div>
					</div>
					<en:if name="upd">
						<div class="frmitem">
							<div class="frmtitle"><en:label>Registered</en:label></div>
							<div class="frmfield"><en:input type="label" name="regist_dt" cssClass="textfield"/></div>
							<div class="clear"></div>
						</div>
					</en:if>

					<div class="frmbuttons">
						<en:input type="submit" cssClass="frmsubmit" />
					</div>
				</form>
			</div><!-- frm -->
		</div><!-- block -->	
		
		<en:if name="upd">		
			<div class="block">
				<div class="frm">
					<form action="shop_group_edit.do" method="post" onsubmit="return confirm('データを削除します。よろしいですか？');">
						<en:input type="hidden" name="cmd" value="del"/>
						<en:input type="hidden" name="id"/>
						<div class="frmbuttons">
							<en:input type="submit" cssClass="frmbutton delbutton" label="Delete"/>
						</div>
						<div class="clear"></div>
					</form>
				</div>
				<div class="clear"></div>
			</div>
		</en:if>		
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>