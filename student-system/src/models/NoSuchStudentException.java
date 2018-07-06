package models;

class NoSuchStudentException extends Exception {
    NoSuchStudentException() {
        super("The student does not exist.");
    }
}
