package guestbook.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 過濾/攔截
@WebFilter("/guestbook/*")
public class UTF8EncodeFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        // 這層 Filter 做的事 (Middle ware)
        // 編碼
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");

        // res.getWriter().print("UTF8Encode");
        System.out.println("UTF8 Encoder Filter 編碼");

        // 往下繼續執行
        chain.doFilter(req, res);
    }
}
