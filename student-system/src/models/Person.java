package models;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    protected abstract void showInfo();
}
