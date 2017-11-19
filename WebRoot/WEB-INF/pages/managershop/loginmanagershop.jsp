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
    <script>
        var table_init ={
            userName:'老百姓大药房',
            password:'admin'
        };
    </script>
    <table class="table table-striped submit_form" style="align-content: center;width: 600px">
        <thead><tr><td><input type="button" class="submit_button btn btn-primary" url="/managerShop/loginManagerShop" method="post" callback=window.redirect value="登录"/></td></tr></thead>
        <tbody>
        </tbody>
    </table>

    <a href="/">Home Page</a>
    <script src="/js/jquery-2.2.1.min.js"></script>
    <script src="/js/common.js"></script>
    <script>
        redirect = function(data){
            console.log(data.data);
            if(data.status == 1){
                msg = "登录成功";
                alert(msg);
//                var returnUrl = getQueryString("return");
//                if(returnUrl)
//                    window.location = getQueryString("return");
//                else
                    window.location = "/managerShop/managerShop";
            }
            else{
                msg = data.message || "操作失败";
                alert(msg);
            }

        }
    </script>
</body>
</html>


