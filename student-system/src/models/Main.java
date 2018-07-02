package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Parent newParent = new Parent("Ivan", "Ivanow", "0877314151", "joro@gmail.com");
        Student newStudent = new Student("Georgi", "Dimitrow", newParent, "0866435675", "gogo@gmail.com", "8072829726");
        Student newStudent2 = new Student("Georgi", "Dimitrow", newParent, "0866435675", "gogo@gmail.com", "8072829726");
        //newStudent.setParent(newParent);
        //System.out.println(newStudent.getParent().getFirstName());
        Teacher newTeacher = new Teacher("Geno", "Uvardow", "0886112233", "hoho@gmail.com");
        Teacher newTeacher2 = new Teacher("Geno", "Uvardow", "0886112233", "hoho@gmail.com");
        //examineStudent
        StudentClass newClass = new StudentClass("9A");
        StudentClass newClass2 = new StudentClass("8A");
        newStudent.setStudentClass(newClass);
        newStudent2.setStudentClass(newClass2);
        newClass.addSubject(Subject.ECONOMY, newTeacher);
        newClass.addSubject(Subject.ART, newTeacher);
        newClass.addSubject(Subject.CHEMISTRY, newTeacher);

        newClass2.addSubject(Subject.CHEMISTRY, newTeacher2);
        newClass2.addSubject(Subject.ART, newTeacher2);

        newTeacher.getListOfClasses().add(newClass);

        //newTeacher.getListOfClasses().add();

        newTeacher.examineStudent(newStudent2, Subject.ART, Grade.GOOD);
        newTeacher.examineStudent(newStudent, Subject.ART, Grade.EXCELLENT);
        newTeacher.examineStudent(newStudent, Subject.ART, Grade.GOOD);
        newTeacher.examineStudent(newStudent, Subject.ECONOMY, Grade.EXCELLENT);
        newTeacher.examineStudent(newStudent, Subject.ECONOMY, Grade.GOOD);
        //newTeacher.examineStudent(newStudent, Subject.CHEMISTRY, Grade.GOOD);

        System.out.println("inMap = "+newClass.inSubjects( Subject.CHEMISTRY, newTeacher2));

        newTeacher.examineClass(newClass2, Subject.ART);
        for (int a = 0; a < 45 ;a++) {
            newTeacher.addUnvaccinatedAbsences(newStudent);
        }
        newParent.showStudentInfo(newStudent);
        newParent.excuseAbsences(newStudent, 32);


        newParent.showStudentInfo(newStudent);

        //System.out.println(newTeacher.toString());

        //newStudent.showGrades();


    }
}
