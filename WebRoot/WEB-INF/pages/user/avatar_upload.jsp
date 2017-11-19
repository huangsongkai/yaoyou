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
</head>
<body>
上传地址/upload/file 提交见源码，用到了FormData<br>
userId:<input type="text" name="userId" value="ff6342f4-095b-4bc0-86b2-f4c9a8eaec98"/><br>
img:<input type="text" name="img" readonly/><br>
<input type="file" name="file" id="fileLoader"/>
<input type="button" id="fileSubmit" value="Upload"/>
<input type="button" id="save" value="保存"/><br>
<img src="">
<script src="/js/jquery-2.2.1.min.js"></script>
<script>
    var uploadedFileName;
    var files = [];
    $('body').on("change","#fileLoader", function (event) {
        files = event.target.files;
    });

    $('body').on("click", "#fileSubmit", function () {
        processUpload();
    });
    $('body').on("click", "#save", function () {
        var user = {};
        user['userId'] = $("input[name='userId']").val();
        user['img'] = $("input[name='img']").val();
        $.ajax({
            dataType: 'json',
            url: "/user/save/avatar",
            data: JSON.stringify(user),
            contentType : 'application/json',
            type: "POST",
            success: function (result) {
                console.log(result);
                if(result.status == 1)
                    alert("保存成功")
            },
            error: function (result) {
                //...;
            }
        });
    });

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
                uploadedFileName = result;
                $('img').attr('src', "/upload/" + result);
                $("input[name='img']").val(result);
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
