package utils;

import dao_.DAO.BasicDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/**
 For every input, there should be at least a length check.
 */

public class IOUtils {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Core function in this class, used by other functions here. Will exit the programme
     * if the input is "exit". Default max length is 128, the longest char/varchar length
     * in the database. If the length exceeds the max length, the function will require the
     * input again until the length fits the requirement.
     * @return null if the input is empty and allowed to be, otherwise, return the input itself
     */
    public static String takeStringWithExitCheck(int maxLen, boolean allowEmptyInput) {

        while (true) {
            String input = scanner.nextLine();

            // When input is empty and allow empty input, return null.
            if (input.isEmpty() && allowEmptyInput) {
                return null;
                // When input is empty and doesn't allow empty input, require input again.
            } else if (input.isEmpty()) {
                printError("Input is empty!");
                System.out.print("Please enter again: ");
                // When input is not empty, accept the input and first do exit check.
                // If input is "exit", with spaces before or after, exit.
            } else if ("exit".equals(input.trim())) {
                System.exit(0);
                // Finally, check the input length.
            } else if (input.length() > maxLen) {
                printError("Input is too long!");
                System.out.print("Please enter again: ");
            } else
                return input;
        }
    }

    /**
     * When there's no max length argument, pass 128 as the default max length.
     * @return null if the input is empty, otherwise, return the input itself
     */

    public static String takeStringWithExitCheck(boolean allowEmptyInput) {
        return takeStringWithExitCheck(128, allowEmptyInput);
    }

    public static String takeStringWithExitCheck() {
        return takeStringWithExitCheck(128, false);
    }




    /**
     * Second important function in this class, verify if the input matches the passed {@code pattern}.
     * If it doesn't match, requrie the input again until it matches.
     * @param pattern accept regular expression.
     * @param allowEmptyInput By default it's false.
     * @param maxLength By default it's 128.
     * @return null if the input is empty/too long, otherwise, return the input which matches the given pattern.
     */
    public static String takeInputMatchesPattern(String pattern, boolean allowEmptyInput, int maxLength) {
        while (true) {
            String string = takeStringWithExitCheck(maxLength, allowEmptyInput);

            // If the input is empty and can be empty as checked in takeStringWithExitCheck(), return null.
            if (string == null) {
                return null;
                // When the input is not empty, verify if it matches the pattern.
            } else if (string.matches(pattern))
                return string;
                // If it doesn't require input again.
            else {
                printError("The input doesn't match the required pattern.");
                System.out.print("Please enter again: ");
            }
        }
    }

    public static String takeInputMatchesPattern(String pattern, boolean allowEmptyInput) {
        return takeInputMatchesPattern(pattern, allowEmptyInput, 128);
    }

    public static String takeInputMatchesPattern(String pattern) {
        return takeInputMatchesPattern(pattern, false, 128);
    }


    /**
     *
     * @param allowEmptyInput if it's true, the function will allow empty input.
     * @param acceptableChars if there is any acceptable characters and {@code allowEmptyInput} == false,
     *                        the function will only return one of the acceptable characters.
     * @return return ' ' when the input is empty and allowed to be, otherwise return one of the
     * acceptable characters.
     */
    public static char takeCharacter(boolean allowEmptyInput, char... acceptableChars) {
        String input = null;
        char c = ' ';

        while (true) {

            input = takeStringWithExitCheck(allowEmptyInput);

            if (input == null)
                return c;

            c = input.charAt(0);
            // If there's no acceptable characters, just return the input character.
            if (acceptableChars.length == 0) {
                return c;
                // Otherwise, only return the input character when it matches one of the accepted.
            } else {
                for (char ch : acceptableChars) {
                    if (ch == c)
                        return c;
                }
            }

            // If the programme still hasn't ended, then the input should but doesn't match
            // the acceptable characters. Require input again.
            printError("The input doesn't match the required pattern!");
            System.out.print("Please enter again: ");
        }
    }

    public static char takeCharacter() {
        return takeCharacter(false);
    }

