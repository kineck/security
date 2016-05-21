<%@ include file="../../common/inc.jsp" %>
<c:forEach items="${resourceInfos}" var="resourceInfo" varStatus="keys">
    <%--<form:input path="" autocomplete="true"></form:input>--%>
    ${keys.count}| <a href="${pageContext.request.contextPath}${resourceInfo.resourceUri}">
        ${resourceInfo.resourceUri}
</a><br>
</c:forEach>