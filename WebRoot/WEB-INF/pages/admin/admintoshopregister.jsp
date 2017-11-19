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
            shopName:'xx商店',
            seq:'10',
            shopAddress:'xx大街xx号',
            shopTel:'13000000000',
            imgUrl:'C:/12312314',
            gpsX:'111258',
            gpsY:'14125',
            avgRate:'0'
        };
    </script>
    <table class="table table-striped submit_form" style="align-content: center;width: 600px">
        <thead><tr><td><input type="button" class="submit_button btn btn-primary" url="/admin/newShop" method="post" value="提交"/></td></tr></thead>
        <tbody>
        </tbody>
    </table>
    <script src="/js/jquery-2.2.1.min.js"></script>
    <script src="/js/common.js"></script>

    错误代码<br>
    -1:电话存在<br>
    -2:用户名已存在<br>
    <p style="color: #761c19">创建商店的时候自动创建一个商店管理员，管理的用户名为商店名，密码为admin</p>
</body>
</html>


