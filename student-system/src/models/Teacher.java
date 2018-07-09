package models;

import java.util.*;

public class Teacher extends Person implements Evaluation {


	private static final int ABSENCE = 1;
	private HashSet<StudentClass> listOfClasses;

	private ArrayList<Subject> listOfSubjects;


	// constructor
	public Teacher(String firstName, String lastName, String phoneNumber, String email) {
		super(firstName, lastName, phoneNumber, email);
		listOfClasses = new HashSet<>();
		listOfSubjects = new ArrayList<>();
	}

	public ArrayList<Subject> getListOfSubjects() {
		return listOfSubjects;
	}

	public HashSet<StudentClass> getListOfClasses() {
		return listOfClasses;
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

	// Write remark to specific student
	public void remarkStudent(Student student, String remark) {
		student.getRemarks().add(remark);
	}

	public void addExcusedAbsences(Student student) {
		int currentAbsences = student.getExcusedAbsences();
		student.setExcusedAbsences(currentAbsences + ABSENCE);
	}

	public void addUnvaccinatedAbsences(Student student) {
		int currentAbsences = student.getUnvaccinatedAbsences();
		student.setUnvaccinatedAbsences(currentAbsences + ABSENCE);
	}

	/*
	 Add all students and their parents to attendants event list
	 This is example for polymorphism usage
	  */
	public List<Person> arrangeGraduation(StudentClass studentClass) {
		List<Person> attendants = new ArrayList<>(studentClass.getStudents());
		studentClass.getStudents().forEach(s -> attendants.add(s.getParent()));

		return attendants;
	}

	// Examine-methods from Evaluation interface
	// examine an entire StudentClass by a given subject and add a random Grade
	// for each Student in the StudentClass
	@Override
	public void examineClass(StudentClass studentClass, Subject subject) {
		// Examine with Stream API
		if (this.getListOfClasses().contains(studentClass)) {
			if(this.getListOfSubjects().contains(subject) && studentClass.inSubjects(subject, this)) {
				studentClass.getStudents().forEach(s -> s.getSubjectGrade().get(subject).add(Grade.randomLetter()));
			}
		} else {
			System.out.println("Exception 02");
		}
		// Examine without Stream API
//		for (Student student : studentClass.getStudents()) {
//			student.getSubjectGrade().get(subject).add(Grade.randomLetter());
//		}
	}

	// examine a specific Student adding grade
	// to the list of grades for the specified subject
	@Override
	public void examineStudent(Student student, Subject subject, Grade grade) throws NoSuchStudentException {
		//System.out.println(this.getListOfClasses().contains(student.getStudentClass()));
		if (this.getListOfClasses().contains(student.getStudentClass())) {
			if (this.getListOfSubjects().contains(subject) && student.getStudentClass().inSubjects(subject, this)) {
				student.getSubjectGrade().get(subject).add(grade);
			} else {
				System.out.println("Exception 03");
			}
		} else {
			throw new NoSuchStudentException();
			//System.out.println("Exception 01");
		}
	}

	@Override
	public String toString() {
		return super.getFirstName().charAt(0) + ". " + super.getLastName();
	}
}
