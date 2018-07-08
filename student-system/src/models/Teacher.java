package models;

import java.util.*;

public class Teacher extends Person implements Evaluation {
	private static final int ABSENCE = 1;
	private HashSet<StudentClass> listOfClasses;
	private ArrayList<Subject> listOfSubjects;

	public Teacher(String firstName, String lastName, String phoneNumber, String email) {
		super(firstName, lastName, phoneNumber, email);
		listOfClasses = new HashSet<>();
		listOfSubjects = new ArrayList<>();
	}

	public HashSet<StudentClass> getListOfClasses() {
		return listOfClasses;
	}

	public ArrayList<Subject> getListOfSubjects() {
		return listOfSubjects;
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
	public void sendInvitation(StudentClass studentClass) {
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

		System.out.println("\nList of all subjects: ");

		listOfSubjects.forEach(System.out::println);
	}

	// Write remark to specific student
	public void remarkStudent(Student student, String remark) {
		student.getRemarks().add(remark);
	}

	public void addExcusedAbsences(Student student) {
		int currentAbsences = student.getExcusedAbsences();
		student.setExcusedAbsences(currentAbsences + ABSENCE);
	}

	public void addUnexcusedAbsences(Student student) {
		int currentAbsences = student.getUnexcusedAbsences();
		student.setUnexcusedAbsences(currentAbsences + ABSENCE);
	}

	/*
	 * Add all students and their parents to attendants event list This is
	 * example for polymorphism usage
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
	public void examineClass(StudentClass studentClass, Subject subject) throws NoSuchStudentClassException {
		// Examine with Stream API
		if (this.listOfClasses.contains(studentClass)) {
			if (this.listOfSubjects.contains(subject) && studentClass.inSubjects(subject, this)) {
				studentClass.getStudents().forEach(s -> s.getSubjectGrade().get(subject).add(Grade.randomLetter()));
			}
		} else {
			throw new NoSuchStudentClassException();
		}
	}

	// Examine a specific Student adding grade
	// to the list of grades for the specified subject
	@Override
	public void examineStudent(Student student, Subject subject, Grade grade)
			throws NoSuchStudentException, NoSuchSubjectException {
		System.out.println(this.listOfClasses.contains(student.getStudentClass()));
		if (this.listOfClasses.contains(student.getStudentClass())) {
			if (this.listOfSubjects.contains(subject) && student.getStudentClass().inSubjects(subject, this)) {
				student.getSubjectGrade().get(subject).add(grade);
			} else {
				throw new NoSuchSubjectException();
			}
		} else {
			throw new NoSuchStudentException();
		}
	}

	@Override
	public String toString() {
		return super.getFirstName().charAt(0) + ". " + super.getLastName();
	}
}
