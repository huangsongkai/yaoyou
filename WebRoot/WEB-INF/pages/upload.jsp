<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 16/8/19
  Time: 下午2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>avatar</title>
    <script src="/js/jquery-2.2.1.min.js"></script>
</head>
<body>
<input type="file" name="file" id="fileLoader"/>
<input type="button" id="fileSubmit" value="Upload"/>
<script>
    var files = [];
    $(document)
            .on(
            "change",
            "#fileLoader",
            function (event) {
                files = event.target.files;
            })

    $(document)
            .on(
            "click",
            "#fileSubmit",
            function () {
                processUpload();
            })

    function processUpload() {
        var oMyForm = new FormData();
        oMyForm.append("file", files[0]);
        console.log(files[0]);
        $.ajax({
            dataType: 'json',
            url: "/upload/file",
            data: oMyForm,
            type: "POST",
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            success: function (result) {
                console.log(result);
                //...;
            },
            error: function (result) {
                //...;
            }
        });
    }
</script>


</body>
</html>
