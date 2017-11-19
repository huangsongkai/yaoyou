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
    <thead><tr><td><input type="button" class="submit_button btn btn-primary" url="/address" method="put" value="提交"/></td></tr></thead>
    <tbody>
    </tbody>
</table>
url: /address
method：put<br>
var obj = {"addressId":1,"userId":"ff6342f4-095b-4bc0-86b2-f4c9a8eaec98","name":"张振","province":"黑龙江省","city":"哈尔滨市","county":"南岗区","detail":"详细地址_update","mobile":"13012345678","email":"test@qq.com","isDefault":"1","tag":"公司地址"};
<script src="/js/jquery-2.2.1.min.js"></script>
<script>

    $('.submit_button').on('click', function(){
        var obj = {"addressId":1,"userId":"ff6342f4-095b-4bc0-86b2-f4c9a8eaec98","name":"张振","province":"黑龙江省","city":"哈尔滨市","county":"南岗区","detail":"详细地址_update","mobile":"13012345678","email":"test@qq.com","isDefault":"1","tag":"公司地址"};
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


