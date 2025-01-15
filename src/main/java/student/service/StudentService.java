package student.service;


import common.DbConnection;
import student.model.Student;
import student.model.dao.StudentDao;

public class StudentService {

    private static StudentDao studentDao;




    public StudentService() {
        this.studentDao = new StudentDao(DbConnection.getConnection());
    }

    public static Student get_dashboard(int idx) {
        Student student = studentDao.get_dashboard(idx);

        return student;


    }
}
