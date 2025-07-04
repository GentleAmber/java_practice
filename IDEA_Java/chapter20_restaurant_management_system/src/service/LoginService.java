package service;

import dao_.DAO.BasicDAO;
import dao_.DAO.LoginDAO;
import domain.LoginRow;
import utils.IOUtils;

import java.sql.SQLException;
 
public class LoginService extends BasicService {
/*
    private String account;
    private String password;
    private String nINumber;
    private boolean ifAdmin;
 */


    public int addLogin() {

        System.out.println("Please enter the NI Number of the employee you're setting this account for:");
        String niNumber = IOUtils.takeNiNumber(6, false);

        String queryEmployeeInfo = "SELECT niNumber From employee_info WHERE niNumber = ?";
        String queryLogin = "SELECT niNumber FROM login WHERE niNumber = ?";

        Object employee_info = null;
        Object login = null;

        try {
            employee_info = BasicDAO.queryScalar(queryEmployeeInfo, niNumber);
            login = BasicDAO.queryScalar(queryLogin, niNumber);
        } catch (SQLException throwables) {
            return -1;
        }

        if (employee_info == null) {
            return -2;
        } else if (login != null) {
            return -3;
        }
        else {
            System.out.print("Enter the account number for this account (4-digit number): ");
            String account = IOUtils.takeNumericalString(4, false);

            System.out.print("Enter the password for this account (less than 30 digits): ");
            String password = IOUtils.takeStringWithExitCheck(30, false);

            System.out.print("Enter the password again to confirm: ");
            String password2 = IOUtils.takeStringWithExitCheck(30, false);

            if (!password2.equals(password)) {
                return -4;
            }

            System.out.print("Is this account an administrator? (y/n) ");
            char ifAdmin = ' ';
            boolean ifAdminBit = false;
            while (true) {
                ifAdmin = IOUtils.takeCharacter();
                if (ifAdmin != 'y' && ifAdmin != 'Y' && ifAdmin != 'n' && ifAdmin != 'N') {
                    System.out.print("Wrong input. Please enter again: ");
                } else {
                    if (ifAdmin == 'Y' || ifAdmin == 'y')
                        ifAdminBit = true;

                    break;
                }
            }

            String insertLogin = "INSERT INTO login VALUES (?, ?, MD5(?), ?);";
            try {
                int row = BasicDAO.update(insertLogin, niNumber, account, password, ifAdminBit);
                return row;
            } catch (SQLException throwables) {
                return -1;
            }
        }
    }

    public boolean displayLogin() {
        return displayTheList("login", LoginRow.class, "niNumber", "account", "ifAdmin");
    }


    public int deleteLogin() {
        System.out.print("Please enter the account number to delete: ");
        String account = IOUtils.takeNumericalString(4,false);
        System.out.print("Please enter again to confirm: ");
        String account2 = IOUtils.takeNumericalString(4,false);

        if (!account.equals(account2)) {
            return -1;
        } else {
            String checkIfAccountExists = "SELECT account FROM login WHERE account = ?";
            String deleteFromLogin = "DELETE FROM login WHERE account = ?";
            try {
                Object o1 = BasicDAO.queryScalar(checkIfAccountExists, account);
                if (o1 == null) {
                    return -2;
                } else {
                    int update = BasicDAO.update(deleteFromLogin, account);
                    return update;
                }
            } catch (SQLException throwables) {
                return -3;
            }
        }
    }

    public int modifyLogin() {
        System.out.print("Please enter the niNumber whose account you want to modify: ");
        String niToModify = IOUtils.takeNiNumber(6,false);
        String checkIfAccountExists = "SELECT account FROM login WHERE niNumber = ?";

        Object o1 = null;
        try {
            o1 = BasicDAO.queryScalar(checkIfAccountExists, niToModify);
        } catch (SQLException throwables) {
            return -1;
        }

        if (o1 == null) {
            return -2;
        } else {
            System.out.println("Please enter the new details for this employee. You can press enter without\n typing if" +
                    " a field doesn't need change.");
            System.out.print("Enter the account number for this account (4-digit number, can be empty): ");
            String modifiesAccount = IOUtils.takeNumericalString(4, true);

            System.out.print("Enter the password for this account (less than 30 digits, no space or '\', can be empty): ");
            String password = IOUtils.takeStringWithExitCheck(30, true);

            if (password != null) {
                System.out.print("Enter the password again to confirm: ");
                String password2 = IOUtils.takeStringWithExitCheck(30, false);

                if (!password2.equals(password)) {
                    return -3;
                }
            }

            System.out.print("Is this account an administrator? (y/n, can be empty) ");
            String ifAdminInput = "";
            char ifAdmin = ' ';
            boolean ifAdminBit = false;
            while (true) {
                ifAdminInput = IOUtils.takeStringWithExitCheck();
                if (ifAdminInput != null) {
                    ifAdmin = ifAdminInput.charAt(0);
                    if (ifAdmin != 'y' && ifAdmin != 'Y' && ifAdmin != 'n' && ifAdmin != 'N') {
                        System.out.print("Wrong input. Please enter again: ");
                    } else {
                        if (ifAdmin == 'Y' || ifAdmin == 'y')
                            ifAdminBit = true;

                        break;
                    }
                }
            }

            int row = 0;

            try {
                row = LoginDAO.updateLogin(niToModify, modifiesAccount, password, ifAdminInput, ifAdminBit);
            } catch (SQLException throwables) {
                return -4;
            }

            return row;
        }
    }
}
