<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ include file="../../common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<jsp:include page="../../common/top.jsp"></jsp:include>
	<div>
		<h2>Listing Users</h2>
		<c:if test="${not empty list}">
		<table>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>昵称</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.alias}</td>
					<td>
						<a href="${path}/base/delete/${user.id}">删除</a>
						<a href="${path}/base/update/${user.id}">更新</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty list}">没有您要找的数据</c:if>
	<div>
		<jsp:include page="../../common/page.jsp"></jsp:include>
	</div>
</div>
</body>
</html>