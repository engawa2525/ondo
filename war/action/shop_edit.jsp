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
	<h2><en:label>Shop</en:label></h2>
	<div class="container">
		<div class="control">
			<div class="control_item"><en:label link="./shops.do">List</en:label></div>
			<en:if name="upd">
				<div class="control_item"><en:label link="./shop.do?id={id}">Info</en:label></div>
			</en:if>
			<div class="clear"></div>
		</div>
	
		<div class="block">
			<div class="frm">
				<form action="shop_edit.do" method="post">
					<en:if name="upd">
						<en:input type="hidden" name="id" />
						<div class="frmitem">
							<div class="frmtitle"><en:label>ID</en:label></div>
							<div class="frmfield"><en:input type="label" name="id" cssClass="textfield"/></div>
							<div class="clear"></div>
						</div>
					</en:if>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Shop Cd</en:label></div>
						<div class="frmfield"><en:input type="text" name="shop_cd" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Shop Name</en:label></div>
						<div class="frmfield"><en:input type="text" name="shop_name" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Mail Addr</en:label></div>
						<div class="frmfield"><en:input type="text" name="mail_addr" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Open Ymd</en:label></div>
						<div class="frmfield"><en:input type="date" name="open_ymd" cssClass="datefield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Close Ymd</en:label></div>
						<div class="frmfield"><en:input type="date" name="close_ymd" cssClass="datefield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Alert Status</en:label></div>
						<div class="frmfield"><en:input type="text" name="alert_status" cssClass="textfield"/></div>
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
					<form action="shop_edit.do" method="post" onsubmit="return confirm('データを削除します。よろしいですか？');">
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