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
            medicineName:'medicineName',
            medicineManufacturer:'medicineManufacturer',
            imgUrl:'imgUrl',
            classify:'1',
            medicineFuction:'medicineFuction',
            crowd:'children',
            numCode:'numCode',
            price:1.0,
            spec:'spec',
            state:'state',
            avgRate:0.0,
            createUserName:'balala',
            createUserId:'ff6342f4-095b-4bc0-86b2-f4c9a8eaec98'
        };
    </script>
    <table class="table table-striped submit_form" style="align-content: center;width: 600px">
        <thead><tr><td><input type="button" class="submit_button btn btn-primary" url="/medicine" method="post" value="修改"/></td></tr></thead>
        <tbody>
        </tbody>
    </table>
    <script src="/js/jquery-2.2.1.min.js"></script>
    <script src="/js/common.js"></script>

</body>
</html>


