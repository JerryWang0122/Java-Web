package myuser.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myuser.service.MyUserService;

import java.io.IOException;

@WebServlet("/myuser")
public class MyUserController extends HttpServlet {
    private MyUserService myUserService = new MyUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            myUserService.deleteMyUser(deleteId);
            resp.sendRedirect(req.getContextPath() + "/myuser");
            return;
        }

        req.setAttribute("myusers", myUserService.getAllUsers());
        req.getRequestDispatcher("/WEB-INF/jsp/myuser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        String name = req.getParameter("eName");
        String dept = req.getParameter("eDept");
        String title = req.getParameter("eTitle");
        String email = req.getParameter("eEmail");
        String pwd = req.getParameter("ePassword");

        myUserService.addMyUser(empId, name, pwd, dept, title, email);
        resp.sendRedirect(req.getContextPath() + "/myuser");
    }
}
