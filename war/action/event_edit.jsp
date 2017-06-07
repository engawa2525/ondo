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
			<en:if name="upd">
				<div class="control_item"><en:label link="./event.do?id={id}">Info</en:label></div>
			</en:if>
			<div class="clear"></div>
		</div>
	
		<div class="block">
			<div class="frm">
				<form action="event_edit.do" method="post">
					<en:if name="upd">
						<en:input type="hidden" name="id" />
						<div class="frmitem">
							<div class="frmtitle"><en:label>ID</en:label></div>
							<div class="frmfield"><en:input type="label" name="id" cssClass="textfield"/></div>
							<div class="clear"></div>
						</div>
					</en:if>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Shop</en:label></div>
						<div class="frmfield"><en:input type="label" name="shop_id" cssClass="textfield" list="shops"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Target Id</en:label></div>
						<div class="frmfield"><en:input type="label" name="target_id" cssClass="textfield" list="targets"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Event Dt</en:label></div>
						<div class="frmfield"><en:input type="label" name="event_dt" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Event Cd</en:label></div>
						<div class="frmfield"><en:input type="label" name="event_cd" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Event Name</en:label></div>
						<div class="frmfield"><en:input type="label" name="event_name" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Event Info</en:label></div>
						<div class="frmfield"><en:input type="label" name="event_info" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Event Status</en:label></div>
						<div class="frmfield">
							<en:input type="select" name="event_status" cssClass="selectfield" list="#{'0':'発生中','1':'解消済'}"/>
							<en:input type="label" name="status_dt" cssClass="textfield"/>
						</div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Alert Status</en:label></div>
						<div class="frmfield">
							<en:input type="select" name="alert_status" cssClass="selectfield" list="#{'0':'未取得','2':'取得済'}"/>
							<en:input type="label" name="alert_dt" cssClass="textfield"/>
						</div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Mail Status</en:label></div>
						<div class="frmfield">
							<en:input type="select" name="mail_status" cssClass="selectfield" list="#{'0':'未取得','2':'取得済'}"/>
							<en:input type="label" name="mail_dt" cssClass="textfield"/>
						</div>
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
					<form action="event_edit.do" method="post" onsubmit="return confirm('データを削除します。よろしいですか？');">
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