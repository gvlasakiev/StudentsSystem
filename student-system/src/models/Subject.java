package models;

public enum Subject {
    HISTORY, MATH, LITERATURE, CHEMISTRY, ECONOMY, ART, MUSIC, GEOGRAPHY;


    /*
     Return enum with only first capital letter
     Example: HISTORY -> History
      */
    @Override
    public String toString() {
        String lower = super.name().toLowerCase().substring(1);
        return super.name().charAt(0) + lower;
    }
}
