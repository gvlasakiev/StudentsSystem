package models;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Parent parent = new Parent("Lyudmil", "Zahariev",
                "089407513", "lyuk63@abv.bg");
        StudentClass elevenB  = new StudentClass("11B");
        Student samuil = new Student("Samuil", "Zahariev", "0876582825",
                "samuilzahariev96@gmail.com", "9608173911", 20, parent, elevenB);

        StudentClass sixA  = new StudentClass("6A");
        Student joro = new Student("Jorkata", "Jorev", "0899645128",
                "jorkata@gmail.com", "9601243264", 5, parent, sixA);

        Teacher teacher = new Teacher("Maya", "Zhecheva", "0859861432",
                "mzhecheva@gmail.com");

        teacher.getListOfClasses().add(elevenB);
        Parent peshoParent = new Parent("Grigor", "Ivanov",
                "0894752165", "grigori@mail.bg");
        Student pesho =  new Student("Pesho", "Peshov", "0885571264",
                "peshov@abv.bg", "9611043115", 14, peshoParent, elevenB);

        // Print all students in specific student class that Teacher has
        for (StudentClass currentClass : teacher.getListOfClasses()) {
            System.out.println(currentClass.getName());
            for (Student currentStudent : currentClass.getStudents()) {
                System.out.println(currentStudent.getFirstName());
            }
        }

        System.out.println("-----------------------");

        // Print all children for specific parent
        for (Student child : parent.getChildren()) {
            System.out.printf("%s %s in %s class with %s egn\n",
                    child.getFirstName(), child.getLastName(), child.getStudentClass().getName(), child.getEgn());
        }

        System.out.println("\n-----------------------");

        // Send invitation to all parent in elevenB student class.
        teacher.sendInvitation(elevenB);

        // Print all unread notifications for all student parents in specific student class
        for (Student currentStudent : elevenB.getStudents()) {
            Parent currentParent = currentStudent.getParent();

            for (String notification : currentParent.getUnreadNotification()) {
                System.out.println(notification);
            }
        }




    }
}
