package service;

import dao_.DAO.BasicDAO;
import org.testng.annotations.Test;
import utils.IOUtils;
import utils.MySQLUtils;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OrderService extends BasicService{

    @Test
    public int takeOrder() throws SQLException {
        /*
        Logic:
        1) the table status should be either 'r' or 'e' before taking order
        2) Add dishes to this order
        3) In the end, set the status to 'o', and print the order
         */

        System.out.print("Which table is making the order: ");
        int tableNo = IOUtils.takePositiveInt(false);

        String sql = "SELECT status FROM tables WHERE table_no = ?";
        String o = (String) BasicDAO.queryScalar(sql, tableNo);

        if ("o".equals(o)) {
            return -1; // This table is not valid to make order.
        } else {
            new MenuService().showMenu();
            System.out.println("Enter the dish numbers, divided by space. If ordered more than once," +
                    "just enter the number twice: ");
            String pattern = "[0-9 ]+";
            String dishes = IOUtils.takeInputMatchesPattern(pattern, false);

            String[] s = dishes.split(" ");

            if (s.length == 0) {
                return -2;// Invalid order with no dish.
            }

            int[] dishNosRaw = new int[s.length];

            for (int i = 0; i < s.length; i++) {
                dishNosRaw[i] = Integer.parseInt(s[i]);
                // Check if there's such a dish
                if (!MySQLUtils.ifExist("menu", "dish_no", tableNo)) {
                    return -3; // Dish doesn't exist.
                }
            }

            System.out.print("OPTIONAL: Customer name: ");
            String name = IOUtils.takeStringWithExitCheck(32, true);

            // First, get a connection with AutoCommit set to false, and set up a order record
            Connection connection = BasicDAO.getConnectionForTransaction();

            // for the right syntax to use near 'order VALUES(null, '2025-07-03 22:54:32.5', 3, null)' at line 
            String sql1 = "INSERT INTO `order` VALUES(null, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            Timestamp tS = new Timestamp(System.currentTimeMillis());
            preparedStatement.setTimestamp(1, tS);
            preparedStatement.setInt(2, tableNo);
            preparedStatement.setString(3, name);

            preparedStatement.executeUpdate();

            int id = -1;
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }

            // Get the order number
            /*
            String sql = "INSERT INTO orders (user_id, order_time) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setTimestamp(2, timestamp);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1); // 就是你插入的主键值
                System.out.println("Inserted order ID: " + generatedId);
            }
             */

            // Prepare to add ordered dishes
            String sql3 = "INSERT INTO order_item VALUES(?, ?, ?)";

            // Start sorting out the dishes
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int dishNo : dishNosRaw) {
                if (hashMap.containsKey(dishNo)) {
                    hashMap.put(dishNo, (hashMap.get(dishNo) + 1));
                } else {
                    hashMap.put(dishNo, 1);
                }
            }

            Object[][] objects = new Object[hashMap.size()][3];
            Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : entries) {
                objects[i][0] = id;
                // dish_no
                objects[i][1] = entry.getKey();
                // dish_num
                objects[i][2] = entry.getValue();
                i++;
            }

            // Add ordered dishes and commit together with the order record
            int i1 = BasicDAO.insertBatch(connection, false, sql3, objects);
            connection.commit();

            MySQLUtils.closeConnection(connection, null, preparedStatement);
        }

        return 1;
    }
}
