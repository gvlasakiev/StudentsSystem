package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person {

	private Parent parent;
	private List<String> remarks;
	private StudentClass studentClass;
	private Map<Subject, List<Grade>> subjectGrade;
	private int excusedAbsences = 0;
	private int unexcusedAbsences = 0;

	public Student(String firstName, String lastName, Parent parent, String phoneNumber, String email) {
		super(firstName, lastName, phoneNumber, email);

		setParent(parent);
		remarks = new ArrayList<>();
		subjectGrade = new HashMap<>();
	}

	public int getUnexcusedAbsences() {
		return unexcusedAbsences;
	}

	public void setUnexcusedAbsences(int unexcusedAbsences) {
		this.unexcusedAbsences = unexcusedAbsences;
	}

	public Parent getParent() {
		return parent;
	}

	private void setParent(Parent parent) {
		this.parent = parent;
		parent.getChildren().add(this);
	}

	public List<String> getRemarks() {
		return remarks;
	}

	public Map<Subject, List<Grade>> getSubjectGrade() {
		return subjectGrade;
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
		studentClass.getStudents().add(this);
	}

	public int getExcusedAbsences() {
		return excusedAbsences;
	}

	public void setExcusedAbsences(int excusedAbsences) {
		this.excusedAbsences = excusedAbsences;
	}

	@Override
	public void showInfo() {
		System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
		System.out.printf("Phone number: %s\n", super.getPhoneNumber());
		System.out.printf("Email: %s", super.getEmail());
	}

	/*
	 * Print all student grades by particular subject
	 */
	public void showGrades() {
		System.out.println("Grades:");
		for (Map.Entry<Subject, List<Grade>> subjectListEntry : subjectGrade.entrySet()) {
			System.out.print(subjectListEntry.getKey() + " - ");

			if (!subjectListEntry.getValue().isEmpty()) {
				System.out.print(subjectListEntry.getValue().get(0));
				for (int i = 1; i < subjectListEntry.getValue().size(); i++) {
					System.out.print("," + subjectListEntry.getValue().get(i));
				}
			}
			System.out.println();
		}
	}

	public void showAbsences() {
		System.out.println("Excused Absences: " + excusedAbsences);
		System.out.println("Unexcused Absences: " + unexcusedAbsences);
	}

	public void showRemarks() {
		System.out.println("Show Remarks:");
		remarks.forEach(System.out::println);
	}

	public void showAll() {
		showInfo();
		showGrades();
		showRemarks();
		showAbsences();
	}

	@Override
	public String toString() {
		return super.getFirstName() + " " + super.getLastName();
	}
}
