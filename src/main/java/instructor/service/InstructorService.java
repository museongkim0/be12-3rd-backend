package instructor.service;

import common.HikariCp;
import instructor.model.Curriculum;
import instructor.model.Handout;
import instructor.model.Homework;
import instructor.model.dao.InstructorDao;

public class InstructorService {
    private InstructorDao instructorDao;

    public InstructorService(){
        this.instructorDao = new InstructorDao(HikariCp.getConnection());
    }

    public void addCurriculum(Curriculum curriculum){
        instructorDao.insertCurriculum(curriculum);
    }

    public Student selectStudentByIdx(int idx){
        return instructorDao.selectStudentSpec(idx);
    }

    public void addHomework(Homework homework){
        instructorDao.insertHomework(homework);
    }

    public void updateHomework(Homework homework){
        instructorDao.updateHomework(homework);
    }

    public void deleteHomework(int homeworkIdx){
        instructorDao.deleteHomework(homeworkIdx);
    }

    public void addHandout(Handout data){
        instructorDao.insertHandout(data);
    }

    public void updateHandout(Handout data){
        instructorDao.updateHandout(data);
    }

    public void deleteHandout(int dataIdx){
        instructorDao.deleteHandout(dataIdx);
    }

    public List<Student> getStudentListByHomework(int idx){
        return instructorDao.selectStudentByHomework(idx);
    }
}
