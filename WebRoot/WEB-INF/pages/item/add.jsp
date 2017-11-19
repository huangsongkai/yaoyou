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
            price:1.00,
            state:1,
            storageCount:10,
            description:"高大上",
            shopInfoId:"500dba0a-64a0-47b4-a5a8-c3e77b0eacb3",
            medicineId:"a9c60f29-49ff-45fe-9761-4accdc2fd29d"
        };
    </script>
    <table class="table table-striped submit_form" style="align-content: center;width: 600px">
        <thead><tr><td><input type="button" class="submit_button btn btn-primary" url="/item" method="post" value="提交"/></td></tr></thead>
        <tbody>
        </tbody>
    </table>
    说明：状态1表示，有效发布状态，请确保shopInfoId和medicineId的有效性（暂时没加外键约束）
    <script src="/js/jquery-2.2.1.min.js"></script>
    <script src="/js/common.js"></script>

</body>
</html>


