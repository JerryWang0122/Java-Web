package room.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/room/*")
public class PassCodeFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = req.getSession();  // 取得 session 物件
        System.out.println("Pass Code Filter For Room, sessionId = " + session.getId());

        // 檢查 request 是否有帶入 ?code=1234
        // String code = req.getParameter("code") == null ? "" : req.getParameter("code");
        String code = req.getParameter("code");
        if ("1234".equals(code)) {  // 檢查參數 code 是否等於 1234
            // 將 code 的值寫入到 session 屬性中
            session.setAttribute("code", code);
            chain.doFilter(req, res);   // pass
        } else if ("1234".equals(session.getAttribute("code"))) {
            chain.doFilter(req, res);
        } else {
            res.getWriter().print("PassCode Error!");
        }
    }
}
