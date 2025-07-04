package view;

import dao_.DAO.BasicDAO;
import domain.ReservationRow;
import domain.TablesRow;
import service.*;
import domain.Employee_infoRow;
import domain.MenuRow;
import utils.IOUtils;

import java.sql.SQLException;

import org.testng.annotations.Test;

public class Menus {
    public void humanResourceManage() {
        char selection = ' ';
        Employee_infoService eIS = new Employee_infoService();

        while (selection != '5') {
            System.out.println("-----------------Human Resource Management-----------------");
            System.out.println("\t\t1 Check the employee list");
            System.out.println("\t\t2 Add employee");
            System.out.println("\t\t3 Delete employee");
            System.out.println("\t\t4 Modify employee information");
            System.out.println("\t\t5 Back to the previous menu");
            System.out.print("Please enter your selection: ");

            selection = IOUtils.takeCharacter();

            switch (selection) {
                case '1':
                    if (!eIS.displayTheList("employee_info", Employee_infoRow.class))
                        IOUtils.printError("SQL query error.");
                    break;

                case '2':
                    if (eIS.addEmployee() == -1) {
                        IOUtils.printError("SQL query error.");
                    } else {
                        System.out.println("Employee is added.");
                    }
                    break;

                case '3':
                    switch (eIS.deleteEmployee()) {
                        case -1:
                            IOUtils.printError("Inputs aren't the same.");
                            break;
                        case -2:
                            IOUtils.printError("Employee doesn't exist.");
                            break;
                        case -3:
                            IOUtils.printError("SQL query error.");
                            break;
                        default:
                            System.out.println("Employee is deleted.");
                    }

                    break;

                case '4':
                    try {
                        int i = eIS.modifyEmployee();

                        if (i == -1) {
                            IOUtils.printError("SQL query error.");
                        } else if (i == -2) {
                            IOUtils.printError("Employee doesn't exist.");
                        } else {
                            System.out.println("Employee is modified.");
                        }
                    } catch (SQLException throwables) {
                        IOUtils.printError("SQL query error.");
                    }

                    break;

                case '5':
                    break;

                default:
                    System.out.println("Wrong input. Please enter again.");

            }
        }
    }

    public void loginManage() {
        String adminNumQuery = "SELECT count(ifAdmin) FROM login WHERE ifAdmin = 1";
        String userNumQuery = "SELECT count(ifAdmin) FROM login WHERE ifAdmin = 0";

        char selection = ' ';
        LoginService lS = new LoginService();

        while (selection != '5') {
            long adminNum = 0L;
            long userNum = 0L;
            boolean showNum = true;

            try {
                adminNum = (long) BasicDAO.queryScalar(adminNumQuery);
                userNum = (long) BasicDAO.queryScalar(userNumQuery);
            } catch (SQLException throwables) {
                showNum = false;
            }

            if (adminNum < 0 || userNum < 0) {
                IOUtils.printError("Unknown error. Programme crashes.");
                System.exit(0);
            }

            System.out.println("-----------------Login Management-----------------");
            if (showNum)
                System.out.println("Currently there are " + adminNum + " admins, " + userNum + " users in the system.");
            System.out.println("\t\t1 Check the account list");
            System.out.println("\t\t2 Add account");
            System.out.println("\t\t3 Delete account");
            System.out.println("\t\t4 Modify account");
            System.out.println("\t\t5 Back to the previous menu");
            System.out.print("Please enter your selection: ");


            selection = IOUtils.takeCharacter();

            switch (selection) {
                case '1':
                    if (!lS.displayLogin()) {
                        IOUtils.printError("SQL query error.");
                    }
                    break;

                case '2':
                    switch(lS.addLogin()) {
                        case -1:
                            IOUtils.printError("SQL query error.");
                            break;
                        case -2:
                            IOUtils.printError("Employee doesn't exist.");
                            break;
                        case -3:
                            IOUtils.printError("Account already exists.");
                            break;
                        case -4:
                            IOUtils.printError("Inputs aren't the same.");
                            break;
                        default:
                            System.out.println("Account is added.");
                    }
                    break;

                case '3':
                    switch(lS.deleteLogin()) {
                        case -1:
                            IOUtils.printError("Inputs aren't the same.");
                            break;
                        case -2:
                            IOUtils.printError("Account doesn't exist.");
                            break;
                        case -3:
                            IOUtils.printError("SQL query error.");
                            break;
                        default:
                            System.out.println("Account is deleted.");
                    }
                    break;

                case '4':
                    switch(lS.modifyLogin()) {
                        case -1:
                            IOUtils.printError("SQL query error.");
                            break;
                        case -2:
                            IOUtils.printError("Account doesn't exist.");
                            break;
                        case -3:
                            IOUtils.printError("Inputs aren't the same.");
                            break;
                        case -4:
                            IOUtils.printError("SQL query error.");
                            break;
                        default:
                            System.out.println("Account is modified.");
                    }
                    break;

                case '5':
                    break;

                default:
                    System.out.println("Wrong input. Please enter again.");
            }
        }
    }

