<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();%>
<c:set var="path" value="<%=basePath %>"/>
<link rel="stylesheet" href="${path}/resource/css/style.css" type="text/css" media="all">
<script type="text/javascript" src="${path}/resource/js/jquery-1.6.js" ></script>
<script type="text/javascript" src="${path}/resource/js/html5.js" ></script>
