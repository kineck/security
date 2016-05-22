<%--
  Created by IntelliJ IDEA.
  User: MouZa
  Date: 16/5/19
  Time: 下午2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../../common/tags.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${MethodList}" var="url">
    <a href="${pageContext.request.contextPath}${url.requestUrl}">
            ${url.requestUrl}
    </a>
    <br>
</c:forEach>
</body>
</html>
