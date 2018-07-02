package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Teacher extends Person implements Evaluation {

	private HashSet<StudentClass> listOfClasses;
	private ArrayList<Subject> listOfSubjects;

	// constructor
	public Teacher(String firstName, String lastName, String phoneNumber, String email) {
		super(firstName, lastName, phoneNumber, email);
		listOfClasses = new HashSet<>();
		listOfSubjects = new ArrayList<>();
	}

	// Show grades for each class in studentClass per subject
	public void printGrades(StudentClass studentClass, Subject subject) {
		if (this.listOfClasses.contains(studentClass) && this.listOfSubjects.contains(subject)) {
			System.out.println("Subject: " + subject);
			System.out.println("Showing grades for " + studentClass.getName() + " :");
			for (Student student : studentClass.getStudents()) {
				System.out.print(student.toString() + " ");
				System.out.println(student.getSubjectGrade().get(subject).toString());

			}
		} else {
			System.out.println("Information for " + studentClass + " and " + subject + " is not available.");
		}
	}

	/*
	 * Send invitation for parent meeting to all student parents in particular
	 * student class.
	 */
	void sendInvitation(StudentClass studentClass) {
		for (Student student : studentClass.getStudents()) {
			Parent currentParent = student.getParent();
			String message = String.format(
					"Hello, Mr/Ms %s. I want to invite you at our school " + "for parent meeting on Friday.",
					currentParent.getLastName());
			currentParent.getUnreadNotification().push(message);
		}
	}

	@Override
	public void showInfo() {
		System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
		System.out.printf("Phone number: %s\n", super.getPhoneNumber());
		System.out.printf("Email: %s\n", super.getEmail());
		System.out.println("List of all classes: ");

		// Print with Stream API
		listOfClasses.forEach(System.out::println);

		// Print without Stream API
		// for (StudentClass studentClass : listOfClasses) {
		// System.out.println(studentClass.getName());
		// }

		System.out.println("\nList of all subjects: ");

		// Print with Stream API
		listOfSubjects.forEach(System.out::println);

		// Print without Stream API
		// for (Subject subject : listOfSubjects) {
		// System.out.println(subject);
		// }

	}

	// Examine-methods from Evaluation interface
	// examine an entire StudentClass by a given subject and add a random Grade
	// for each Student in the StudentClass
	@Override
	public void examineClass(StudentClass studentClass, Subject subject) {
		for (Student student : studentClass.getStudents()) {
			student.getSubjectGrade().get(subject).add(Grade.randomLetter());
		}
	}

	// examine a specific Student adding grade
	// to the list of grades for the specified subject
	@Override
	public void examineStudent(Student student, Subject subject, Grade grade) {
		student.getSubjectGrade().get(subject).add(grade);
	}

	@Override
	public String toString() {
		return super.getFirstName().charAt(0) + ". " + super.getLastName();
	}
}
