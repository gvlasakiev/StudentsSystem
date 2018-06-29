package models;

import java.util.regex.Pattern;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    protected abstract void showInfo();

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        //Add Exception
        if (Pattern.matches("[A-Z][a-z-]{1,20}", firstName)) {
            this.firstName = firstName;
        }
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        //Add Exception
        if (Pattern.matches("[A-Z][a-z-]{1,20}", lastName)) {
            this.lastName = lastName;
        }
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }
}
