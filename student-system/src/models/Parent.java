package models;

import java.util.*;

public class Parent extends Person {

    private List<Student> children;
    private List<String> readNotifications;
    private Deque<String> unreadNotification;

    Parent(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
        children = new ArrayList<>();
        readNotifications = new ArrayList<>();
        unreadNotification = new ArrayDeque<>();
    }

//    public List<String> getReadNotifications() {
//        return readNotifications;
//    }
//
//    public void setReadNotifications(List<String> readNotifications) {
//        this.readNotifications = readNotifications;
//    }

    Deque<String> getUnreadNotification() {
        return unreadNotification;
    }

//    public void setUnreadNotification(Deque<String> unreadNotification) {
//        this.unreadNotification = unreadNotification;
//    }

    @Override
    public void showInfo() {
        System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
        System.out.printf("Phone number: %s\n", super.getPhoneNumber());
        System.out.printf("Email: %s\n", super.getEmail());

        System.out.println("Student children:");

        for (Student child : children) {
            System.out.printf("-%s %s in student class %s.\n",
                    child.getFirstName(), child.getLastName(), child.getStudentClass().getName());
        }
    }

    public void showStudentInfo(Student student) {
        student.showAll();
    }

    public void excuseAbsences(Student student, int numberAbsences) {
        if(student.getUnvaccinatedAbsences() >= numberAbsences) {
            student.setExcusedAbsences(student.getExcusedAbsences()+numberAbsences);
            student.setUnvaccinatedAbsences(student.getUnvaccinatedAbsences()-numberAbsences);
            System.out.println("Current Unvaccinated Absences: "+student.getUnvaccinatedAbsences());
        } else {
            System.out.println("Exception 05");
        }
    }

    public void showUnreadNotifications() {
        // Exception?
        while (!unreadNotification.isEmpty()) {
            String currentNotification = unreadNotification.pop();
            System.out.println(currentNotification);
            readNotifications.add(currentNotification);
        }
    }

    public void showReadNotifications() {
        // Can use Stream API here

        // Print with Stream API
        unreadNotification.forEach(System.out::println);

        // Print without Stream API
//        for (String notification : unreadNotification) {
//            System.out.println(notification);
//        }
    }

    List<Student> getChildren() {
        return children;
    }

    public void setChildren(List<Student> children) {
        this.children = children;
    }

    //public List<String> getNotifications() {
    //  return notifications;
    //}


    // public List<String> getReadNotifications() {
    // return readNotifications;
    // }
    //

    // public List<String> getNotifications() {
    // return notifications;
    // }
}
