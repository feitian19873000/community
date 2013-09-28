<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>
<script type="text/javascript" src="${path}/resource/js/date.js"></script>
<!DOCTYPE >
<div class="main">
	<span class="top_date">星期一 2013-09-24 16:27</span>
	<nav>
		<ul id="top_nav">
			<li>
				<c:if test="${LOGINUSER == null}">
					<a href="${path}/base/goLogin">登录</a>
				</c:if>
				<c:if test="${LOGINUSER !=null}">
					<a href="#">${LOGINUSER.user.name}</a>
				</c:if>
			</li>
			<li>|</li>
			<li><a href="${path}/base/regedit">注册</a></li>
			<li>|</li>
			<li class="end"><a href="${path}/base">游览</a></li>
		</ul>
	</nav>
</div>
