package models;

import java.util.ArrayList;
import java.util.List;

class StudentClass {
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public StudentClass() {
        students = new ArrayList<>();
    }

    List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
