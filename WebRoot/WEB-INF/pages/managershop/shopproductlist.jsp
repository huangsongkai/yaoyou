<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<script src="/js/jquery-2.2.1.min.js"></script>
<script src="/js/underscore-min.js"></script>
<form action="/managerShop/productManager/1" method="post" >
    <input type="text" name="productName" id="productName" value="${productName}"/><input type="submit"  class="redirect_button btn btn-primary" value="搜索"/>
</form>

<table class="table table-bordered">
        <thead>
        <tr>
            <td>medicineId</td>
            <td>cadn</td>
            <td>brandName</td>
            <td>cadnCode</td>
            <td>specification</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody >
        </tbody>
    </table>
    <nav>

        <ul class="pager">
            <li><a href="/managerShop/managerShop">回到主界面</a></li>
            <li><a href="/managerShop/productManager/1/" method="post">首页</a></li>
            <li><a href="javascript:upPage()">上一页 </a></li>
            <li><a href="javascript:nextPage()">下一页 </a></li>
            <li style="color: #761c19"> 共${totalPage}页</li>
        </ul>
    </nav>
    <%--<input type="button" class="redirect_button btn btn-primary" url="/order/confirm" method="post" value="去结算"/>--%>


    <script type="text/template" id="item_template">
                <tr>
                    <td><@=medicineId@></td>
                    <td><@=cadn@></td>
                    <td><@=brandName@></td>
                    <td><@=cadnCode@></td>
                    <td><@=specification@></td>
                    <td><input type="button" id="DaoRu" class="redirect_button btn btn-primary impBtn" url="/order/confirm" method="post" value="导入药品"/></td>
                </tr>
    </script>


    <script>
        function nextPage(){
            window.location ="/managerShop/productManager/${pageNum+1}?productName="+encodeURIComponent(encodeURIComponent("${productName}"));
        }

        function upPage(){
            window.location ="/managerShop/productManager/${pageNum-1}?productName="+encodeURIComponent(encodeURIComponent("${productName}"));
        }
        _.templateSettings = {
            evaluate: /<@([\s\S]+?)@>/g,
            interpolate: /<@=([\s\S]+?)@>/g,
            escape: /<@-([\s\S]+?)@>/g
        };
        var defaultProductList = {"medicineId":" ","cadn":" ","brandName":" ","cadnCode":" ","specification":" ","boxing":" ","unit":" ","formulations":" ","sellPrice":0,"imgUrl":" ","createUserName":" ","createTime":" ","createUserId":"1","avgRate":0,"formulationsPinyinCode":" ","otcLogo":" ","approvalNumber":" ","seq":0};
        var medicineInfoList = ${medicineInfoList};
        var html = "";
        var templ = _.template($('#item_template').html());
        $.each(medicineInfoList, function(index,item){
            item = $.extend({},defaultProductList,item);
            html += templ(item);
        });
        console.log(html);
        $($("tbody")[0]).html(html);

        $(document).on("click",".impBtn",function(e){
            console.log(e.target)
            var fireAlarmStatus=$($(e.target).closest("tr").find("td")[0]).text();
            console.log(fireAlarmStatus);
            var data={};
            data["medicineId"] = fireAlarmStatus
            $.ajax({
                type: "POST",
                url: "/managerShop/saveProductManager?pageNum="+${pageNum},
                dataType: 'json',
                contentType: "application/json",
                data: JSON.stringify(data)  ,
                success: function(){
                    alert("导入成功");
                    location.reload()
                    //window.location.reload()
                },
                error: function(data){
                    console.log(data);
                    alert("导入失败");
                }
            })
        }) ;
    </script>
</body>

</html>


