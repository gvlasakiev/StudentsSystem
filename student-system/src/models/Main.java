package models;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Parent parent = new Parent("Lyudmil", "Zahariev",
                "089407513", "lyuk63@abv.bg");
        StudentClass studentClass  = new StudentClass("11B");
        Student student = new Student("Samuil", "Zahariev", "0876582825",
                "samuilzahariev96@gmail.com", "9608173911", 20, parent, studentClass);



    }
}
