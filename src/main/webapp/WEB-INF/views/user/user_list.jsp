<%--
  Created by IntelliJ IDEA.
  User: MouZa
  Date: 16/5/17
  Time: 下午12:44
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../../common/tags.jsp"%>
<c:forEach var="userInfo" items="${userInfos}">
    <h1>${userInfo.userUuid}--${userInfo.password}</h1>
</c:forEach>
