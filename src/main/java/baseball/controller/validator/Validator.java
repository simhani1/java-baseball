package baseball.controller.validator;

import java.util.regex.Pattern;

public class Validator {

    private static final String NUMBER_REGEXP = "^[1-9]*$";

    public static boolean checkFormat(String target) {
        return Pattern.matches(NUMBER_REGEXP, target);
    }
}
