package instructor.controller;

import instructor.service.InstructorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/instructor/*")
public class InstructorController extends HttpServlet {
    private InstructorService instructorService;

    InstructorController() {
        instructorService = new InstructorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if ("/dashboard".equals(action)) {
            req.getRequestDispatcher("/instructor/InstructorDash.vue").forward(req, resp);
        } else if ("/addHomework".equals(action)) {
            req.getRequestDispatcher("/instructor/InstructorDash.vue").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if ("/signup".equals(action)) {

            resp.sendRedirect("/user/login");
        }
    }
}
