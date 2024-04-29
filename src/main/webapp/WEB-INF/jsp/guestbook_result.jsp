<%--
  Created by IntelliJ IDEA.
  User: jerrywang
  Date: 2024/4/29
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    Boolean state = (Boolean) request.getAttribute("state");
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>GuestBook Result</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body style="padding: 15px">

        <div>
            <h3>GuestBook Result</h3>
            <%=state?"新增成功":"新增失敗"%>
            <br>
            <a href="/JavaWeb_war_exploded/guestbook" class="btn btn-primary">返回</a>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
