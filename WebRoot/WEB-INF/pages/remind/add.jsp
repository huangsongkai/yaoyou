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
        <thead><tr><td><input type="button" class="submit_button btn btn-primary" url="/remind" method="post" value="提交"/></td></tr></thead>
        <tbody>
        </tbody>
    </table>
    <script src="/js/jquery-2.2.1.min.js"></script>
    url: /remind
    method:post<br>
    var obj = {"medicineName":"空","description":"看看","timeTableList":[{"state":true,"mm":"00","hh":"00"},{"state":true,"mm":"00","hh":"00"},{"state":true,"mm":"00","hh":"00"}],"creator":"ff6342f4-095b-4bc0-86b2-f4c9a8eaec98","userId":"ff6342f4-095b-4bc0-86b2-f4c9a8eaec98"};

    <script>
        $('.submit_button').on('click', function(){
//            var obj = {"userId":"ff6342f4-095b-4bc0-86b2-f4c9a8eaec98","creator":"17b87b02-5b04-401f-95fc-fe71e3e2f94a","medicineName":"倍他乐克","description":"按时吃药","timeTableList":[{"hh":"09","mm":"30","state":true},{"hh":"09","mm":"31","state":true},{"hh":"09","mm":"32","state":true}]};
            var obj = {"medicineName":"空","description":"看看","timeTableList":[{"state":true,"mm":"00","hh":"00"},{"state":true,"mm":"00","hh":"00"},{"state":true,"mm":"00","hh":"00"}],"creator":"ff6342f4-095b-4bc0-86b2-f4c9a8eaec98","userId":"ff6342f4-095b-4bc0-86b2-f4c9a8eaec98"};
            $.ajax({
                type: 'POST',
                url: $(this).attr('url'),
                data: JSON.stringify(obj),
                dataType: 'json',
                contentType : 'application/json',
                success: function(data){
                    console.log(data);
                    alert(data.message);
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


