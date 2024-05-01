package room.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.service.RoomService;

import java.io.IOException;

// 進行 Room 修改
@WebServlet("/room/update")
public class RoomUpdateController extends HttpServlet {

    private RoomService service = new RoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer roomId = Integer.valueOf(req.getParameter("roomId"));
        req.setAttribute("room", service.getRoom(roomId));
        req.getRequestDispatcher("/WEB-INF/jsp/room_update.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer roomId = Integer.valueOf(req.getParameter("roomId"));
        String roomName = req.getParameter("roomName");
        service.updateRoom(roomId, roomName);
        resp.sendRedirect(req.getContextPath() + "/room");
    }
}
