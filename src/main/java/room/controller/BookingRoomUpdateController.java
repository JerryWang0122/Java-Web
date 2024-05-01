package room.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.model.dto.BookingRoomDto;
import room.model.po.BookingRoom;
import room.model.po.Room;
import room.service.BookingRoomService;
import room.service.RoomService;

import java.io.IOException;
import java.util.List;

@WebServlet("/booking_room/update")
public class BookingRoomUpdateController extends HttpServlet {
    private BookingRoomService bookingRoomService = new BookingRoomService();
    private RoomService roomService = new RoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer bookingId = Integer.valueOf(req.getParameter("bookingId"));
        BookingRoom bookingRoom = bookingRoomService.getBookingRoom(bookingId);

        // room 列表
        List<Room> rooms = roomService.getRooms();

        req.setAttribute("bookingRoom", bookingRoom);
        req.setAttribute("rooms", rooms);

        req.getRequestDispatcher("/WEB-INF/jsp/booking_room_update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer bookingId = Integer.valueOf(req.getParameter("bookingId"));
        Integer roomId = Integer.valueOf(req.getParameter("room_id"));
        String checkinDateStr = req.getParameter("checkin_date");

        bookingRoomService.updateBookingRoom(bookingId, roomId, 1, checkinDateStr);
        resp.sendRedirect(req.getContextPath() + "/booking_room");
    }
}
