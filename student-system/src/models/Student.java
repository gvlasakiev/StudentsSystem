package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Student extends Person {
	private String egn;
	// private int classNumber; ?????
	private Parent parent;
	private List<String> remarks;
	private StudentClass studentClass;
	private Map<Subject, List<Grade>> subjectGrade;
	private int excusedAbsences = 0;
	private int unvaccinatedAbsences = 0;

	public Student(String firstName, String lastName, String phoneNumber, String email, String egn) {
		super(firstName, lastName, phoneNumber, email);

		setEgn(egn);
		// setClassNumber(classNumber);
		remarks = new ArrayList<>();
		subjectGrade = new HashMap<>();

	}

	public int getUnvaccinatedAbsences() {
		return unvaccinatedAbsences;
	}

	public String getEgn() {
		return egn;
	}

	public void setEgn(String egn) {
		this.egn = egn;
	}

	// public static int getUnvaccinatedAbsences() {
	// return unvaccinatedAbsences;
	// }
	//
	// public static void setUnvaccinatedAbsences(int unvaccinatedAbsences) {
	// Student.unvaccinatedAbsences = unvaccinatedAbsences;
	// }
	//
	// public String getEgn() {
	// return egn;
	// }
	//
	// private void setEgn(String egn) {
	// this.egn = egn;
	// }

	// public int getClassNumber() {
	// return classNumber;
	// }
	//
	// private void setClassNumber(int classNumber) {
	// this.classNumber = classNumber;
	// }

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
		parent.getChildren().add(this);
	}

	// public List<String> getRemarks() {
	// return remarks;
	// }
	//
	// public void setRemarks(List<String> remarks) {
	// this.remarks = remarks;
	// }

	Map<Subject, List<Grade>> getSubjectGrade() {
		return subjectGrade;
	}
	//
	// public void setSubjectGrade(Map<Subject, List<Grade>> subjectGrade) {
	// this.subjectGrade = subjectGrade;
	// }

	StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
		studentClass.getStudents().add(this);
	}

	public int getExcusedAbsences() {
		return excusedAbsences;
	}


	// public static int getExcusedAbsences() {
	// return excusedAbsences;
	// }
	//
	// public static void setExcusedAbsences(int excusedAbsences) {
	// Student.excusedAbsences = excusedAbsences;
	// }

	/*
	 * Print all student grades by particular subject
	 */
	// public void showGrades() {
	// System.out.println("Grades:");
	// // Can use Streaming API here
	// for (Map.Entry<Subject, List<Grade>> subjectListEntry :
	// subjectGrade.entrySet()) {
	// System.out.print(subjectListEntry.getKey() + " - ");
	//
	// for (Grade grade : subjectListEntry.getValue()) {
	// System.out.print(grade + " ");
	// }
	//
	// System.out.println();
	// }
	// }

	@Override
	public void showInfo() {
		System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
		System.out.printf("Phone number: %s\n", super.getPhoneNumber());
		System.out.printf("Email: %s", super.getEmail());
	}

	// public void showAbsences() {
	// System.out.println("Excused Absences: "+excusedAbsences);
	// System.out.println("Unvaccinated Absences"+unvaccinatedAbsences);
	// }
	//
	// public void showRemarks() {
	// System.out.println("Show Remarks:");
	// for (String remark : remarks) {
	// System.out.println(remark);
	// }
	// }

	// public void showAll() {
	// showInfo();
	// showGrades();
	// showRemarks();
	// showAbsences();
	// }

	@Override
	public String toString() {
		return super.getFirstName() + " " + super.getLastName();
	}
}
