<%--
  Created by IntelliJ IDEA.
  User: jerrywang
  Date: 2024/5/1
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Room Update</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body style="padding: 15px">
        <!-- 修改 Room -->
        <form action="/JavaWeb_war_exploded/room/update" method="post">
            <fieldset>
                <legend class="fs-3">Room Update</legend>
                Room Id：<input class="form-control w-25" id="roomId" name="roomId" value="${ room.roomId }" required type="number" readonly><br>
                Room Name：<input class="form-control w-25" id="roomName" name="roomName" value="${ room.roomName }" placeholder="請輸入roomName" required type="text"><br>
                <input class="btn btn-primary" type="submit" value="修改Room">
            </fieldset>
        </form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
