package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person {
    private String eng;
    private int classNumber;
    private Parent parent;
    private List<String> remarks;
    //private List<Subject> subjects;
    private Map<Subject, List<Grade>> subjectGrade;

    public Student(String egn, int classNumber, Parent parent, List<String> remarks, List<Subject> subjects, Map<Subject, List<Grade>> subjectGrade) {
        setEng(egn);
        setClassNumber(classNumber);
        setParent(parent);
        remarks = new ArrayList<String>();
        subjects = new ArrayList<Subject>();
        subjectGrade = new HashMap<Subject, List<Grade>>();
    }


    @Override
    protected void showInfo() {
        System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
        System.out.printf("Phone number: %s\n", super.getPhoneNumber());
        System.out.printf("Email: %s", super.getEmail());
    }

    public String getEng() {
        return eng;
    }

    private void setEng(String eng) {
        this.eng = eng;
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

    public void showRemarks() {
        System.out.println("Show Remarks:");
        for (int a = 0; a < remarks.size() ;a++) {
            System.out.println(remarks.get(a));
        }
    }
}
