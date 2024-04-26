package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/servlet/bmi")
public class BMIServlet extends HttpServlet {
    // TODO: 上午最後

    // 存放bmi的歷史紀錄
    private List<Map<String, Object>> bmiList = new CopyOnWriteArrayList<>();

    // 查詢使用
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 編碼
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 將 bmiList 資料印出(回應內容)
        // resp.getWriter().print(bmiList);
        // 回應內容(含HTML)
        resp.getWriter().print("<html>");
        resp.getWriter().print("<head>");
        resp.getWriter().print("</head>");

        resp.getWriter().print("<body>");

        resp.getWriter().print("<table>");
        resp.getWriter().print("<thead>");
        resp.getWriter().print("<tr>");
        resp.getWriter().print("<th>Name</th>");
        resp.getWriter().print("<th>Height</th>");
        resp.getWriter().print("<th>Weight</th>");
        resp.getWriter().print("<th>BMI</th>");
        resp.getWriter().print("</tr>");
        resp.getWriter().print("</thead>");

        resp.getWriter().print("<tbody>");
        resp.getWriter().print("<tr>");
        bmiList.forEach(map -> {
            try {
                resp.getWriter().print("<td>" + map.get("name")+ "</td>");
                resp.getWriter().print("<td>" + map.get("height")+ "</td>");
                resp.getWriter().print("<td>" + map.get("weight")+ "</td>");
                resp.getWriter().print("<td>" + map.get("bmi")+ "</td>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        resp.getWriter().print("</tr>");
        resp.getWriter().print("</tbody>");

        resp.getWriter().print("</table>");

        resp.getWriter().print("</body>");

        resp.getWriter().print("</html>");
    }

    // 給表單使用
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 編碼
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收參數
        String userName = req.getParameter("userName");
        String userHeight = req.getParameter("userHeight");
        String userWeight = req.getParameter("userWeight");

        // 計算 BMI
        // 將 userHeight & userWeight 由 String 轉 Double
        double height = Double.parseDouble(userHeight);
        double weight = Double.parseDouble(userWeight);
        double bmi = weight / Math.pow(height / 100, 2);

        // 建立 Map 集合，放置表單資訊與bmi內容
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", userName);
        map.put("height", height);
        map.put("weight", weight);
        map.put("bmi", bmi);
        // 將資料儲存到bmiList集合中

        bmiList.add(map);
        // 回應內容
        resp.getWriter().print("BMI Result = " + bmi);
    }


}
