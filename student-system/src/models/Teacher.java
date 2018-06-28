package models;

import java.util.ArrayList;


public class Teacher extends Person {
	
	private ArrayList<StudentClass> listOfClasses;
	private ArrayList<Subject> listOfSubjects;
	
	//private Map<StudentClass, Subject> listOfClasses;
	
	public Teacher(){
		super();
		listOfClasses = new ArrayList<>();
		listOfSubjects = new ArrayList<>();
	}
	
	@Override
	protected void showInfo() {
			System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
	        System.out.printf("Phone number: %s\n", super.getPhoneNumber());
	        System.out.printf("Email: %s\n", super.getEmail());
	        System.out.println("List of all classes: ");
	        
	        //Can use StreamingAPI -- >
	        for (StudentClass studentClass : listOfClasses) {
				System.out.println(studentClass);
			}
	        System.out.println("\nList of all subjects: ");
	        for (Subject subject : listOfSubjects) {
				System.out.println(subject);
			}
		

	}

	public ArrayList<StudentClass> getListOfClasses() {
		return listOfClasses;
	}

	public ArrayList<Subject> getListOfSubjects() {
		return listOfSubjects;
	}

}
