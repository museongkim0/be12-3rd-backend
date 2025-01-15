package manager.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.service.ManagerService;

import java.io.IOException;

@WebServlet("/manager/*")
public class ManagerController extends HttpServlet {
    private ManagerService managerService;

    public ManagerController() {
        managerService = new ManagerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if("dashboard".equals(action)) {
            req.getRequestDispatcher("/manager/dashboard").forward(req, resp);
        } else if("studentList".equals(action)) {
            req.getRequestDispatcher("/manager/studentList").forward(req, resp);
        } else if("instructorList".equals(action)) {
            req.getRequestDispatcher("/manager/instructorList").forward(req, resp);
        } else if("managerList".equals(action)) {
            req.getRequestDispatcher("/manager/managerList").forward(req, resp);
        } else if("attendanceManage".equals(action)) {
            req.getRequestDispatcher("/manager/attendanceManage").forward(req, resp);
        } else if("examList".equals(action)) {
            req.getRequestDispatcher("/manager/examList").forward(req, resp);
        } else if("examDetails".equals(action)) {
            req.getRequestDispatcher("/manager/examDetails").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
    }
}
