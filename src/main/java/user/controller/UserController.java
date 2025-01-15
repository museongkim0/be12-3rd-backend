package user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.model.User;
import user.model.dto.LoginDto;
import user.service.UserService;
import util.JwtUtil;
import utils.JsonParser;

import java.io.IOException;

@WebServlet("/user/*")
public class UserController extends HttpServlet {

    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if ("/login".equals(action)) {
            req.getRequestDispatcher("/view/user/login.jsp").forward(req, resp);
        } else if ("/signup".equals(action)) {
            req.getRequestDispatcher("/view/user/signup.jsp").forward(req, resp);
        } else if ("/profile".equals(action)) {
            User user = userService.getProfile(req.getParameter("username"));
            req.setAttribute("user", user);
            req.getRequestDispatcher("/view/user/profile.jsp").forward(req, resp);
        } else if("/logout".equals(action)) {
            req.getSession().setAttribute("isLogin", null);
            req.getSession().setAttribute("userIdx", null);
            req.getSession().setAttribute("userName", null);
            resp.sendRedirect("/user/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if ("/signup".equals(action)) {
            User user = new User(
                    req.getParameter("email"),
                    req.getParameter("password"),
                    req.getParameter("name")
            );
            userService.signup(user);
            resp.sendRedirect("/user/login");
        } else if ("/login".equals(action)) {
//            User user = new User(
//                    req.getParameter("email"),
//                    req.getParameter("password")
//            );
            // JSON 형식으로 요청 받는 부분
            User user = JsonParser.parse(req, User.class);
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());


            int userIdx = userService.login(user);
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            if (userIdx > 0 ) {                     // {"result":true, "userIdx":11, "userName":"test01"}
//                req.getSession().setAttribute("isLogin", true);
//                req.getSession().setAttribute("userIdx", userIdx);
//                req.getSession().setAttribute("userName", user.getEmail());

                // JWT 토큰 생성
                String token = JwtUtil.generateToken(userIdx, user.getEmail());
                // {"result":true, "token": "eyd~~~"}

                // JSON 형식으로 응답 주는 부분
                LoginDto resDto = new LoginDto(true, token);
                JsonParser.parse(resp, resDto);
//                resp.sendRedirect("/product/list");
                Cookie cookie = new Cookie("ATOKEN", token);
                cookie.setHttpOnly(true);
                cookie.setSecure(false);
                cookie.setMaxAge(30*60);
                cookie.setPath("/");
                resp.addCookie(cookie);


                return;
            }
            resp.sendRedirect("/user/login");
        }
    }
}
