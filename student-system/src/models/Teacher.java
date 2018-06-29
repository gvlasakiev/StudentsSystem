package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class Teacher extends Person implements Evaluation {

	private HashSet<StudentClass> listOfClasses;
	private ArrayList<Subject> listOfSubjects;
	private Map<StudentClass, Subject> studentClassSubjects;

	Teacher(String firstName, String lastName, String phoneNumber, String email) {
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setPhoneNumber(phoneNumber);
		super.setEmail(email);
		listOfClasses = new HashSet<>();
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
			System.out.println(studentClass.getName());
		}
		System.out.println("\nList of all subjects: ");
		for (Subject subject : listOfSubjects) {
			System.out.println(subject);
		}

	}

	public void setListOfClasses(HashSet<StudentClass> listOfClasses) { this.listOfClasses = listOfClasses; }

	public void setListOfSubjects(ArrayList<Subject> listOfSubjects) { this.listOfSubjects = listOfSubjects; }

	public HashSet<StudentClass> getListOfClasses() {
		return listOfClasses;
	}

	public ArrayList<Subject> getListOfSubjects() {
		return listOfSubjects;
	}

	@Override
	public void addGrade(Student student, Subject subject, Grade grade) {
		// Check if teacher has this student in the listOfClasses and
		// subject in listOfSubjects then add grade
		if (this.hasStudentClass(student.getStudentClass())) {
			if (student.getSubjectGrade().containsKey(subject)) {
				student.getSubjectGrade().get(subject).add(grade);
			}
		}
	}

	// Check if Teacher has student class
	private boolean hasStudentClass(StudentClass studentClass) {
		return this.getListOfClasses().contains(studentClass);
	}

	// Show grades for each class in studentClass per subject
	public void printGrades(StudentClass studentClass, Subject subject) {
		if (this.listOfClasses.contains(studentClass) && this.listOfSubjects.contains(subject)) {
			System.out.println("Subject: " + subject);
			System.out.println("Showing grades for " + studentClass.getName() + " :");
			for (Student student : studentClass.getStudents()) {
				System.out.print(student.getFirstName() + " " + student.getLastName() + " ");
				System.out.println(student.getSubjectGrade().get(subject).toString());

			}
		} else {
			System.out.println("Information for " + studentClass + " and " + subject + " is not available.");
		}
	}

	/*
	Send invitation for parent meeting to all student parents in particular student class.
	 */
	public void sendInvitation(StudentClass studentClass) {
		for (Student student : studentClass.getStudents()) {
			Parent currentParent = student.getParent();
			String message = String.format("Hello, Mr/Ms %s. I want to invite you at our school " +
					"for parent meeting on Friday.", currentParent.getLastName());
			currentParent.getUnreadNotification().push(message);
		}
	}
}
