<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/27
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop管理界面</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <style type="text/css">
        strong{color:darkred}
    </style>
</head>
<body>
<h1>${message}</h1><br>

<table class="table table-striped" style="align-content: center;width: 600px">
    <tbody>
    <tr>
        <td><a href="/managerShop/productManager/1" methods="post">商品列表</a></td>
        <td><a href="/managerShop/listOrder/1">查看订单</a></td>
        <td><a href="/managerShop/listShopProduct/1">我的商品列表</a></td>
    </tr>
    </tbody>
</table>



<script src="/js/jquery-2.2.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
