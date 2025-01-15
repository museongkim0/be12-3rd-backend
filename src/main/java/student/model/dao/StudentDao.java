package student.model.dao;

import student.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {


    private Connection conn;

    public StudentDao(Connection conn) {
        this.conn = conn;
    }


    public Student get_dashboard(int idx) {

        List productList = new ArrayList();
        Student student = null;


        String sql = "select * from User inner join Student on User.idx = Student.user_idx where User.idx =" + idx;

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                student = new Student(rs.getInt("idx"),
                        rs.getString("name"),
                        rs.getInt("auth"),
                        rs.getInt("perception"),
                        rs.getInt("attendance"),
                        rs.getInt("leave_early"),
                        rs.getInt("outing"),
                        rs.getInt("vacation_left"),
                        rs.getInt("course_idx")
                );


            }

            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
