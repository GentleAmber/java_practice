package homework;

import java.util.Scanner;

public class Homework02_InfoVerification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("User name: ");
        String userName = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        try {
            infoVerify(userName, password, email);
            System.out.println("Registered!");
        } catch (UserNameException | PasswordLengthException | PasswordNumericException
                | EmailException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void infoVerify(String userName, String password, String email) {
        boolean ifPasswordNumeric = true;
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                ifPasswordNumeric = false;
            }
        }

        if (!(userName.length() >= 2 && userName.length() <= 4)) {
            throw new UserNameException("Length of user name is not legal!");
        }
        if (!(password.length() == 6)) {
            throw new PasswordLengthException("Length of password is not legal!");
        }
        if (!ifPasswordNumeric) {
            throw new PasswordNumericException("Password is not numeric!");
        }
        if (!(email.indexOf('@') != -1 && email.indexOf('.') != -1 && email.indexOf('@') < email.indexOf('.'))) {
            throw new EmailException("Wrong format of email!");
        }
//        if (!(userName.length() >= 2 && userName.length() <= 4 && password.length() == 6
//                && ifPasswordNumeric && email.indexOf('@') != -1 && email.indexOf('.') != -1 &&
//                email.indexOf('@') < email.indexOf('.') )) {
//            throw new RuntimeException("Wrong data. Please try again.");
//        }
    }
}

class UserNameException extends RuntimeException {
    public UserNameException(String message) {super(message);}
}

class PasswordLengthException extends RuntimeException {
    public PasswordLengthException(String message) {super(message);}
}

class PasswordNumericException extends RuntimeException {
    public PasswordNumericException(String message) {
        super(message);
    }
}

class EmailException extends RuntimeException {
    public EmailException(String message) {
        super(message);
    }
}