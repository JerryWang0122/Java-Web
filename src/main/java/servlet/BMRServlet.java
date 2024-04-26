package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet/bmr")
public class BMRServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 支援utf-8 外文(中、韓、日...)輸入
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // get parameters
        String userSex = req.getParameter("userSex");
        String userAge = req.getParameter("userAge");
        String userHeight = req.getParameter("userHeight");
        String userWeight = req.getParameter("userWeight");

        int age = Integer.parseInt(userAge);
        double height = Double.parseDouble(userHeight);
        double weight = Double.parseDouble(userWeight);

        double bmr = 0;
        switch (userSex) {
            case "1":
                bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
                break;
            case "0":
                bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
                break;
        }

        resp.getWriter().print("BMR Result = " + bmr);
    }
}
