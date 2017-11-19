<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <style type="text/css">
        strong{color:darkred}
    </style>
</head>
<html>
<body>
	<h1>${message}</h1><br>
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/shop/id/500dba0a-64a0-47b4-a5a8-c3e77b0eacb3">shop search by ID</a></td>
            <td><a href="/medicine/id/c71ab3bf-a2d0-44cf-87dd-befe06f728af">medicine search by ID</a></td></tr>

        <tr><td><a href="/shop/name/test">shop名称搜索</a></td>
            <td><a href="/medicine/name/测试">medicine名称搜索</a></td></tr>

        <tr><td><a href="/shop/list"><strong>shop list 带活动id</strong></a></td>
            <td><a href="/medicine/list">medicine list</a></td></tr>

        <tr><td><a href="/shop/list/1">分页 #1</a></td>
            <td><a href="/medicine/list/1">分页 #1</a></td></tr>

        <tr><td><a href="/shop/list/total">总页数</a></td>
            <td><a href="/medicine/list/total">总页数</a></td></tr>
        <tr><td><a href="/shop/list/gps"><strong>松北区政府的附近药店列表</strong></a></td>
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
        <tr><td><a href="/user/search/userName/balala"><strong>搜索用户名</strong></a></td>
            <td><a href="/user/search/mobile/13000000000"><strong>搜索手机号</strong></a></td></tr>
        </tbody>
        <tr><td><a href="/user/upload/avatar"><strong>上传头像</strong></a></td></tr>
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


    综合搜索
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/search/keyword/搜索/page/1"><strong>搜索(keyword:搜索) 第一页</strong></a></td>
        </tr>
        <tr><td><a href="/search/keyword/搜索/totalPage"><strong>总页码数</strong></a></td>
        </tr>
        </tbody>
    </table>

    单体Item 联合商品、药品、活动表 itemDTO
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/item/add">add</a></td><td><a href="/item/delete">delete</a></td>
           </tr>
        <tr><td><a href="/item/18"><strong>商品编号18 json</strong></a></td>
            <td><a href="/item/page/18">#18 view page</a></td></tr>
        <tr><td><a href="/item/list"><strong>列表</strong></a></td>
            <td><a href="/item/list/1">分页 #1</a></td></tr>
        <tr><td><a href="/item/list/total">总页码</a></td>
            <td></td></tr>
        <tr><td><a href="/item/search/medicine/a9c60f29-49ff-45fe-9761-4accdc2fd29d"><strong>根据药品ID搜索</strong></a></td>
            </tr>
        <tr><td><a href="/item/search/medicine/a9c60f29-49ff-45fe-9761-4accdc2fd29d/1"><strong>药品ID分页</strong></a></td><td><a href="/item/search/medicine/a9c60f29-49ff-45fe-9761-4accdc2fd29d/totalPage"><strong>总页码</strong></a></td>
        </tr>
        <tr>
            <td><a href="/item/search/shop/500dba0a-64a0-47b4-a5a8-c3e77b0eacb3"><strong>根据药店ID搜索</strong></a></td></tr>
        <tr>
            <td><a href="/item/search/shop/500dba0a-64a0-47b4-a5a8-c3e77b0eacb3/1"><strong>药店ID分页</strong></a></td><td><a href="/item/search/shop/500dba0a-64a0-47b4-a5a8-c3e77b0eacb3/totalPage"><strong>总页码</strong></a></td></tr>
        </tbody>
    </table>

    Cart <font color="red">返回结果有变动 包含活动价格和活动积分</font>
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/cart/items/18-19-20"><strong>返回购物车内容(18,19,20)</strong></a></td>
        </tr>
        <%--<tr><td><a href="/cart">my cart (json)</a></td>
            <td></td></tr>
        <tr><td><a href="/cart/add">add</a></td>
            <td><a href="/cart/edit">view & edit</a></td></tr>--%>
        </tbody>
    </table>

    Order
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/order/submit/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98/items/18:2-19:1/addressId/0">app提交订单（同时支持GET，POST，GET为了测试）</a></td></tr>
        <tr><td><a href="/order/list/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98/1">订单列表 页码1</a></td><td><a href="/order/items/62"><strong>订单items</strong></td></tr>
        <tr><td><a href="/order/list/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98/totalPage">总页码</a></td></tr>
        </tbody>
    </table>

    提醒
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/remind/page/add"><strong>添加页面、接口说明</strong></a></td></tr>
        <tr><td><a href="/remind/page/edit"><strong>修改</strong></a></td>
            <td><a href="/remind/page/delete"><strong>删除</strong></a></td></tr>

        <tr><td><a href="/remind/list/from/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98"><strong>我给别人设置的闹钟</strong></a></td>
            <td><a href="/remind/list/to/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98"><strong>我的提醒列表</strong></a></td></tr>
        </tbody>
    </table>

    服药记录
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/remind/record/list/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98/1"><strong>第一页</strong></a></td>
            <td><a href="/remind/record/list/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98/totalPage"><strong>总页数</strong></a></td></tr>
        </tbody>
    </table>

    亲友功能
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/friend/apply/17b87b02-5b04-401f-95fc-fe71e3e2f94a/byId/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98"><strong>通过id互加好友</strong></a></td>
            <td><a href="/friend/apply/17b87b02-5b04-401f-95fc-fe71e3e2f94a/byMobile/13000000000"><strong>通过手机互加好友</strong></a></td></tr>
        <tr><td><a href="/friend/apply/17b87b02-5b04-401f-95fc-fe71e3e2f94a/byName/balala"><strong>通过用户名互加好友</strong></a></td>
            <td><a href="/friend/list/17b87b02-5b04-401f-95fc-fe71e3e2f94a"><strong>好友列表</strong></a></td></tr>
        <tr><td><a href="/friend/page/delete"><strong>删除好友</strong></a></td></tr>
        </tbody>
    </table>

    地址管理
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td><a href="/address/page/add">添加</a></td><td><a href="/address/page/edit">修改</a></td></tr>
        <tr><td><a href="/address/page/delete">删除</a></td><td><a href="/address/list/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98">列表</a></td></tr>
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