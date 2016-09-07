package zzpj.breathalyser.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidator {



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

}
