package room.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.service.RoomService;

import java.io.IOException;

@WebServlet("/room")
public class RoomController extends HttpServlet {

    private RoomService roomService = new RoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 是否有 deleteId 參數帶入?
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            roomService.deleteRoom(Integer.valueOf(deleteId));
            resp.sendRedirect(req.getContextPath() + "/room");
            return;
        }

        req.setAttribute("rooms", roomService.getRooms());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/room.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer roomId = Integer.valueOf(req.getParameter("roomId"));
        String roomName = req.getParameter("roomName");
        roomService.addRoom(roomId, roomName);
        //TODO: 11:55
        resp.sendRedirect(req.getContextPath() + "/room");  // resp.sendRedirect("/JavaWeb_war_exploded/room");
    }
}
