<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<br>
<script src="/js/jquery-2.2.1.min.js"></script>
<script src="/js/underscore-min.js"></script>
<form action="/managerShop/productManager/1" method="GET" >
</form>
<form action="/admin/listShop/1" method="post" >
    <input type="text" name="shopName" id="shopName" value="${shopName}"/><input type="submit"  class="redirect_button btn btn-primary" value="搜索"/>
</form>
<table class="table table-bordered">
        <thead>
        <tr>
            <td>shopName</td>
            <td>createTime</td>
            <td>seq</td>
            <td>shopAddress</td>
            <td>shopTel</td>
            <td>isSend</td>
            <td>imgUrl</td>
            <td>state</td>
        </tr>
        </thead>
        <tbody >
        </tbody>
    </table>
    <nav>
        <ul class="pager">
            <ul class="pager">
                <li><a href="/admin">回到主界面</a></li>
                <li><a href="/managerShop/shopInfoList/1/" method="post">首页</a></li>
                <li><a href="javascript:upPage()">上一页 </a></li>
                <li><a href="javascript:nextPage()">下一页 </a></li>
                <li style="color: #761c19"> 共${totalPage}页</li>
            </ul>
        </ul>
    </nav>
    <%--<input type="button" class="redirect_button btn btn-primary" url="/order/confirm" method="post" value="去结算"/>--%>


    <script type="text/template" id="item_template">
                <tr>
                    <td><@=shopName@></td>
                    <td><@=createTime@></td>
                    <td><@=seq@></td>
                    <td><@=shopAddress@></td>
                    <td><@=shopTel@></td>
                    <td><@=isSend@></td>
                    <td><@=imgUrl@></td>
                    <td><@=state@></td>
                </tr>
    </script>


    <script>
        function nextPage(){
            window.location ="/admin/listShop/${pageNum+1}?productName="+encodeURIComponent(encodeURIComponent("${shopName}"));
        }

        function upPage(){
            window.location ="/admin/listShop/${pageNum-1}?productName="+encodeURIComponent(encodeURIComponent("${shopName}"));
        }

        _.templateSettings = {
            evaluate: /<@([\s\S]+?)@>/g,
            interpolate: /<@=([\s\S]+?)@>/g,
            escape: /<@-([\s\S]+?)@>/g
        };
        var defaultItem = {"shopInfoId":"","isSend":"","shopName":"","seq":0,"shopAddress":"","shopTel":"","imgUrl":"","gpsX":0,"gpsY":0,"state":"","createUserName":"","createTime":"","createUserId":"","avgRate":0};
        var item = ${shopInfoList};
        var html = "";
        var templ = _.template($('#item_template').html());
        $.each(item, function(index,item){
            item = $.extend({},defaultItem,item);
            html += templ(item);

        });
        console.log(html);
        $($("tbody")[0]).html(html);
    </script>
</body>

</html>


