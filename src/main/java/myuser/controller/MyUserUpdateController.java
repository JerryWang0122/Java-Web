package myuser.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myuser.model.dto.MyUserDto;
import myuser.service.MyUserService;

import java.io.IOException;

@WebServlet("/myuser/update")
public class MyUserUpdateController extends HttpServlet {
    private MyUserService myUserService = new MyUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyUserDto updateUser = myUserService.getUser(req.getParameter("updateId"));
        req.setAttribute("updateUser", updateUser);
        req.getRequestDispatcher("/WEB-INF/jsp/myuser_update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        String name = req.getParameter("eName");
        String dept = req.getParameter("eDept");
        String title = req.getParameter("eTitle");
        String email = req.getParameter("eEmail");
        myUserService.updateInfo(empId, name, dept, title, email);
        resp.sendRedirect(req.getContextPath() + "/myuser");
    }
}
