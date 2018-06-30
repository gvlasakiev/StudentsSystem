package models;

import java.util.regex.Pattern;

public abstract class Person {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;

	// constructor
	public Person(String firstName, String lastName, String phoneNumber, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setEmail(email);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		// Add Exception
		if (Pattern.matches("[A-Z][a-z-]{1,20}", firstName)) {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		// Add Exception
		if (Pattern.matches("[A-Z][a-z-]{1,20}", lastName)) {
			this.lastName = lastName;
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public abstract void showInfo();
}
