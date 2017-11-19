<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <meta charset="utf-8"/>
    <script language="JavaScript">




         console.log("-------" + orderList);



        _.templateSettings = {
            evaluate: /<@([\s\S]+?)@>/g,
            interpolate: /<@=([\s\S]+?)@>/g,
            escape: /<@-([\s\S]+?)@>/g
        };
        var orderList = ${orderList};         
        var html = "";
        var templ = _.template($('#item_template').html());
        $.each(orderList, function(index,item){
            html += templ(item);
        });
         console.log("-------" + html);
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
        console.log("-------" + cartList);
    </script>

</head>
<body>
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <td>#</td>
                                        <th>姓名</th>
                                        <th>手机</th>
                                        <th>会员类型</th>
                                        <th>会员卡</th>
                                        <th>注册日期</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        ${orderList}
                                    </tr>
                                    </tbody>
                                </table>
</body>
</html>