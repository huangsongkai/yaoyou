<%@ page import="java.text.SimpleDateFormat" %>
<script>
    //window.userInfo = {"email":"liuruichao@qq.com", "gender":"male", "studyType":"4", "member":{"type":"117"}, "cusId":"123456"};
    window.userInfo = ${sessionScope.userInfoJson};
</script>

<div id="sso_login_div" style="display: none"></div>