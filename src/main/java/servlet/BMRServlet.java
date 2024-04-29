package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/servlet/bmr")
public class BMRServlet extends HttpServlet {
    // 存放bmr的歷史紀錄
    private List<Map<String, Object>> bmrList = new CopyOnWriteArrayList<>();

    // 紀錄查詢
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 是否有 deleteId 參數帶入?
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            // 將deleteId 轉成 int
            int id = Integer.parseInt(deleteId);
            // 刪除指定id位置的紀錄
            bmrList.remove(id);
        }

        // 處理資料
        // 透過 setAttribute 將 bmrList 放到 req 屬性中的技術
        // 就可以將 bmrList 傳遞給 jsp
        req.setAttribute("bmrList", bmrList);

        // 將資料分派到 jsp
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/bmr_list.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 支援utf-8 外文(中、韓、日...)輸入
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // get parameters
        String userName = req.getParameter("userName");
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

        // 建立 Map 集合，放置表單資訊與bmr內容
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", userName);
        map.put("gender", userSex);
        map.put("age", userAge);
        map.put("height", height);
        map.put("weight", weight);
        map.put("bmr", bmr);

        // 將資料儲存到bmrList集合中
        bmrList.add(map);

        resp.getWriter().print("BMR Result = " + bmr);
    }
}
