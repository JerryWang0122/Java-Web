<%@ page import="guestbook.model.GuestBook" %>
<%--
  Created by IntelliJ IDEA.
  User: jerrywang
  Date: 2024/4/29
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    GuestBook guestBook = (GuestBook) request.getAttribute("guestBook");
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>GuestBook Update</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body style="padding: 15px">
        <!-- 修改留言 -->
        <form action="/JavaWeb_war_exploded/guestbook/update" method="post">
            <fieldset>
                <legend class="fs-3">GuestBook Add</legend>
                序號：<input class="form-control w-25" id="id" name="id" value="<%=guestBook.getId()%>" required type="text" readonly><br>
                姓名：<input class="form-control w-25" id="username" name="username" value="<%=guestBook.getUserName()%>" placeholder="請輸入姓名" required type="text"><br>
                內容：<br>
                <textarea class="form-control w-25 mb-2" name="content" id="content" cols="20" rows="5" placeholder="請留言" required><%=guestBook.getContent()%></textarea>
                <input class="btn btn-primary" type="submit" value="修改留言">
            </fieldset>
        </form>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
