package models;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Parent extends Person {

    private List<Student> children;
    private List<String> readNotifications;
    private Deque<String> unreadNotification;

    public List<String> getReadNotifications() {
        return readNotifications;
    }

    public void setReadNotifications(List<String> readNotifications) {
        this.readNotifications = readNotifications;
    }

    Deque<String> getUnreadNotification() {
        return unreadNotification;
    }

    public void setUnreadNotification(Deque<String> unreadNotification) {
        this.unreadNotification = unreadNotification;
    }

    Parent(String firstName, String lastName, String phoneNumber) {
        this(firstName, lastName, phoneNumber, "");
    }

    Parent(String firstName, String lastName, String phoneName, String email) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setPhoneNumber(phoneName);
        super.setEmail(email);
        children = new ArrayList<>();
        readNotifications = new ArrayList<>();
        unreadNotification = new ArrayDeque<>();
    }

    @Override
    protected void showInfo() {
        System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
        System.out.printf("Phone number: %s\n", super.getPhoneNumber());
        System.out.printf("Email: %s", super.getEmail());
    }

    public void showStudentInfo(Student student) {
        System.out.println(student.toString());
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
        for (String notification : unreadNotification) {
            System.out.println(notification);
        }
    }


    public List<Student> getChildren() {
        return children;
    }

    public void setChildren(List<Student> children) {
        this.children = children;
    }

    //public List<String> getNotifications() {
    //  return notifications;
    //}
}
