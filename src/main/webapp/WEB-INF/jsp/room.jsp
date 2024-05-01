<%--
  Created by IntelliJ IDEA.
  User: jerrywang
  Date: 2024/4/29
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Room</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body style="padding: 15px">
        <!-- 新增 Room -->
        <form action="/JavaWeb_war_exploded/room" method="post">
            <fieldset>
                <legend class="fs-3">Room Add</legend>
                Room Id：<input class="form-control w-25" id="roomId" name="roomId" placeholder="請輸入roomId" required type="number"><br>
                Room Name：<input class="form-control w-25" id="roomName" name="roomName" placeholder="請輸入roomName" required type="text"><br>
                <input class="btn btn-primary" type="submit" value="新增Room">
            </fieldset>
        </form>

        <%-- Room 列表 --%>
        <div class="col-10 mt-5">
            <table class='table table-dark text-center table-striped table-bordered'>
                <thead>
                <tr>
                    <th>Room Id</th>
                    <th>Room Name</th>
                    <th>修改</th>
                    <th>刪除</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${rooms}" var="room">
                    <tr>
                        <td>${room.roomId}</td>
                        <td>${room.roomName}</td>
                        <td><a href="/JavaWeb_war_exploded/room/update?roomId=${room.roomId}" class="btn btn-success">修改</a></td>
                        <td><a href="/JavaWeb_war_exploded/room?deleteId＝${room.roomId}" class="btn btn-danger">刪除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
