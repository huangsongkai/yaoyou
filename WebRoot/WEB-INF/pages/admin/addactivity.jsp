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
            title:'活动名称',
            body:'具体内容 字数2000',
            type:'优惠',
            imgUrl:'',
            begTime:'2016-08-08 00:00:00',
            endTime:'2016-09-09 00:00:00',
            state:'待定'
        };

    </script>
    <table class="table table-striped submit_form" style="align-content: center;width: 600px">
        <thead><tr><td><input type="button" class="submit_button btn btn-primary" url="/admin/saveActivity" method="post" value="提交"/></td></tr></thead>
        <tbody>
        </tbody>
    </table>
    选择活动图片<input type="file" name="file" id="fileLoader"/>
    <input type="button" id="fileSubmit" value="Upload"/>
    <script src="/js/jquery-2.2.1.min.js"></script>
    <script src="/js/common.js"></script>
    <script src="/js/upload.js"></script>
</body>
</html>


