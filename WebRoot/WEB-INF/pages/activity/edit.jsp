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
<table class="table table-striped submit_form" style="align-content: center;width: 600px">
    <thead><tr><td><input type="button" class="submit_button btn btn-primary" url="/activity" method="put" value="提交"/></td></tr></thead>
    <tbody>
    </tbody>
</table>
url: /activity
method：put<br>
var obj = {"activityId":1, "title":"活动名称_update","type":"优惠","body":"具体内容 字数2000","imgUrl":"","begTime":"2016-08-08 00:00:00","endTime":"2016-09-09 00:00:00","state":"待定"};
<script src="/js/jquery-2.2.1.min.js"></script>
<script>

    $('.submit_button').on('click', function(){
        var obj = {"activityId":1,"title":"活动名称_update","type":"优惠","body":"具体内容 字数2000","imgUrl":"","begTime":"2016-08-08 00:00:00","endTime":"2016-09-09 00:00:00","state":"待定"};
        $.ajax({
            type: 'PUT',
            url: $(this).attr('url'),
            data: JSON.stringify(obj),
            dataType: 'json',
            contentType : 'application/json',
            success: function(data){
                alert("修改成功")
                console.log(data);
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


