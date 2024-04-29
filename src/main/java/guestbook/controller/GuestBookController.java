package guestbook.controller;

import guestbook.model.GuestBook;
import guestbook.service.GuestBookService;
import guestbook.service.GuestBookServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/guestbook")
public class GuestBookController extends HttpServlet {

    private GuestBookService service = new GuestBookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 取得所有留言紀錄
        List<GuestBook> guestBooks = service.queryAll();
        req.setAttribute("guestBooks", guestBooks);

        // (內)重導到 guestbook.jsp
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/guestbook.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String content = req.getParameter("content");

        boolean state = service.add(username, content);
        req.setAttribute("state", state);

        // (內)重導到 guestbook_result.jsp
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/guestbook_result.jsp");
        rd.forward(req, resp);
    }
}
