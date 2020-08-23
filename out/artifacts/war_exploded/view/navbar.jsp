<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 01/06/2020
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link type="text/css" rel="stylesheet" href="../css/common.css" >
<jsp:useBean id="user" scope="session" type="bean.UserBean"></jsp:useBean>
<script>
    const logout = function () {
        let d = document.getElementById("log");
        d.submit();
    }
</script>

<ul id="navbar" class="nav">
    <c:forEach items="${user.pageList}" var="page">
    <c:set var="active" value="${fn:contains(pageContext.request.requestURI,page.name)}" />
    <li class="${active ? 'active' : 'none'}"><a href="${page.url}">${page.name}</a>
        </c:forEach>
    </li>
        <li style="margin-left:auto"><a style="color:white;">
    <form  id="log" action="LogoutServlet" method="post">
        ${user.fullName} ${user.course}&nbsp;&nbsp;<i onclick="logout()" class="fa fa-power-off" aria-hidden="true"></i>
    </form>
        </a></li>
</ul>