package service;

import dao_.DAO.BasicDAO;
import utils.IOUtils;

import java.sql.Date;
import java.sql.SQLException;

public class Employee_infoService extends BasicService {

    public int addEmployee() {
        System.out.println("Enter the fields for the new employee. For optional fields,\n" +
                "you can press enter if no input.");

        System.out.print("Name: ");
        String name = IOUtils.takeFullName(32, false);
        System.out.print("NI Number: ");
        String niNum = IOUtils.takeNiNumber(6, false);
        System.out.print("Birthday (YYYY-MM-DD): ");
        Date birthday = IOUtils.takeDate(false);
        System.out.print("Hire Date (YYYY-MM-DD): ");
        Date hiredate = IOUtils.takeDate(false);
        System.out.print("OPTIONAL: Quit Date (YYYY-MM-DD): ");
        Date quitdate = IOUtils.takeDate(true);
        System.out.print("OPTIONAL: Tel: ");
        String tel = IOUtils.takeNumericalString(10, true);
        System.out.print("OPTIONAL: Address (less than 64 characters): ");
        // address example1 : 39/2 New Paul's Road, London, ET3 2TY
        // address example1 : 11 St Jame's Farm, Aberdeen, EJ0 14TX

        String pattern = "^[0-9]+.+[,]\\s[a-zA-Z]{2}[0-9]{1,2}\\s[0-9]{1,2}[a-zA-Z]{2}$";
        String address= IOUtils.takeInputMatchesPattern(pattern, true, 64);

        System.out.print("Mail (less than 64 characters): ");
        // mail example1 : 243lasf@gmail.com
        // mail example2 : flaksjef12@163.com
        // mail example3 : flaksjef12@ed.ac.uk

        pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String mail = IOUtils.takeInputMatchesPattern(pattern, false, 64);

        System.out.print("Is this person a manager (y/n): ");
        char ifManager = IOUtils.takeCharacter(false, 'y', 'n', 'Y', 'N');
        boolean ifManagerBit = false;

        if (ifManager == 'y' || ifManager == 'Y')
            ifManagerBit = true;

        String sql = "INSERT INTO employee_info VALUES (?,?,?,?,?,?,?,?,?);";
        try {
            int update = BasicDAO.update(sql, name, niNum, birthday, hiredate, quitdate, tel, address, mail, ifManagerBit);
            return update;
        } catch (SQLException throwables) {
            return -1;
        }
    }

    public int deleteEmployee() {
        System.out.print("Please enter the NI number to delete: ");
        String ni1 = IOUtils.takeNiNumber(6,false);
        System.out.print("Please enter again to confirm: ");
        String ni2 = IOUtils.takeNiNumber(6,false);

        if (!ni1.equals(ni2)) {
            return -1;
        } else {
            String checkIfExists = "SELECT niNumber FROM employee_info WHERE niNumber = ?";
            String delete = "DELETE FROM employee_info WHERE niNumber = ?";
            try {
                Object o1 = BasicDAO.queryScalar(checkIfExists, ni1);
                if (o1 == null) {
                    return -2;
                } else {
                    int update = BasicDAO.update(delete, ni1);
                    return update;
                }
            } catch (SQLException throwables) {
                return -3;
            }
        }
    }

    public int modifyEmployee() throws SQLException {
        System.out.print("Please enter the NI number whose account you want to modify: ");
        String niToModify = IOUtils.takeNiNumber(6,false);
        String checkIfAccountExists = "SELECT niNumber FROM employee_info WHERE niNumber = ?";

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

            System.out.print("Name: ");
            String name = IOUtils.takeFullName(32, true);
            System.out.print("Birthday (YYYY-MM-DD): ");
            Date birthday = IOUtils.takeDate(true);
            System.out.print("Hire Date (YYYY-MM-DD): ");
            Date hiredate = IOUtils.takeDate(true);
            System.out.print("Quit Date (YYYY-MM-DD): ");
            Date quitdate = IOUtils.takeDate(true);
            System.out.print("Tel: ");
            String tel = IOUtils.takeNumericalString(10, true);
            System.out.print("Address (less than 64 characters): ");
            String pattern = "^[0-9]+.+[,]\\s[a-zA-Z]{2}[0-9]{1,2}\\s[0-9]{1,2}[a-zA-Z]{2}$";
            String address = IOUtils.takeInputMatchesPattern(pattern, true,64);
            System.out.print("Mail (less than 64 characters): ");
            pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            String mail = IOUtils.takeInputMatchesPattern(pattern, true);
            System.out.print("Is this person a manager (y/n): ");
            char[] acceptedChars = {'y', 'Y', 'n', 'N'};
            char ifManager = IOUtils.takeCharacter(true, acceptedChars);

            boolean ifManagerBit = false;
            if (ifManager == 'y' || ifManager == 'Y')
                ifManagerBit = true;

            // Start updating columns one by one
            if (name != null) {
                String sql = "UPDATE employee_info SET `name` = ? WHERE niNumber = ?";
                BasicDAO.update(sql, name, niToModify);
            }
            if (birthday != null) {
                String sql = "UPDATE employee_info SET birthday = ? WHERE niNumber = ?";
                BasicDAO.update(sql, birthday, niToModify);
            }
            if (hiredate != null) {
                String sql = "UPDATE employee_info SET hiredate = ? WHERE niNumber = ?";
                BasicDAO.update(sql, hiredate, niToModify);
            }
            if (quitdate != null) {
                String sql = "UPDATE employee_info SET quitdate = ? WHERE niNumber = ?";
                BasicDAO.update(sql, quitdate, niToModify);
            }
            if (tel != null) {
                String sql = "UPDATE employee_info SET emp_tel = ? WHERE niNumber = ?";
                BasicDAO.update(sql, tel, niToModify);
            }
            if (address != null) {
                String sql = "UPDATE employee_info SET emp_address = ? WHERE niNumber = ?";
                BasicDAO.update(sql, address, niToModify);
            }
            if (mail != null) {
                String sql = "UPDATE employee_info SET emp_mail = ? WHERE niNumber = ?";
                BasicDAO.update(sql, mail, niToModify);
            }
            if (ifManager != ' ') {
                String sql = "UPDATE employee_info SET isManager = ? WHERE niNumber = ?";
                BasicDAO.update(sql, ifManagerBit, niToModify);
            }
            return 1;
        }
    }
}
