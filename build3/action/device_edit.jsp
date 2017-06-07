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
			<en:if name="upd">
				<div class="control_item"><en:label link="./device.do?id={id}">Info</en:label></div>
			</en:if>
			<div class="clear"></div>
		</div>
	
		<div class="block">
			<div class="frm">
				<form action="device_edit.do" method="post">
					<en:if name="upd">
						<en:input type="hidden" name="id" />
						<div class="frmitem">
							<div class="frmtitle"><en:label>ID</en:label></div>
							<div class="frmfield"><en:input type="label" name="id" cssClass="textfield"/></div>
							<div class="clear"></div>
						</div>
					</en:if>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Device Cd</en:label></div>
						<div class="frmfield"><en:input type="text" name="device_cd" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Shop</en:label></div>
						<div class="frmfield"><en:input type="select" name="shop_id" cssClass="selectfield" list="shops"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Target</en:label></div>
						<div class="frmfield"><en:input type="select" name="target_id" cssClass="selectfield" list="targets"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Start Dt</en:label></div>
						<div class="frmfield">
							<en:input type="date" name="start_dt_ymd" cssClass="datefield"/>
							<en:input type="select" name="start_dt_hm" cssClass="selectfield" list="hms"/>
						</div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>End Dt</en:label></div>
						<div class="frmfield">
							<en:input type="date" name="end_dt_ymd" cssClass="datefield"/>
							<en:input type="select" name="end_dt_hm" cssClass="selectfield" list="hms"/>
							
						</div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Device Type</en:label></div>
						<div class="frmfield"><en:input type="select" name="device_type" cssClass="selectfield" list="#{'0':'温度計','1':'アラート'}"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Device Status</en:label></div>
						<div class="frmfield"><en:input type="select" name="device_status" cssClass="selectfield" list="#{'0':'稼働中','1':'停止中'}"/></div>
						<div class="clear"></div>
					</div>
					<en:if name="upd">
						<div class="frmitem">
							<div class="frmtitle"><en:label>Last Access</en:label></div>
							<div class="frmfield"><en:input type="label" name="last_access" cssClass="textfield"/></div>
							<div class="clear"></div>
						</div>
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
					<form action="device_edit.do" method="post" onsubmit="return confirm('データを削除します。よろしいですか？');">
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