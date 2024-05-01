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
        <title>Booking Room Update</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
    </head>
    <body style="padding: 15px">

        <!-- 修改 Booking Room -->
        <form action="/JavaWeb_war_exploded//booking_room/update" method="post">
            <fieldset>
                <legend class="fs-3">BookingRoom Update</legend>

                Booking Room Name：
                <select class="form-select w-25" name="room_id" id="room_id">
                    <c:forEach items="${rooms}" var="room">
                        <%-- 當 bookingRoom.roomId == room.roomId 時，選擇該項  --%>
                        <option value="${room.roomId}"
                                <c:if test="${bookingRoom.roomId == room.roomId}">selected</c:if>>
                                ${room.roomName}
                        </option>
                    </c:forEach>
                </select><br>

                Check In: <input class="form-control w-25" type="date" name="checkin_date" id="checkin_date"
                                 value="<fmt:formatDate pattern="yyyy-MM-dd"
                                        value="${bookingRoom.checkinDate}" />"><br>

                <input type="hidden" name="bookingId" value="${bookingRoom.bookingId}">
                <input class="btn btn-primary mb-3" type="submit" value="修改Booking">
            </fieldset>
        </form>

        <a class="btn btn-primary" href="/JavaWeb_war_exploded">回首頁</a>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
