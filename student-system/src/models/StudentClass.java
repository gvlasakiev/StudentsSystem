package models;

import java.util.ArrayList;
import java.util.List;

class StudentClass {
    private List<Student> students;

    public StudentClass() {
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
