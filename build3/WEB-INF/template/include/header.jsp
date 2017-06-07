<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib uri="https://engawa.jp/s3/engawa.gs.tld" prefix="en" %>
<div class="header">
	<en:if name="login">
		<div class="logout">
			<a href="<en:config key="action.logout"/>"><en:label>Logout</en:label></a>
		</div>
		<div class="userinfo">
			<div class="username">
				<en:label attr="ondo.user" name="name" />
			</div>
		</div>
	</en:if>
	<en:if name="login" not="true">
		<en:if name="loginPage" not="true">
			<div class="logout">
				<a href="<en:config key="action.login"/>"><en:label>Login</en:label></a>
			</div>
		</en:if>
	</en:if>
	<h1 class="logo"><a href="<en:config key="action.top"/>"><en:config key="application.title" /></a></h1>
</div><!-- header -->
<en:if name="hasErrmsg">
	<div class="errmsg" id="errmsg">
		<en:label name="errmsg" />
	</div>
</en:if>
<en:if name="hasErrmsg" not="true">
	<div class="errmsg" style="display:none;" id="errmsg">
	</div>
</en:if>
<en:if name="hasInfo">
	<div class="info">
		<en:label name="info" />
	</div>
</en:if>
