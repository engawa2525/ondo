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
			<en:if name="upd">
				<div class="control_item"><en:label link="./target.do?id={id}">Info</en:label></div>
			</en:if>
			<div class="clear"></div>
		</div>
	
		<div class="block">
			<div class="frm">
				<form action="target_edit.do" method="post">
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
						<div class="frmfield"><en:input type="select" name="shop_id" cssClass="selectfield" list="shops"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Target Cd</en:label></div>
						<div class="frmfield"><en:input type="text" name="target_cd" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Target Name</en:label></div>
						<div class="frmfield"><en:input type="text" name="target_name" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Target Desc</en:label></div>
						<div class="frmfield"><en:input type="textarea" name="target_desc" cssClass="textarea"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Target Status</en:label></div>
						<div class="frmfield">
							<en:input type="select" name="target_status" cssClass="selectfield" list="{'0':'稼働中','1':'停止中'}"/>
						</div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Target Def Id</en:label></div>
						<div class="frmfield"><en:input type="select" name="target_def_id" cssClass="textfield" list="defs"/></div>
						<div class="clear"></div>
					</div>					
					<div class="frmitem">
						<div class="frmtitle"><en:label>Alert Num</en:label></div>
						<div class="frmfield"><en:input type="text" name="alert_num" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Min Temp</en:label></div>
						<div class="frmfield"><en:input type="text" name="min_temp" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Max Temp</en:label></div>
						<div class="frmfield"><en:input type="text" name="max_temp" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Current Temp</en:label></div>
						<div class="frmfield"><en:input type="label" name="current_temp" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Err Cnt</en:label></div>
						<div class="frmfield"><en:input type="label" name="err_cnt" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Last Report</en:label></div>
						<div class="frmfield"><en:input type="label" name="last_report" cssClass="textfield"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Last Log Id</en:label></div>
						<div class="frmfield"><en:input type="label" name="last_log_id" cssClass="textfield"/></div>
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
					<form action="target_edit.do" method="post" onsubmit="return confirm('データを削除します。よろしいですか？');">
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