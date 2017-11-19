<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 16/7/22
  Time: 下午12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
    <script>
        var table_init ={
            id:2,
            hh: '13',
            mm: '30',
            state: true
        };
    </script>
    <table class="table table-striped submit_form" style="align-content: center;width: 600px">
        <thead><tr><td><input type="button" class="submit_button btn btn-primary" url="/remind/timeTable" method="put" value="提交"/></td></tr></thead>
        <tbody>
        </tbody>
    </table>

    添加json<br>
    {id:"2", hh: "12", mm: "30", state: true}<br>
    返回值：id<br>
    method:put<br><br>
    <script src="/js/jquery-2.2.1.min.js"></script>
    <script src="/js/common.js"></script>

</body>
</html>