    /**
     * Receive a string. Check its pattern matches "xxxx-xx-xx" first, and then pass it
     * to the {@code Date.valueOf()}. Return null or a Date object.
     * @param allowEmptyInput if it's true, the function will allow empty input.
     * @return return null when empty input is allowed and the input is empty.
     */
    public static Date takeDate(Boolean allowEmptyInput) {
        String datePattern = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";

        while (true) {
            String s = takeInputMatchesPattern(datePattern, allowEmptyInput); //returns either null or string

            if (s != null) {
                Date date = null;
                try {
                    date = Date.valueOf(s);
                    return date;
                } catch (DateTimeParseException e) {
                    System.out.print("Invalid date! Please enter again: ");
                }
            } else
                return null;
        }
    }



    public static String takeNumericalString(int exactLength, boolean allowEmptyInput) {

        String pattern = "^\\d{" + exactLength + "}$";

        return takeInputMatchesPattern(pattern, allowEmptyInput);
    }

    public static String takeFullName(int maxLength, boolean allowEmptyInput) {
        String namePattern = "^[A-Z][a-z]+( [A-Z][a-z]+)? [A-Z][a-z]+$";

        return takeInputMatchesPattern(namePattern, allowEmptyInput);
    }

    public static String takeNiNumber(int controlledLength, boolean allowEmptyInput) {
        String pattern = "^[a-zA-Z0-9]{" + controlledLength + "}$";

        return takeInputMatchesPattern(pattern, allowEmptyInput);
    }

    /**
     *
     * @param allowEmptyInput
     * @return -1 if the input is empty and is allowed to be. Otherwise, request input
     * until it is a proper float number and is not empty.
     */
    public static float takePositiveFloat(boolean allowEmptyInput) {
        String pattern = "^[0-9]+[.]?[0-9]+$";

        while (true) {
            String s = takeInputMatchesPattern(pattern, allowEmptyInput);

            if (s != null) {
                try {
                    return Float.parseFloat(s);
                } catch (Exception e) {
                    IOUtils.printError("Float parsing error.");
                    System.out.print("Please enter again: ");
                }
            } else if (allowEmptyInput) {
                return -1;
            } else {
                IOUtils.printError("Empty input.");
                System.out.print("Please enter again: ");
            }
        }
    }

    /**
     *
     * @param allowEmptyInput
     * @return -1 if the input is empty and is allowed to be. Otherwise, request input
     * until it is a proper int number and is not empty.
     */
    public static int takePositiveInt(boolean allowEmptyInput) {
        String pattern = "^[0-9]+$";

        while (true) {
            String s = takeInputMatchesPattern(pattern, allowEmptyInput);

            if (s != null) {
                try {
                    return Integer.parseInt(s);
                } catch (Exception e) {
                    IOUtils.printError("Integer parsing error.");
                    System.out.print("Please enter again: ");
                }
            } else if (allowEmptyInput) {
                return -1;
            } else {
                IOUtils.printError("Empty input.");
                System.out.print("Please enter again: ");
            }
        }
    }

    public static Timestamp takeTimeStamp(boolean allowEmptyInput) {
        while (true) {
            String datetimeStr = takeStringWithExitCheck();

            if (datetimeStr == null && allowEmptyInput)
                return null;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            LocalDateTime localDateTime = LocalDateTime.parse(datetimeStr, formatter);

            try {
                return Timestamp.valueOf(localDateTime);
            } catch (DateTimeParseException e) {
                IOUtils.printError("The input doesn't match the required pattern.");
                System.out.print("Please enter again: ");
            }
        }
    }

    /**
     * Print the passed columns as table title. Print error message and exit the function
     * if there is no column information.
     * @param columns the columns of any table.
     */
    public static void displayColumns(String[] columns) {
        if (columns == null || columns.length == 0) {
            printError("No column information.");
            return;
        }

        for (String column : columns) {
            System.out.print(column + "\t");
        }

        System.out.println();
    }

    public static <T> void displayResultList(List<T> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No record.");
            return;
        }

        for (T t : list) {
            System.out.println(t);
        }
    }

    public static void printError(String error) {
        String messageBody = "[ERROR]: ";
        messageBody += error;
        System.out.println(messageBody);
    }
}
