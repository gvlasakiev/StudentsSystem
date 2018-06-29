package models;

public class Main {

    public static void main(String[] args) {
        Person parent = new Parent("Lyudmil", "Zahariev",
                "+359889407513", "lyuk63@abv.bg");

        System.out.println(parent.getFirstName());
        System.out.println(parent.getLastName());
        System.out.println(parent.getEmail());
        System.out.println(parent.getPhoneNumber());
        for (String s : ((Parent) parent).getReadNotifications()) {

        }

    }
}
