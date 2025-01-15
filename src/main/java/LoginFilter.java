import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JwtUtil;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/dashboard"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies = request.getCookies();
        boolean result = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ATOKEN")) {
                    result = JwtUtil.validate(cookie.getValue());
                }
            }
        }

        if (result) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 로그인 안됐음
            ((HttpServletResponse)servletResponse).sendRedirect("/user/login");
        }
    }
}
