<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="https://engawa.jp/s3/engawa.gs.tld" prefix="en"%>
<%@taglib uri="https://engawa.jp/s3/engawa.ondo.tld" prefix="s3" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="./include/include.jsp" />
<style>
.events_div {
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
	<h2><en:label>Top</en:label></h2>
	<div class="container">
		<div class="block">
			<div class="top_menus">
				<div class="top_menu">
					<a href="shops.do" >店舗一覧</a>
				</div>
				<div class="top_menu">
					<a href="targets.do" >冷蔵庫一覧</a>
				</div>
				<div class="top_menu">
					<a href="devices.do" >温度計一覧</a>
				</div>
				<div class="top_menu">
					<a href="events.do" >イベント一覧</a>
				</div>
				<div class="top_menu">
					<a href="logs.do" >ログ</a>
				</div>
				<s3:kengen level="admin">
					<div class="top_menu">
						<a href="shop_groups.do" >店舗組織</a>
					</div>
				</s3:kengen>
				<s3:kengen level="admin">
					<div class="top_menu">
						<a href="user.do" >ユーザー</a>
					</div>
				</s3:kengen>
				<s3:kengen level="developer">
					<div class="top_menu">
						<a href="targetdefs.do" >冷蔵庫定義</a>
					</div>
				</s3:kengen>
				<div class="clear"></div>
			</div>
		</div>
		
		<div class="block events_div">
			<table class="tbl">
			<tr>
				<th><en:label>Shop</en:label></th>
				<th><en:label>Target</en:label></th>
				<th><en:label>Event Date</en:label></th>
				<th><en:label>Evnet Status</en:label></th>
				<th><en:label>Evnet Name</en:label></th>
				<th><en:label>Evnet Id</en:label></th>
			</tr>
			<en:iterator name="events">
				<tr>
					<td>
						<a href="./shop.do?id=<en:label name="shop_id"/>">
							<en:input type="label" name="shop_id" list="shops"/>
						</a>		
					</td>
							
					<td>
						<a href="./target.do?id=<en:label name="target_id"/>">
							<en:input type="label" name="target_id" list="targets"/>
						</a>			
					</td>
					<td><en:label name="event_dt"/></td>
					<td class="event_status<en:label name="event_status"/>">
						<en:input type="label" name="event_status" list="#{'0':'発生中','1':'解消済'}"/>
					</td>
					<td><en:label name="event_name"/></td>
					<td><en:label name="id" link="./event.do?id={id}"/></td>
				</tr>
			</en:iterator>
			</table>
		</div>		

		<div class="block">
			<div style="margin:10px;border:solid 1px #888;padding:10px;">
				<div class="top_calendar_control">
					<en:label link="./top.do?ym={prev_ym}" escape="false"><img src="../img/arrow_l.png" /></en:label>
					<en:label name="ymStr"/>
					<en:label link="./top.do?ym={next_ym}" escape="false"><img src="../img/arrow_r.png" /></en:label>
				</div>
				<hr/>
				<en:label name="calendar" escape="false"/>
			</div>
		</div><!-- block -->

	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>