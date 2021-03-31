<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/18 0018
  Time: 8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>iframe测试体验页面无刷新</title>
    <script>
        function go() {
            //所有的变量，提前获取
            var url = document.getElementById("url").value;
            document.getElementById("iframe1").src = url;
        }
    </script>
</head>
<body>
<div>
    <p>请输入地址：</p>
    <p>
        <input type="text" id="url" value="http://www.baidu.com">
        <input type="button" value="提交" onclick="go()">
    </p>

</div>
<div>
    <iframe id="iframe1" style="width:100%;height:500px;"></iframe>
</div>
</body>
</html>
