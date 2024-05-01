<%--
  Created by IntelliJ IDEA.
  User: jerrywang
  Date: 2024/5/1
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
    <head>
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0, user-scalable=yes, minimum-scale=1.0, maximum-scale=3.0">
        <meta charset="UTF-8">
        <title>Booking Room</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
    </head>
    <body style="padding: 15px">
        <!-- 新增 Booking Room -->
        <form action="/JavaWeb_war_exploded/booking_room" method="post">
            <fieldset>
                <legend class="fs-3">BookingRoom Add</legend>

                Room Name：
                <select class="form-select w-25" name="room_id" id="room_id">
                    <c:forEach items="${rooms}" var="room">
                        <option value="${room.roomId}">${room.roomName}</option>
                    </c:forEach>
                </select><br>

                Check In: <input class="form-control w-25" type="date" name="checkin_date" id="checkin_date"><br>

                <input class="btn btn-primary" type="submit" value="Booking">
            </fieldset>
        </form>

        <%-- BookingRoom 列表 --%>
        <div class="col-10 mt-5">
            <table class='table table-dark text-center table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Booking Id</th>
                        <th>Room Id</th>
                        <th>Room Name</th>
                        <th>User Id</th>
                        <th>Check In</th>
                        <th>Create Time</th>
                        <th>修改</th>
                        <th>刪除</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${bookingRoomDtos}" var="bookingRoomDto">
                        <tr>
                            <td>${ bookingRoomDto.bookingId }</td>
                            <td>${ bookingRoomDto.room.roomId }</td>
                            <td>${ bookingRoomDto.room.roomName }</td>
                            <td>${ bookingRoomDto.userId }</td>
                            <td>${ bookingRoomDto.checkinDate }</td>
                            <td>${ bookingRoomDto.createTime }</td>
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
