package instructor.service;

import common.DbConnection;
import instructor.model.dao.InstructorDao;

public class InstructorService {
    private InstructorDao instructorDao;

    public InstructorService(){
        this.instructorDao = new InstructorDao(DbConnection.getConnection());
    }

    public void addCurriculum(Object curriculum){
        instructorDao.insertCurriculum(curriculum);
    }

    public Student selectStudentByIdx(int idx){
        return instructorDao.selectStudentSpec(idx);
    }

    public void addHomework(Object homework){
        instructorDao.insertHomework(homework);
    }

    public void updateHomework(Object homework){
        instructorDao.updateHomework(homework);
    }

    public void deleteHomework(int homeworkIdx){
        instructorDao.deleteHomework(homeworkIdx);
    }

    public void addData(Object data){
        instructorDao.insertData(data);
    }

    public void updateData(Object data){
        instructorDao.updateData(data);
    }

    public void deleteData(int dataIdx){
        instructorDao.deleteData(dataIdx);
    }

    public List<Student> getStudentListByHomework(int idx){
        return instructorDao.selectStudentByHomework(idx);
    }
}
