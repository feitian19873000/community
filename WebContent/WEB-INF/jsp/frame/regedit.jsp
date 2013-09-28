<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ include file="../common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${not empty user}"><title>用户注册</title></c:if>
<c:if test="${empty user}"><title>用户修改</title></c:if>
</head>
<body style="align:center">
	<div>
		<form action="${path}/base/save" method="POST" >
			<p>
				<label for="name">用户名：</label><br/>
				<input type="text" name="name" value="${user.name}" />
			</p>
			<p>
				<label for="alias">昵称：</label><br/>
				<input type="text" name="alias" value="${user.alias}" />
			</p>
			<p>
				<label for="male">男</label>
				<input type="radio" name="sex" value="${user.sex}"/>
				<label for="female">女</label>
				<input type="radio" name="sex" value="${user.sex}"/>
			</p>
			<p>
				<label for="birthday">生日：</label>
				<input type="date" name="birthday" value="${user.birthday}"/>
			</p>
			<p>
				<label for="tel">电话</label>
				<input type="number" name="tel" value="${user.tel}"/>
			</p>
			<p>
				<label for="email">邮箱</label>
				<input type="email" name="email" value="${user.email}"/>
			</p>
			<p>
				<c:choose>
					<c:when test="${empty user}">
						<input type="submit" value="注册" />
					</c:when>
					<c:otherwise>
						<input type="submit" value="修改"/>
					</c:otherwise>
				</c:choose>				
			</p>
		</form>
	</div>
</body>
</html>