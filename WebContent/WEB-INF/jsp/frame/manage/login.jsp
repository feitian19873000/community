<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ include file="../../common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${path}/resource/css/login.css" />
<title>用户登录</title>
</head>
<body>
	<div class="wrapper">
		${globalMsg}
		<form action="${path}/base/login" method="post" >
		<div class="loginBox">
			<div class="loginBoxCenter">
				<p><label for="username">用户名：</label></p>
				<p><input type="text" id="username" name="name" class="loginInput"  autofocus="autofocus" required="required" tabindex="1" autocomplete="off" placeholder="请输入用户名" value="" /></p>
				<p><label for="password">密码：</label><a class="forgetLink" href="#">忘记密码?</a></p>
				<p><input type="password" id="password" name="password" class="loginInput" required="required" tabindex="2" placeholder="请输入密码" value="" /></p>
			</div>
			<div class="loginBoxButtons">
				<input id="remember" type="checkbox" name="remember" />
				<label for="remember">记住登录状态</label>
				<input class="loginBtn" type="submit" value="登录"/>
			</div>
		</div>
		</form>
	</div>
</body>
</html>