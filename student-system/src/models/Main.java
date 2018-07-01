package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Parent newParent = new Parent("Ivan", "Ivanow", "0877314151", "joro@gmail.com");
        Student newStudent = new Student("Georgi", "Dimitrow", "0866435675", "gogo@gmail.com", "8072829726");
        newStudent.setParent(newParent);
        //System.out.println(newStudent.getParent().getFirstName());
        Teacher newTeacher = new Teacher("Geno", "Uvardow", "0886112233", "hoho@gmail.com");
        //examineStudent
        StudentClass newClass = new StudentClass("9A");
        newStudent.setStudentClass(newClass);
        newClass.addSubject(Subject.ART, newTeacher);

        newTeacher.examineStudent(newStudent, Subject.ART, Grade.GOOD);
        System.out.print(newStudent.getSubjectGrade());


    }
}
