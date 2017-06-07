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
	<h2><en:label>{title}</en:label></h2>
	<div class="container">
		<div class="control">
			<div class="control_item"><en:label link="./{name}s.do">List</en:label></div>
			<en:if name="upd">
				<div class="control_item"><en:label link="./{name}.do?id={id}">Info</en:label></div>
			</en:if>
			<div class="clear"></div>
		</div>
	
		<div class="block">
			<div class="frm">
				<form action="{name}_edit.do" method="post">
{frm}
					<div class="frmbuttons">
						<en:input type="submit" cssClass="frmsubmit" />
					</div>
				</form>
			</div><!-- frm -->
		</div><!-- block -->	
		
		<en:if name="upd">		
			<div class="block">
				<div class="frm">
					<form action="{name}_edit.do" method="post" onsubmit="return confirm('データを削除します。よろしいですか？');">
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