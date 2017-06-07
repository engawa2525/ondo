<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib uri="https://engawa.jp/s3/engawa.gs.tld" prefix="en" %>
<%@taglib uri="https://engawa.jp/s3/engawa.ondo.tld" prefix="s3" %>
<div class="footer">
	<div class="footer_text">Copyright &copy; 2017 Engawa Inc. All Rights Reserved.</div>
</div>
<s3:kengen level="developer">
<div class="gen_links">
	<a href="<en:label name="requestURI" escape="false"/>?cmd=info.jsp.code">info.jsp.code</a>
	<a href="<en:label name="requestURI" escape="false"/>?cmd=edit.jsp.code">edit.jsp.code</a>
	<a href="<en:label name="requestURI" escape="false"/>?cmd=table.jsp.code">table.jsp.code</a>
	<%--
	<a href="<en:label name="requestURI" escape="false"/>?cmd=entity.set.code">entity.set.code</a>
	 --%>
	<a href="<en:label name="requestURI" escape="false"/>?cmd=info.class.code">info.class.code</a>
	<a href="<en:label name="requestURI" escape="false"/>?cmd=edit.class.code">edit.class.code</a>
	<a href="<en:label name="requestURI" escape="false"/>?cmd=table.class.code">table.class.code</a>
	<a href="<en:label name="requestURI" escape="false"/>?cmd=item.class.code">item.class.code</a>
</div>
</s3:kengen>
<%--
<div class="footer_link_div">
	<div class="footer_link">
		<a href="https://icons8.com">Icon pack by Icons8</a>
	</div>
</div>
 --%>
