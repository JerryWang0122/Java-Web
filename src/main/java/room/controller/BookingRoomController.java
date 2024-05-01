package room.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.model.dto.BookingRoomCount;
import room.model.dto.BookingRoomDto;
import room.model.po.BookingRoom;
import room.model.po.Room;
import room.service.BookingRoomService;
import room.service.RoomService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/booking_room")
public class BookingRoomController extends HttpServlet {

    private BookingRoomService bookingRoomService = new BookingRoomService();
    private RoomService roomService = new RoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 處理 deleteId
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            bookingRoomService.deleteBookingRoom(Integer.valueOf(deleteId));
            // 重新導入，消除deleteId
            resp.sendRedirect(req.getContextPath() + "/booking_room");
            return;
        }

        // dto 列表
        List<BookingRoomDto> bookingRoomDtos = new ArrayList<>();
        // po -> dto
        List<BookingRoom> bookingRooms = bookingRoomService.findAllBookingRooms();
        for (BookingRoom bookingRoom : bookingRooms) {
            BookingRoomDto dto = new BookingRoomDto();
            dto.setBookingId(bookingRoom.getBookingId());
            dto.setCheckinDate(bookingRoom.getCheckinDate());
            dto.setCreateTime(bookingRoom.getCreateTime());
            dto.setUserId(bookingRoom.getUserId());

            Room room = roomService.getRoom(bookingRoom.getRoomId());
            dto.setRoom(room);

            // 加入到集合
            bookingRoomDtos.add(dto);
        }

        // room 列表
        List<Room> rooms = roomService.getRooms();
        List<BookingRoomCount> bookingRoomCounts = bookingRoomService.getBookingRoomCounts();

        req.setAttribute("bookingRoomDtos", bookingRoomDtos);
        req.setAttribute("bookingRoomCounts", bookingRoomCounts);
        req.setAttribute("rooms", rooms);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/booking_room.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer roomId = Integer.valueOf(req.getParameter("room_id"));
        String checkinDateStr = req.getParameter("checkin_date");

        bookingRoomService.addBookingRoom(roomId, 1, checkinDateStr);

        // 重導到首頁
        // req.getContextPath(): /JavaWeb_war_exploded
        resp.sendRedirect(req.getContextPath() + "/booking_room");

    }
}
