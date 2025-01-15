package instructor.controller;

import instructor.model.Curriculum;
import instructor.model.Handout;
import instructor.model.Homework;
import instructor.service.InstructorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import student.model.Student;

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
        } else if ("/studentSpec".equals(action)) {
            Student student = instructorService.selectStudentByIdx(Integer.parseInt(req.getParameter("studentIdx")));

            req.setAttribute("student", student);
            req.getRequestDispatcher("/instructor/InstStudInform.vue").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if ("/addHomework".equals(action)) {
            Homework homework = utils.JsonParser.parse(req, Homework.class);

            instructorService.addHomework(homework);
            resp.sendRedirect("/instructor/dashboard");
        } else if ("/updateHomework".equals(action)) {
            Homework homework = utils.JsonParser.parse(req, Homework.class);
            instructorService.updateHomework(homework);

            resp.sendRedirect("/instructor/dashboard");
        } else if ("/deleteHomework".equals(action)) {

            resp.sendRedirect("/instructor/dashboard");
        } else if ("/addHandout".equals(action)) {
            Handout handout = utils.JsonParser.parse(req, Handout.class);
            instructorService.addHandout(handout);

            resp.sendRedirect("/instructor/dashboard");
        } else if ("/updateHandout".equals(action)) {
            Handout handout = utils.JsonParser.parse(req, Handout.class);
            instructorService.updateHandout(handout);

            resp.sendRedirect("/instructor/dashboard");
        } else if ("/deleteHandout".equals(action)) {

            resp.sendRedirect("/instructor/dashboard");
        } else if ("/addCurriculum".equals(action)) {
            Curriculum curriculum = utils.JsonParser.parse(req, Curriculum.class);
            instructorService.addCurriculum(curriculum);

            resp.sendRedirect("/instructor/dashboard");
        }
    }
}
