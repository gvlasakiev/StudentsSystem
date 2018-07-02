package models;

public class NoSuchStudentException extends Exception {
    public NoSuchStudentException () {
        super("The student does not exist.");
    }
}