    public void statistics() {

    }

    public void costControl() {

    }

    public void modifyRestaurantMenu() {
        MenuService mS = new MenuService();
        char selection = ' ';

        while (selection != '5') {
            System.out.println("-----------------Menu Management-----------------");
            System.out.println("\t\t1 Check the menu");
            System.out.println("\t\t2 Add a dish");
            System.out.println("\t\t3 Delete a dish");
            System.out.println("\t\t4 Modify a dish");
            System.out.println("\t\t5 Back to the previous menu");
            System.out.print("Please enter your selection: ");

            selection = IOUtils.takeCharacter();

            switch (selection) {
                case '1':
                    mS.displayTheList("menu", MenuRow.class);
                    break;

                case '2':
                    if (mS.addDish() == -1) {
                        IOUtils.printError("SQL query error.");
                    } else {
                        System.out.println("Dish is added.");
                    }
                    break;

                case '3':
                    switch (mS.deleteDish()) {
                        case -2:
                            IOUtils.printError("Dish doesn't exist.");
                            break;
                        case -1:
                        case -3:
                            IOUtils.printError("SQL query error.");
                            break;
                        default:
                            System.out.println("Dish is deleted.");
                    }
                    break;

                case '4':
                    try {
                        switch (mS.modifyDish()) {
                            case -1:
                                IOUtils.printError("SQL query error.");
                                break;
                            case -2:
                                IOUtils.printError("Dish doesn't exist.");
                                break;
                            default:
                                System.out.println("Dish is modified.");
                        }
                    } catch (SQLException throwables) {
                        IOUtils.printError("SQL query error.");
                    }
                    break;

                case '5':
                    break;

                default:
                    System.out.println("Wrong input. Please enter again.");

            }
        }
    }

    @Test
    public void showTable() {
        ReservationService tS = new ReservationService();
        if (!tS.displayTheList("tables", TablesRow.class)) {
            IOUtils.printError("SQL query error.");
        }
    }

    @Test
    public void reserve() {
        ReservationService tS = new ReservationService();

        switch (tS.addReservation()) {
            case -1:
                IOUtils.printError("SQL query error.");
                break;
            case -2:
                IOUtils.printError("System error. Inconsistency with arguments.");
                break;
            case -3:
                IOUtils.printError("Table is not available.");
                break;
            default:
                System.out.println("Reservation is made.");
        }
    }

    @Test
    public void showReservations() {
        ReservationService tS = new ReservationService();
        if (!tS.displayTheList("reservation", ReservationRow.class)) {
            IOUtils.printError("SQL query error.");
        }

    }

    public void takeOrder() {
        try {
            switch (new OrderService().takeOrder()) {
                case -1:
                    IOUtils.printError("Table is occupied.");
                    break;
                case -2:
                    IOUtils.printError("Invalid order with no dish.");
                    break;
                case -3:
                    IOUtils.printError("Dish doesn't exist.");
                    break;
                default:
                    System.out.println("Order is taken.");
            }
        } catch (SQLException throwables) {
            IOUtils.printError("SQL query error.");
        }
    }

    public void showMenu() {
        ReservationService tS = new ReservationService();
        if (!tS.displayTheList("menu", MenuRow.class)) {
            IOUtils.printError("SQL query error.");
        }

    }

    public void checkOut() {

    }

//    public void adminMainMenu() {
//        System.out.println("===========Admin Management Interface===========");
//        System.out.println("\t\t1 Human Resource Management");
//        System.out.println("\t\t2 Login Account Management");
//        System.out.println("\t\t3 Modify Menu");
//        System.out.println("\t\t4 Statistics");
//        System.out.println("\t\t5 Cost Control");
//        System.out.println("\t\t6 System Setting");
//        System.out.println("\t\t7 System Help");
//        System.out.println("================================================");
//        System.out.print("Please enter your selection: ");
//    }
}
