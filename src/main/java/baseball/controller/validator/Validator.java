package baseball.controller.validator;

import java.util.regex.Pattern;

public class Validator {

    private static final String NUMBER_REGEXP = "^[1-9]*$";
    private static final String COMMAND_REGEXP = "^[1-2]*$";

    public static boolean checkCommandFormat(String command) {
        return command.length() == 1 && Pattern.matches(COMMAND_REGEXP, command);
    }

    public static boolean checkNumberFormat(String target) {
        return target.length() == 3 && Pattern.matches(NUMBER_REGEXP, target);
    }
}
