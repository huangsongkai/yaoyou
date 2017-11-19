<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<script src="/js/jquery-2.2.1.min.js"></script>
<script src="/js/underscore-min.js"></script>
<form action="/managerShop/listOrder/1" method="POST" >
    <select name="payState" id="payState">
        <option VALUE="0">请选择</option>
        <option VALUE="1">已支付</option>
        <option VALUE="2">未支付</option>
    </select>
    <input type="submit"  class="redirect_button btn btn-primary" value="搜索"/>
</form>
<table class="table table-bordered">
        <thead>
        <tr>
            <td>orderId</td>
            <td>state</td>
            <td>type</td>
            <td>userId</td>
            <td>totalPrice</td>
            <td>payId</td>
            <td>addId</td>
            <td>distributionId</td>
            <td>createTime</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody >
        </tbody>
    </table>
    <nav>
        <ul class="pager">
            <li><a href="/managerShop/managerShop">回到主界面</a></li>
            <li><a href="/managerShop/listOrder/1">首页</a></li>
            <li><a href="/managerShop/listOrder/${pageNum+1}">下一页 </a></li>
        </ul>
    </nav>
    <%--<input type="button" class="redirect_button btn btn-primary" url="/order/confirm" method="post" value="去结算"/>--%>


    <script type="text/template" id="item_template">
                <tr>
                    <td><@=orderId@></td>
                    <td><@=state@></td>
                    <td><@=type@></td>
                    <td><@=userId@></td>
                    <td><@=totalPrice@></td>
                    <td><@=payId@></td>
                    <td><@=addId@></td>
                    <td><@=distributionId@></td>
                    <td><@=createTime@></td>
                    <td><input type="button" id="DaoRu" class="redirect_button btn btn-primary"  method="post" value="发货"/></td>
                </tr>
    </script>


    <script>

        _.templateSettings = {
            evaluate: /<@([\s\S]+?)@>/g,
            interpolate: /<@=([\s\S]+?)@>/g,
            escape: /<@-([\s\S]+?)@>/g
        };

        var orderList = ${orderList};
        var defaultOrder = {"orderId":0,"userId": "","createTime":"","type":"","totalPrice":0.0,"addId":0,"distributionId":0,"state":"","payId":""};
        var html = "";
        var templ = _.template($('#item_template').html());
        $.each(orderList, function(index,item){
            item = $.extend({},defaultOrder,item);
            html += templ(item);

        });
        console.log(html);
        $($("tbody")[0]).html(html);

        $("#DaoRu").click(function(){
             alert("发货成功");
            })


    </script>
</body>

</html>


