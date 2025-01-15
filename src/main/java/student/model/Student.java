package student.model;

public class Student {


    int idx;
    String name;
    int auth;
    int perception;
    int attendance;
    int leave_early;
    int outing;
    int vacation_left;
    int course_idx;

    public Student() {
    }

    public Student(int idx, String name, int auth, int perception, int attendance, int leave_early, int outing, int vacation_left, int course_idx) {
        this.idx = idx;
        this.name = name;
        this.auth = auth;
        this.perception = perception;
        this.attendance = attendance;
        this.leave_early = leave_early;
        this.outing = outing;
        this.vacation_left = vacation_left;
        this.course_idx = course_idx;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getLeave_early() {
        return leave_early;
    }

    public void setLeave_early(int leave_early) {
        this.leave_early = leave_early;
    }

    public int getOuting() {
        return outing;
    }

    public void setOuting(int outing) {
        this.outing = outing;
    }

    public int getVacation_left() {
        return vacation_left;
    }

    public void setVacation_left(int vacation_left) {
        this.vacation_left = vacation_left;
    }

    public int getCourse_idx() {
        return course_idx;
    }

    public void setCourse_idx(int course_idx) {
        this.course_idx = course_idx;
    }
}
