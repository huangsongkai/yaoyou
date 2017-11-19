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

</div>
<script src="/js/jquery-2.2.1.min.js"></script>
<script src="/js/underscore-min.js"></script>
<table class="table table-bordered">
    <thead>
         <tr>
            <td>orderId</td>
            <th>state</th>
            <th>userId</th>
            <th>totalPrice</th>
            <th>payId</th>
            <th>addId</th>
            <th>distributionId</th>
            <td>createTime</td>
        </tr>
    </thead>
    <tbody >
    </tbody>
</table>
<script type="text/template" id="item_template">
        <tr>
            <td><@=orderId@></td>
            <td><@=state@></td>
            <td><@=userId@></td>
            <td><@=totalPrice@></td>
            <td><@=addId@></td>
            <%--<td><@=distributionId@></td>--%>
            <td><@=createTime@></td>
        </tr>
</script>
<script>
    _.templateSettings = {
        evaluate: /<@([\s\S]+?)@>/g,
        interpolate: /<@=([\s\S]+?)@>/g,
        escape: /<@-([\s\S]+?)@>/g
    };

    var orderList = ${orderList};
    console.log("---------"+orderList);
    var html = "";
    var templ = _.template($('#item_template').html());
    $.each(orderList, function(index,item){
        html += templ(item);
    });
    $($("tbody")[0]).html(html);
//    $(".submit_button").click(function(){
//        var submitType = $(this).attr('method')||"get";
//        var submitForm = {};
//        submitForm['addId'] = $($('.submit_form')[0]).val();
//        $.ajax({
//            type: submitType,
//            url: $(this).attr('url'),
//            data: JSON.stringify(submitForm),
//            dataType: 'json',
//            contentType : 'application/json',
//            success: function(data){
//                var msg;
//                console.log(data.msg);
//                if(data.status == 1)
//                    msg = data.message || "操作成功";
//                else
//                    msg = data.message || "操作失败";
//                alert(msg);
//            },
//            error: function(data){
//                console.log("-------" + data);
//                alert("操作失败");
//            }
//        });
//
//    });

</script>

</body>
</html>


