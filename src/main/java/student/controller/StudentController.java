package student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import student.model.Student;
import student.model.dao.StudentDao;
import student.service.StudentService;

import java.io.IOException;


@WebServlet("/student/*")
public class StudentController extends HttpServlet {

    private StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();

        if ("/dashboard".equals(action)) {

            System.out.println("실행됌");
            int idx = Integer.parseInt(req.getParameter("userIdx"));


            System.out.println(idx);
            Student student = StudentService.get_dashboard(idx);


            System.out.println(student.getIdx());
            System.out.println(student.getName() + " " + student.getAuth());

            utils.JsonParser.parse(resp,student);




        }

    }

}
