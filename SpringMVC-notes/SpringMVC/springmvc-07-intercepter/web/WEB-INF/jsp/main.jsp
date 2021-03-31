<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/18 0018
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>首页</h1>
<span>${password}</span>
<span>${username}</span>

<p>
    <a href="${pageContext.request.contextPath}/user/goOut">注销</a>
</p>

</body>
</html>
