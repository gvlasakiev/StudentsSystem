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

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public Map<Subject, Teacher> getSubjects() {
		return subjects;
	}

	// Adding a Student to the StudentClass
	public void addStudent(Student student) {
		getStudents().add(student);
		student.setStudentClass(this);
	}

	// Adding a Subject and a respective Teacher
	public void addSubject(Subject subject, Teacher teacher) {
		getSubjects().put(subject, teacher);
	}

}
