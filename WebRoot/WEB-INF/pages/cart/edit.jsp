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

    数量为0表示删除
    <input type="button" class="submit_button btn btn-primary" url="/cart/edit" method="put" value="修改"/>
    <div id="itemList">
    </div>
    <input type="button" class="redirect_button btn btn-primary" url="/order/confirm" method="post" value="去结算"/>
    <script src="/js/jquery-2.2.1.min.js"></script>
    <script src="/js/underscore-min.js"></script>

    <script type="text/template" id="item_template">
        <table class="table table-striped submit_form" style="align-content: center;width: 600px">
            <tbody>
                <tr><td>itemId</td><td><input type='text' name='itemId' value="<@=itemId@>"/></td><%--<td><input type="checkbox"></td>--%></tr>
                <tr><td>count</td><td><input type='text' name='count' value="<@=count@>"/></td></tr>
                <tr><td>medicineName</td><td><input type='text' name='medicineName' value="<@=medicineName@>"/></td></tr>
                <tr><td>price</td><td><input type='text' name='price' value="<@=price@>"/></td></tr>
                <tr><td>shopName</td><td><input type='text' name='shopName' value="<@=shopName@>"/></td></tr>
            </tbody>
        </table>
    </script>


    <script>
        _.templateSettings = {
            evaluate: /<@([\s\S]+?)@>/g,
            interpolate: /<@=([\s\S]+?)@>/g,
            escape: /<@-([\s\S]+?)@>/g
        };

        var cartList = ${cartDTOList};
        var html = "";
        var templ = _.template($('#item_template').html());
        $.each(cartList, function(index,item){
            html += templ(item);
        });
        console.log(html);
        $("#itemList").html(html);
        $(".redirect_button").click(function(){
//            var submitList = [];
//            $(".submit_form").each(function(index, item){
//                var submitForm = {};
//                $(item).find(':text').each(function(index, item){
//                    submitForm[$(this).attr('name')] = $(this).val();
//                });
//                submitList.push(submitForm);
//            });
//            asyncSubmit(submitType, submitList);
            window.location = '/order/confirm';
        });
        $(".submit_button").click(function(){
            var submitList = [];
            $(".submit_form").each(function(index, item){
                var submitForm = {};
                $(item).find(':text').each(function(index, item){
                    submitForm[$(this).attr('name')] = $(this).val();
                });
                submitList.push(submitForm);
            });
            var url = $(this).attr('url');
            var submitType = $(this).attr('method')||"get";
            asyncSubmit(submitType, submitList, url);
        });

        asyncSubmit = function(submitType, submitList, url){
            $.ajax({
                type: submitType,
                url: url,
                data: JSON.stringify(submitList),
                dataType: 'json',
                contentType : 'application/json',
                success: function(){
                    alert("修改成功");
                    window.location.reload()
                },
                error: function(data){
                    console.log("-------" + data);
                    alert("操作失败");
                }
            });
        }

    </script>

</body>
</html>


