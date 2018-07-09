package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StudentClass {
	private List<Student> students;

	private Map<Subject, Teacher> subjects;
	private String name;

	public StudentClass(String name) {
		setName(name);
		students = new ArrayList<>();
		subjects = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	private Map<Subject, Teacher> getSubjects() {
		return subjects;
	}

	// Adding a Student to the StudentClass
	public void addStudent(Student student) {
		getStudents().add(student);
		student.setStudentClass(this);
	}

	public boolean inSubjects(Subject subject, Teacher teacher) {
		final Teacher value = subjects.get(subject);
		return value != null && value.equals(teacher);
	}

	// Adding a Subject and a respective Teacher
	public void addSubject(Subject subject, Teacher teacher) {
		getSubjects().put(subject, teacher);

		// Add subject with Stream API
		this.getStudents().forEach(s -> s.getSubjectGrade().put(subject, new ArrayList<>()));
		// Add subject to teacher class
		teacher.getListOfSubjects().add(subject);
		teacher.getListOfClasses().add(this);
	}
}
