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
<div id="itemList">
</div>
<script src="/js/jquery-2.2.1.min.js"></script>
<script src="/js/underscore-min.js"></script>

<script type="text/template" id="item_template">
    <table class="table table-striped" style="align-content: center;width: 600px">
        <tbody>
        <tr><td>itemId</td><td><@=itemId@></td></tr>
        <tr><td>count</td><td><@=count@></td></tr>
        </tbody>
    </table>
</script>

ADD_ID：<input type="text" class="submit_form" name="addId" value="1"/>
<input type="button" class="submit_button btn btn-primary" url="/order/submit" method="post" value="确认订单"/>

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
    $("#itemList").html(html);
    $(".submit_button").click(function(){
        var submitType = $(this).attr('method')||"get";
        var submitForm = {};
        submitForm['addId'] = $($('.submit_form')[0]).val();
        $.ajax({
            type: submitType,
            url: $(this).attr('url'),
            data: JSON.stringify(submitForm),
            dataType: 'json',
            contentType : 'application/json',
            success: function(data){
                var msg;
                console.log(data.msg);
                if(data.status == 1)
                    msg = data.message || "操作成功";
                else
                    msg = data.message || "操作失败";
                alert(msg);
            },
            error: function(data){
                console.log("-------" + data);
                alert("操作失败");
            }
        });

    });

</script>

</body>
</html>


