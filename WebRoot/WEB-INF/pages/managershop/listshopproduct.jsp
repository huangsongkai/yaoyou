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
<form action="/managerShop/listShopProduct/1" method="post" >
    <input type="text" name="productName" id="productName" value="${productName}"/><input type="submit"  class="redirect_button btn btn-primary" value="搜索"/>
</form>
<table class="table table-bordered">
        <thead>
        <tr>
            <td>itemId</td>
            <td>cadn</td>
            <td>brandName</td>
            <td>price</td>
            <td>state</td>
            <td>storageCount</td>
            <td>description</td>
            <td>shopInfoId</td>
            <td>medicineId</td>
            <td>createTime</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody >
        </tbody>
    </table>
    <nav>
        <ul class="pager">
            <ul class="pager">
                <li><a href="/managerShop/managerShop">回到主界面</a></li>
                <li><a href="/managerShop/listShopProduct/1/" method="post">首页</a></li>
                <li><a href="javascript:upPage()">上一页 </a></li>
                <li><a href="javascript:nextPage()">下一页 </a></li>
                <li style="color: #761c19"> 共${totalPage}页</li>
            </ul>
        </ul>
    </nav>
    <%--<input type="button" class="redirect_button btn btn-primary" url="/order/confirm" method="post" value="去结算"/>--%>


    <script type="text/template" id="item_template">
                <tr>
                    <td><@=itemId@></td>
                    <td><@=cadn@></td>
                    <td><@=brandName@></td>
                    <td><@=price@></td>
                    <td><@=state@></td>
                    <td><@=storageCount@></td>
                    <td><@=description@></td>
                    <td><@=shopInfoId@></td>
                    <td><@=medicineId@></td>
                    <td><@=createTime@></td>
                    <td>
                        <input type="button" class="redirect_button btn btn-primary deleteBtn"         method="post" value="删除"/>
                        <input type="button" url=""  class="redirect_button btn btn-primary editBtn"  method="post" value="上架"/>
                    </td>
                </tr>
    </script>


    <script>
        function nextPage(){
            window.location ="/managerShop/listShopProduct/${pageNum+1}?productName="+encodeURIComponent(encodeURIComponent("${productName}"));
        }

        function upPage(){
            window.location ="/managerShop/listShopProduct/${pageNum-1}?productName="+encodeURIComponent(encodeURIComponent("${productName}"));
        }

        _.templateSettings = {
            evaluate: /<@([\s\S]+?)@>/g,
            interpolate: /<@=([\s\S]+?)@>/g,
            escape: /<@-([\s\S]+?)@>/g
        };
        var defaultItem = {"itemId":0,"storageCount":0,"price":0.00,"point":0,"medicineId":" ","cadn":" ","brandName":" ","shopInfoId":" ","shopName":" ","shopAddress":" ","shopTel":" ","state":1,"description":" ","createTime":" "};
        var item = ${itemList};
        var html = "";
        var templ = _.template($('#item_template').html());
        $.each(item, function(index,item){
            item = $.extend({},defaultItem,item);
            html += templ(item);

        });
        console.log(html);
        $($("tbody")[0]).html(html);
        $(document).on("click",".deleteBtn",function(e){
            console.log(e.target)
            // $("#ShanChu").click(function(){
            var fireAlarmStatus=$($(e.target).closest("tr").find("td")[0]).text();
            var data={};
            alert("删除方法")
            data["itemId"] = fireAlarmStatus;
            $.ajax({
                type: "POST",
                url: "/managerShop/deleteProduct",
                dataType: 'json',
                contentType: "application/json",
                data: JSON.stringify(data)  ,
                success: function(){
                    alert("删除成功");
                    location.reload()
                    //window.location.reload()
                },
                error: function(data){
                    console.log(data);
                    alert("删除失败");
                    location.reload()
                }
            })
        }) ;


        $(document).on("click",".editBtn",function(e){
            var itemId=$($(e.target).closest("tr").find("td")[0]).text();
            window.location = "/managerShop/editProduct?itemId="+itemId;
        });
    </script>
</body>

</html>


