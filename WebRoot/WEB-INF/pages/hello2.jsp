<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<html>
<body>
	<h1>${message}</h1><br>
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/shop/id/500dba0a-64a0-47b4-a5a8-c3e77b0eacb3">shop search by ID</a></td>
            <td><a href="/medicine/id/c71ab3bf-a2d0-44cf-87dd-befe06f728af">medicine search by ID</a></td></tr>

        <tr><td><a href="/shop/name/test">shop名称搜索</a></td>
            <td><a href="/medicine/name/medicine">medicine名称搜索</a></td></tr>

        <tr><td><a href="/shop/list">shop list</a></td>
            <td><a href="/medicine/list">medicine list</a></td></tr>

        <tr><td><a href="/shop/list/1">分页 #1</a></td>
            <td><a href="/medicine/list/1">分页 #1</a></td></tr>

        <tr><td><a href="/shop/list/total">总页数</a></td>
            <td><a href="/medicine/list/total">总页数</a></td></tr>
        <tr><td><a href="/shop/list/gps">距离默认值（0，0）的排序</a></td>
            <td></td></tr>
        <tr><td><a href="/shop/list/gps/2-2">距离(2,2)</a></td>
            <td></td></tr>

        <tr><td><a href="/shop/add">shop add</a></td>
            <td><a href="/medicine/add">medicine add</a></td></tr>
        <tr><td><a href="/shop/delete">shop delete</a></td>
            <td><a href="/medicine/delete">medicine delete</a></td></tr>

        </tbody>
    </table>

    User
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/user/register">Register</a></td>
            <td></td></tr>
        <tr><td><a href="/user/login">Login</a></td>
            <td><a href="/user/logout">Logout</a></td></tr>
        <tr><td><a href="/user/check/userName">Check UserName</a></td>
            <td><a href="/user/check/mobile">Check Mobile</a></td></tr>
        </tbody>
    </table>


    Comments
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/shop/comment/add">shop comment add</a></td>
            <td><a href="/medicine/comment/add">medicine comment add</a></td></tr>
        <tr><td><a href="/shop/id/500dba0a-64a0-47b4-a5a8-c3e77b0eacb3/comment/list/1">Id >> list page</a></td>
            <td><a href="/medicine/id/c71ab3bf-a2d0-44cf-87dd-befe06f728af/comment/list/1">Id >> list page</a></td></tr>
        <tr><td><a href="/shop/id/500dba0a-64a0-47b4-a5a8-c3e77b0eacb3/comment/list/total">Id >> totalPage</a></td>
            <td><a href="/medicine/id/c71ab3bf-a2d0-44cf-87dd-befe06f728af/comment/list/total">Id >> totalPage</a></td></tr>
        </tbody>
    </table>

    单体Item
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/cart/items/18-19-20">返回某人购物车内容(18,19,20)</a></td>
           </tr>
        <tr><td><a href="/item/add">add</a></td><td><a href="/item/delete">delete</a></td>
           </tr>
        <tr><td><a href="/item/18">#18 json</a></td>
            <td><a href="/item/page/18">#18 view page</a></td></tr>
        <tr><td><a href="/item/list">列表</a></td>
            <td><a href="/item/list/1">分页 #1</a></td></tr>
        <tr><td><a href="/item/list/total">总页码</a></td>
            <td></td></tr>
        <tr><td><a href="/item/search/medicine/a9c60f29-49ff-45fe-9761-4accdc2fd29d">根据药品ID搜索</a></td>
            <td><a href="/item/search/shop/500dba0a-64a0-47b4-a5a8-c3e77b0eacb3">根据药店ID搜索</a></td></tr>
        </tbody>
    </table>

    Cart:需要登录以后访问
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/cart">my cart (json)</a></td>
            <td></td></tr>
        <tr><td><a href="/cart/add">add</a></td>
            <td><a href="/cart/edit">view & edit</a></td></tr>
        </tbody>
    </table>

    Order:需要登录以后访问
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/order/submit/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98/items/18:2-19:1/addressId/0">app提交订单（同时支持GET，POST，GET为了测试）</a></td>/tr>
        <tr><td><a href="/order/submit/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98/items/18:2-19:1/addressId/0">app提交订单（同时支持GET，POST，GET为了测试）</a></td>/tr>
        </tbody>
    </table>




    <script src="/js/jquery-2.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>

</body>
</html>