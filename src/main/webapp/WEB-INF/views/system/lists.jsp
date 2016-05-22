<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/tags.jsp" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>


<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style type="text/css" rel="stylesheet"
    href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"></style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <title></title>
</head>
<body>
<a href="${pageContext.request.contextPath}/resource/fixres">修复资源列表</a><br>
<c:forEach items="${resourceInfos}" var="resourceInfo" varStatus="keys">
    ${keys.count}| <a href="${pageContext.request.contextPath}${resourceInfo.resourceUri}">
        ${resourceInfo.resourceUri}
</a><br>
</c:forEach>
</body>
</html>