package baseball.controller.validator;

import java.util.regex.Pattern;

public class Validator {

    private static final String NUMBER_REGEXP = "^[1-9]*$";

    public static boolean isComposedOfNumber(String target) {
        return Pattern.matches(NUMBER_REGEXP, target);
    }

    public static boolean isThreeLetters(String inputNumber) {
        return inputNumber.length() == 3;
    }
}
