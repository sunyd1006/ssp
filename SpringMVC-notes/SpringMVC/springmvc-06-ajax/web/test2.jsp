<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/18 0018
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                // console.log('点击事件成功')
                // $.post(url,param,[可以省略],success)
                $.post("${pageContext.request.contextPath}/a2",function (data) {
                    console.log(data[0].name);
                    let html =  "";
                    for (let i = 0; i < data.length; i++) {
                        html += `<tr>
                                    <td>${"${data[i].name}"}</td>
                                    <td>${"${data[i].age}"}</td>
                                    <td>${"${data[i].sex}"}</td>
                                </tr>`
                    }
                    $("#content").html(html)
                    console.log(html)
                })
            })
        })
    </script>
</head>
<body>
<input type="button" value="加载数据" id="btn">
<table>
    <thead>
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
        </tr>
    </thead>
    <tbody id="content">
        <%--数据：后台--%>
    </tbody>
</table>
</body>
</html>
