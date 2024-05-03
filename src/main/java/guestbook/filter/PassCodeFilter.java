package guestbook.filter;

// 通關密碼： code = 1234
// 使用者輸入通關密碼才可以到訪客留言板(GuestBook)

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 只管控 /guestbook
@WebFilter("/guestbook")
public class PassCodeFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("PassCodeFilter 過濾 " + req.getMethod());

        if (req.getMethod().equals("GET")) {
            // 檢查是否有deleteId -> 因為有deleteId就代表已經登入，需要做刪除，沒有則需要額外做驗證
            if (req.getParameter("deleteId") == null) {
                // 檢查 code 是否等於 1234
                if (req.getParameter("code") == null || !req.getParameter("code").equals("1234")) {
                    res.getWriter().print("PassCode Error!");
                    return;
                }
            }
        }

        // 放行
        chain.doFilter(req, res);
    }
}
