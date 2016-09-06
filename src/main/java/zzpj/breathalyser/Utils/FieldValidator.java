package zzpj.breathalyser.Utils;

public class FieldValidator {

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";

    public static boolean passordMatch(String password, String repeatedPassword) {

        return password.equals(repeatedPassword);
    }

    public static boolean isInt(String str) {
        return (str.lastIndexOf("-") == 0 && !str.equals("-0")) ? str.replace("-", "").matches(
                "[0-9]+") : str.matches("[0-9]+");
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDateTimeValid(String stringToCheck) {

        return stringToCheck.matches(DATETIME_FORMAT);
    }
}
