package models;

import java.util.ArrayList;
import java.util.List;

public class Parent extends Person {
    private List<Student> children;
    private List<String> notifications;

    public Parent() {
        children = new ArrayList<>();
        notifications = new ArrayList<>();
    }

    @Override
    protected void showInfo() {
        System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
        System.out.printf("Phone number: %s\n", super.getPhoneNumber());
        System.out.printf("Email: %s", super.getEmail());
    }

    protected void showStudentInfo(Student student) {
        System.out.println(student.toString());
    }

    public List<Student> getChildren() {
        return children;
    }

    public void setChildren(List<Student> children) {
        this.children = children;
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
