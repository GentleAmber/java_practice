package service;

import dao_.DAO.BasicDAO;
import domain.MenuRow;
import org.junit.Test;
import utils.IOUtils;

import java.sql.SQLException;

public class MenuService extends BasicService {

    public int addDish() {
        System.out.println("Please enter the following fields for the new dish. For optional" +
                "fields you can just press enter without typing anything.");

        System.out.print("Dish name: ");
        String dishName = IOUtils.takeStringWithExitCheck(64, false);
        System.out.print("Price: ");
        float v = IOUtils.takePositiveFloat(false);
        System.out.print("OPTIONAL: description: ");
        String desc = IOUtils.takeStringWithExitCheck(true);
        System.out.print("Type: Choose among below");
        System.out.println("1. Hot meals, 2. Cold meals, 3. Appetisers, 4. Vegetables, 5. Drinks");
        char typeChoice = IOUtils.takeCharacter(false, '1', '2', '3', '4', '5');
        String type;
        switch (typeChoice) {
            case '1':
                type = "Hot meals";
                break;
            case '2':
                type = "Cold meals";
                break;
            case '3':
                type = "Appetisers";
                break;
            case '4':
                type = "Vegetables";
                break;
            case '5':
                type = "Drinks";
                break;
            default:
                type = null;
        }

        String sql = "INSERT INTO menu VALUES (null,?,?,?,?);";
        try {
            return BasicDAO.update(sql, dishName, v, desc, type);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Test
    public int deleteDish() {
        System.out.print("Please enter the name of the dish you want to delete: ");
        String dishName = IOUtils.takeStringWithExitCheck(64, false);

        String checkDishQuery = "SELECT dish_no FROM menu WHERE dish_name = ?";

        Object o = null;
        try {
            o = BasicDAO.queryScalar(checkDishQuery, dishName);
        } catch (SQLException throwables) {
            return -1;
        }

        if (o == null) {
            return -2;
        } else {
            String delete = "DELETE FROM menu WHERE dish_no = ?";
            try {
                return BasicDAO.update(delete, o);
            } catch (SQLException throwables) {
                return -3;// If a dish already appears in other tables like order_item, it
                // cannot be deleted. Shouldn't use foreign key constraint on this.
            }
        }
    }

    public int modifyDish() throws SQLException {
        System.out.print("Please enter the name of the dish you want to modify: ");
        String dishName = IOUtils.takeStringWithExitCheck(64, false);

        String checkDishQuery = "SELECT dish_no FROM menu WHERE dish_name = ?";

        Object o = null;
        try {
            o = BasicDAO.queryScalar(checkDishQuery, dishName);
        } catch (SQLException throwables) {
            return -1;
        }

        if (o == null)
            return -2;

        System.out.println("Please enter the new details for this dish. You can press enter without\n typing if" +
                " a field doesn't need change.");

        System.out.print("Price: ");
        float v = IOUtils.takePositiveFloat(true);
        System.out.print("Description: ");
        String desc = IOUtils.takeStringWithExitCheck(true);
        System.out.print("Type: Choose among below");
        System.out.println("1. Hot meals, 2. Cold meals, 3. Appetisers, 4. Vegetables, 5. Drinks");
        char typeChoice = IOUtils.takeCharacter(true, '1', '2', '3', '4', '5');
        String type;
        switch (typeChoice) {
            case 1:
                type = "Hot meals";
                break;
            case 2:
                type = "Cold meals";
                break;
            case 3:
                type = "Appetisers";
                break;
            case 4:
                type = "Vegetables";
                break;
            case 5:
                type = "Drinks";
                break;
            default:
                type = null;
        }

        if (v != -1) {
            String sql = "UPDATE menu SET price = ? WHERE dish_no = ?";
            BasicDAO.update(sql, v, o);
        }

        if (desc != null) {
            String sql = "UPDATE menu SET description = ? WHERE dish_no = ?";
            BasicDAO.update(sql, desc, o);
        }

        if (type != null) {
            String sql = "UPDATE menu SET type = ? WHERE dish_no = ?";
            BasicDAO.update(sql, type, o);
        }

        return 1;
    }

    public boolean showMenu() {
        return displayTheList("menu", MenuRow.class);
    }
}
