package models;

import java.util.ArrayList;
import java.util.List;

class StudentClass {
    private List<Student> students;
    private String name;

    StudentClass(String name) {
        this.setName(name);
        students = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
