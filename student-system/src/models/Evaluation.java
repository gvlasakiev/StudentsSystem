package models;

public interface Evaluation {
	public void examineClass(StudentClass studentClass, Subject subject);

	public void examineStudent(Student student, Subject subject, Grade grade) throws NoSuchStudentException;
}
