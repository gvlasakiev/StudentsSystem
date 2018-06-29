package models;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Parent newParent = new Parent("Ivan", "Ivanov","0888441122", "ivan_petrov@gmail.com");
        StudentClass studentClass  = new StudentClass("2A");
        Student student = new Student("Pesho", "Petrov", "0888550033","ivan_petrov@gmail.com", "7701020570", 4, newParent, studentClass);

        Teacher newTeacher = new Teacher("Kiril", "Ivanov", "0899124355", "kiril@gmail.com");

        newTeacher.showInfo();

    }
}
