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
//            userId:'ff6342f4-095b-4bc0-86b2-f4c9a8eaec98',
            itemId:18,
            count:1
        };
        var redirectToCartEdit = function(){
            window.location = "/cart/edit";
        }
    </script>
    已经存在的商品，商品数量会叠加
    <table class="table table-striped submit_form" style="align-content: center;width: 600px">
        <thead><tr><td><input type="button" class="submit_button btn btn-primary" url="/cart" method="post" callback=window.redirectToCartEdit value="提交"/></td></tr></thead>
        <tbody>
        </tbody>
    </table>
    <script src="/js/jquery-2.2.1.min.js"></script>
    <script src="/js/common.js"></script>

</body>
</html>


