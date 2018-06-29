package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Student extends Person {
    private String egn;
    private int classNumber;
    private Parent parent;
    private List<String> remarks;
    private StudentClass studentClass;
    //private List<Subject> subjects;
    private Map<Subject, List<Grade>> subjectGrade;

    public static int getUnvaccinatedAbsences() {
        return unvaccinatedAbsences;
    }

    public static void setUnvaccinatedAbsences(int unvaccinatedAbsences) {
        Student.unvaccinatedAbsences = unvaccinatedAbsences;
    }

    private static int excusedAbsences = 0;
    private static int unvaccinatedAbsences = 0;

    public Student(String firstName, String lastName, String phoneNumber, String email, String egn, int classNumber, Parent parent, List<String> remarks, List<Subject> subjects, Map<Subject, List<Grade>> subjectGrade, StudentClass studentClass) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setPhoneNumber(phoneNumber);
        super.setEmail(email);

        setEgn(egn);
        setClassNumber(classNumber);
        setParent(parent);
        setStudentClass(studentClass);
        remarks = new ArrayList<String>();
        subjects = new ArrayList<Subject>();
        subjectGrade = new HashMap<Subject, List<Grade>>();
    }


    public String getEgn() {
        return egn;
    }

    private void setEgn(String egn) {
        this.egn = egn;
    }

    public int getClassNumber() {
        return classNumber;
    }

    private void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public Parent getParent() {
        return parent;
    }

    private void setParent(Parent parent) {
        this.parent = parent;
    }

    public List<String> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<String> remarks) {
        this.remarks = remarks;
    }

    Map<Subject, List<Grade>> getSubjectGrade() {
        return subjectGrade;
    }

    public void setSubjectGrade(Map<Subject, List<Grade>> subjectGrade) {
        this.subjectGrade = subjectGrade;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public static int getExcusedAbsences() {
        return excusedAbsences;
    }

    public static void setExcusedAbsences(int excusedAbsences) {
        Student.excusedAbsences = excusedAbsences;
    }

    /*
    Print all student grades by particular subject
     */
    public void showGrades() {
        System.out.println("Grades:");
        // Can use Streaming API here
        for (Map.Entry<Subject, List<Grade>> subjectListEntry : subjectGrade.entrySet()) {
            System.out.print(subjectListEntry.getKey() + " - ");

            for (Grade grade : subjectListEntry.getValue()) {
                System.out.print(grade + " ");
            }

            System.out.println();
        }
    }

    @Override
    protected void showInfo() {
        System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
        System.out.printf("Phone number: %s\n", super.getPhoneNumber());
        System.out.printf("Email: %s", super.getEmail());
    }

    public void showAbsences() {
        System.out.println("Excused Absences: "+excusedAbsences);
        System.out.println("Unvaccinated Absences"+unvaccinatedAbsences);
    }

    public void showRemarks() {
        System.out.println("Show Remarks:");
        for (String remark : remarks) {
            System.out.println(remark);
        }
    }

    public void showAll() {
        showInfo();
        showGrades();
        showRemarks();
        showAbsences();
    }

}
