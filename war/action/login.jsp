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
	<h2><en:label>Login</en:label></h2>
	<div class="container">
		<div class="block">
			<div class="frm">
				<form action="./login.do" method="post" name="frm">
					<div class="frmitem">
						<div class="frmtitle">User ID</div>
						<div class="frmfield">
							<en:input type="text" name="userid" cssClass="textfield" value="admin"/>
						</div>
						<div class="clear"></div>
					</div>
					<div class="frmitem">
						<div class="frmtitle">Password</div>
						<div class="frmfield">
							<en:input type="password" name="psw" cssClass="passwordfield" value="password"/>
						</div>
						<div class="clear"></div>
					</div>
					<div class="frmbuttons">
						<en:input type="submit" label="Login" cssClass="frmbutton loginbutton"/>
					</div>
				</form>
			</div><!-- frm -->
		</div><!-- block -->
	</div><!-- container -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>