package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws NoSuchStudentException {
        Parent newParent = new Parent("Boris", "Ivanov", "0877314151", "boris@gmail.com");
        Student newStudent = new Student("Georgi", "Dimitrow", newParent, "0866435675", "gogo@gmail.com", "8072829726");

        Teacher teacherHistory = new Teacher("Kiril", "Petkov", "0886112233", "kiril@gmail.com");
        Teacher teacherMath = new Teacher("Petar", "Ivanov", "0885221133", "petar@gmail.com");
        Teacher teacherLiterature = new Teacher("Ivanka", "Borisova", "0889221133", "ivanka@gmail.com");
        Teacher teacherChemistry = new Teacher("Sonya", "Georgieva", "0882445522", "sonya@gmail.com");
        Teacher teacherEconomy = new Teacher("Manol", "Manolov", "0888435465", "manol@gmail.com");
        Teacher teacherArt = new Teacher("Rayna", "Kostadinova", "0882445522", "rayna@gmail.com");
        Teacher teacherMusic = new Teacher("Boril", "Petkanov", "0886998874", "boril@gmail.com");
        Teacher teacherGeography = new Teacher("Ivaylo", "Graganov", "0883557698", "ivaylo@gmail.com");

        //HISTORY, MATH, LITERATURE, CHEMISTRY, ECONOMY, ART, MUSIC, GEOGRAPHY;
        StudentClass newClass = new StudentClass("9A");
        newStudent.setStudentClass(newClass); // Add newStudent in 9A class
        newClass.addSubject(Subject.ECONOMY, teacherEconomy);
        newClass.addSubject(Subject.LITERATURE, teacherLiterature);
        newClass.addSubject(Subject.HISTORY, teacherHistory);


        teacherLiterature.examineStudent(newStudent, Subject.LITERATURE, Grade.GOOD);
        teacherLiterature.examineStudent(newStudent, Subject.LITERATURE, Grade.EXCELLENT);
        teacherLiterature.examineStudent(newStudent, Subject.LITERATURE, Grade.POOR);

        teacherHistory.examineStudent(newStudent, Subject.HISTORY, Grade.FAIR);
        teacherHistory.examineStudent(newStudent, Subject.HISTORY, Grade.POOR);
        teacherHistory.examineStudent(newStudent, Subject.HISTORY, Grade.EXCELLENT);

        teacherEconomy.examineStudent(newStudent, Subject.ECONOMY, Grade.EXCELLENT);
        teacherEconomy.examineStudent(newStudent, Subject.ECONOMY, Grade.GOOD);
        teacherEconomy.examineStudent(newStudent, Subject.ECONOMY, Grade.POOR);

        newStudent.showGrades();

        //It makes a lot of noise
        //Student newStudent2 = new Student("Georgi", "Dimitrow", newParent, "0866435675", "gogo@gmail.com", "8072829726");

        //Teacher newTeacher = new Teacher("Geno", "Uvardow", "0886112233", "hoho@gmail.com");

        //newStudent.setParent(newParent);
        //System.out.println(newStudent.getParent().getFirstName());
        //Teacher newTeacher = new Teacher("Geno", "Uvardow", "0886112233", "hoho@gmail.com");
        //Teacher newTeacher2 = new Teacher("Geno", "Uvardow", "0886112233", "hoho@gmail.com");
        //examineStudent
        //StudentClass newClass = new StudentClass("9A");
        //StudentClass newClass2 = new StudentClass("8A");
        //newStudent.setStudentClass(newClass);
        //newStudent2.setStudentClass(newClass2);
        //newClass.addSubject(Subject.ECONOMY, newTeacher);
        //newClass.addSubject(Subject.ART, newTeacher);
        //newClass.addSubject(Subject.CHEMISTRY, newTeacher);

        //newClass2.addSubject(Subject.CHEMISTRY, newTeacher2);
        //newClass2.addSubject(Subject.ART, newTeacher2);

        //newTeacher.getListOfClasses().add(newClass);

        //newTeacher.getListOfClasses().add();

        //newTeacher.examineStudent(newStudent2, Subject.ART, Grade.GOOD);
        //newTeacher.examineStudent(newStudent, Subject.ART, Grade.EXCELLENT);
        //newTeacher.examineStudent(newStudent, Subject.ART, Grade.GOOD);
        //newTeacher.examineStudent(newStudent, Subject.ECONOMY, Grade.EXCELLENT);
        //newTeacher.examineStudent(newStudent, Subject.ECONOMY, Grade.GOOD);
        //newTeacher.examineStudent(newStudent, Subject.CHEMISTRY, Grade.GOOD);

        //System.out.println("inMap = "+newClass.inSubjects( Subject.CHEMISTRY, newTeacher2));

        //newTeacher.examineClass(newClass2, Subject.ART);
        //for (int a = 0; a < 45 ;a++) {
        //    newTeacher.addUnvaccinatedAbsences(newStudent);
        //}
        //newParent.showStudentInfo(newStudent);
        //newParent.excuseAbsences(newStudent, 32);


        //newParent.showStudentInfo(newStudent);

        //System.out.println(newTeacher.toString());

        //newStudent.showGrades();


    }
}
