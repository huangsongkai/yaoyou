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
    <title>管理员页面</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <style type="text/css">
        strong{color:darkred}
    </style>
</head>
<body>
<h1>后台管理</h1><br>
Admin
<table class="table table-striped" style="align-content: center;width: 600px">
    <tbody>
    <tr><td><a href="/admin/adminLogin">登录</a></td>
        <td><a href="/admin/newShop">新建商店</a></td>
        <td><a href="/admin/addActivity">新建活动</a></td>
        <td><a href="/admin/listShop/1">商店列表</a></td>
    </tr>

    </tbody>

</table>

活动管理
<table class="table table-striped" style="align-content: center;width: 600px">
    <tbody>
    <tr><td><a href="/activity/page/add"><strong>添加</strong></a></td><td><a href="/activity/page/edit"><strong>修改</strong></a></td></tr>
    <tr><td><a href="/activity/page/delete"><strong>删除</strong></a></td></tr>
    <tr><td><a href="/activity/list/1"><strong>活动列表</strong></a></td><td><a href="/activity/list/totalPage"><strong>总页码</strong></a></td></tr>
    <tr><td><a href="/activity/1/shops"><strong>活动药店列表</strong></a></td><td><a href="/activity/1/items"><strong>活动商品列表</strong></a></td></tr>
    <tr><td><a href="/activity/page/shop/add"><strong>添加关联药店</strong></a></td><td><a href="/activity/page/item/add"><strong>添加关联商品</strong></a></td></tr>
    </tbody>
</table>


资讯管理
<table class="table table-striped" style="align-content: center;width: 600px">
    <tbody>
    <tr><td><a href="/news/page/add"><strong>添加</strong></a></td><td><a href="/news/page/edit"><strong>修改</strong></a></td></tr>
    <tr><td><a href="/news/page/delete"><strong>删除</strong></a></td></tr>
    <tr><td><a href="/news/list/1"><strong>资讯列表</strong></a></td><td><a href="/news/list/totalPage"><strong>总页码</strong></a></td></tr>
    </tbody>
</table>


<script src="/js/jquery-2.2.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
