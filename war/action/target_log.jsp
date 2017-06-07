<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="https://engawa.jp/s3/engawa.gs.tld" prefix="en"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./include/include.jsp" />
<style>
.events_div {
	float:right;
	margin-right:10px;
}
.events_div .tbl {
	width:300px;
}
.event_status0 {
	color:red;
}
.event_status1 {
	color:green;
}
</style>
</head>
<body>
	<jsp:include page="./include/header.jsp" />
	<h2><en:label>Target Log</en:label></h2>
	<div class="container">
		<div class="control">
			<div class="control_item"><en:label link="./targets.do">List</en:label></div>
			<div class="control_item"><en:label link="./target.do?id={id}">Info</en:label></div>			
			<div class="clear"></div>
		</div>
	
		<div class="block">
			<div class="frm">
				<form action="target_log.do" method="get">
					<en:input type="hidden" name="id" />

					<div class="frmitem">
						<div class="frmtitle"><en:label>Shop</en:label></div>
						<div class="frmfield"><en:input type="label" name="shop_id" list="shops"/></div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Target</en:label></div>
						<div class="frmfield">
							<en:input type="label" name="target_cd"/> <en:input type="label" name="target_name"/>
						</div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle"><en:label>Ymd</en:label></div>
						<div class="frmfield">
							<en:input type="date" name="ymd" cssClass="datefield"/>
						</div>
						<div class="clear"></div>
					</div>
					<div class="frmbuttons">
						<en:input type="submit" cssClass="frmsubmit" value="Search"/>
					</div>					
				</form>
			</div>
		</div>
		
		<div class="block events_div">
			<table class="tbl">
			<tr>
				<th><en:label>Event Date</en:label></th>
				<th><en:label>Evnet Status</en:label></th>
				<th><en:label>Evnet Name</en:label></th>
			</tr>
			<en:iterator name="events">
				<tr>
					<td><en:label name="event_dt"/></td>
					<td class="event_status<en:label name="event_status"/>">
						<en:input type="label" name="event_status" list="#{'0':'発生中','1':'解消済'}"/>
					</td>
					<td><en:label name="event_name"/></td>
				</tr>
			</en:iterator>
			</table>

		</div>
		
		
		<div class="block">
			<en:label name="graph" escape="false"/>		
		</div>
		
		<table class="tbl">
			<tr>
				<th><en:label>Log Dt</en:label></th>
				<th><en:label>Cur Tmp</en:label></th>

			</tr>
			<en:iterator>
				<tr>
					<td><en:label name="log_dt" /></td>
					<td class="right"><en:label name="cur_tmpStr" /></td>
				</tr>
			</en:iterator>
		</table>
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>