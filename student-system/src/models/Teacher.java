package models;

import java.util.ArrayList;
import java.util.Map;

public class Teacher extends Person {

	private ArrayList<StudentClass> listOfClasses;
	private ArrayList<Subject> listOfSubjects;

	private Map<StudentClass, Subject> studentClassSubjects;

	public Teacher() {
		super();
		listOfClasses = new ArrayList<>();
		listOfSubjects = new ArrayList<>();
	}

	@Override
	protected void showInfo() {
		System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
		System.out.printf("Phone number: %s\n", super.getPhoneNumber());
		System.out.printf("Email: %s\n", super.getEmail());
		System.out.println("List of all classes: ");

		// Can use StreamingAPI -- >
		for (StudentClass studentClass : listOfClasses) {
			System.out.println(studentClass);
		}
		System.out.println("\nList of all subjects: ");
		for (Subject subject : listOfSubjects) {
			System.out.println(subject);
		}

	}

	public ArrayList<StudentClass> getListOfClasses() {
		return listOfClasses;
	}

	public ArrayList<Subject> getListOfSubjects() {
		return listOfSubjects;
	}

	public void addGrade(Student student, Subject subject, Grade grade) {
		// Check if teacher has this student in the listOfClasses and
		// subject in listOfSubjects then add grade
		if (this.hasStudentClass(student.getStudentClass()) && this.hasStudent(student)) {
			if (student.getSubjectGrade().containsKey(subject)) {
				student.getSubjectGrade().get(subject).add(grade);
			}
		}
	}

	// Check if Teacher has studentClass
	public boolean hasStudentClass(StudentClass studentClass) {
		if (this.getListOfClasses().contains(studentClass)) {
			return true;
		}
		return false;
	}

	// Check if Teacher has student
	public boolean hasStudent(Student student) {
		if (this.hasStudentClass(student.getStudentClass())) {
			if (student.getStudentClass().getStudents().contains(student)) {
				return true;
			}
		}
		return false;
	}
	
	//Show grades for each class in studentClass
	public void printGrades(StudentClass studentClass, Subject subject) {
		System.out.println("Subject: " + subject);
		System.out.println("Showing grades for " + studentClass + " :");
		for (Student student : studentClass.getStudents()) {
			System.out.print(student.getFirstName() + " " + student.getLastName() + " ");
			System.out.println(student.getSubjectGrade().get(subject).toString());
			
		}
	}
}
