package instructor.model.dao;

import instructor.model.Curriculum;
import instructor.model.Handout;
import instructor.model.Homework;
import instructor.model.Instructor;
import student.model.Student;

import java.sql.Connection;
import java.util.List;

public class InstructorDao {
    private Connection conn;

    public InstructorDao(Connection conn) {
        this.conn = conn;
    }

    // 커리큘럼 등록
    public void insertCurriculum(Curriculum curriculum) {
        String sql = "insert into Course_Curriculum values(?,?,?,?,?)";

    }

    // 학생 상세보기
    public Student selectStudentSpec(int idx){
        String sql = "select * from Student where idx=?";

        return null;
    }

    // 과제 생성
    public void insertHomework(Homework homework) {
        String sql = "insert into Homework values(?,?,?,?,?)";

    }

    // 과제 수정
    public void updateHomework(Homework homework) {
        String sql = "update Homework set homework=? where idx=?";

    }

    // 과제 삭제
    public void deleteHomework(int idx) {
        String sql = "delete from Homework where idx=?";

    }

    // 자료 등록
    public void insertHandout(Handout handout) {
        String sql = "insert into Course_Data values(?,?,?,?,?)";

    }

    // 자료 수정
    public void updateHandout(Handout data) {
        String sql = "update Course_Data set data=? where idx=?";

    }

    // 자료 삭제
    public void deleteHandout(int idx) {
        String sql = "delete from Course_Data where idx=?";

    }

    // 과제별 제출 학생 확인
    public List<Student> selectStudentByHomework(int homeworkIdx){
        String sql = "select * from Homework where idx=?";

        return null;
    }
}
