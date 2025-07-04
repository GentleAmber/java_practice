package service;

import dao_.DAO.BasicDAO;
import utils.IOUtils;

import java.sql.SQLException;
import java.sql.Timestamp;

public class ReservationService extends BasicService {
    public int addReservation() {
        System.out.print("Table number: ");
        int tableNo = IOUtils.takePositiveInt(false);
        String tableStatusCheck = "SELECT status FROM tables WHERE table_no = ?";
        String o = null;
        try {
            o = (String) BasicDAO.queryScalar(tableStatusCheck, tableNo);
        } catch (SQLException throwables) {
            return -1;
        }

        if (!"e".equals(o)) {
            return -3;
        }

        System.out.print("Customer name: ");
        String name = IOUtils.takeStringWithExitCheck(30, false);
        System.out.print("Optional: number of people: ");
        int numOfPpl = IOUtils.takePositiveInt(true);
        System.out.print("Arrival time (YYYY-MM-DD hh:mm): ");
        Timestamp timestamp = IOUtils.takeTimeStamp(false);
        System.out.print("Optional: notes ");
        String notes = IOUtils.takeStringWithExitCheck(64, true);

        String sql = "INSERT INTO reservation VALUES(null, ?, ?, ?, ?, ?);";
        String sqlTable = "UPDATE tables SET status = 'r' WHERE table_no = ?";

        String[] sqls = new String[2];
        sqls[0] = sql;
        sqls[1] = sqlTable;
        int [] sqlNums = new int[2];
        sqlNums[0] = 5;
        sqlNums[1] = 1;

        if (numOfPpl == -1) {
            try {
                Object[] parameters = new Object[6];
                parameters[0] = name;
                parameters[1] = tableNo;
                parameters[2] = null;
                parameters[3] = timestamp;
                parameters[4] = notes;
                parameters[5] = tableNo;
                return BasicDAO.executeTransaction(sqls, sqlNums, parameters);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return -1;
            }
        } else {
            try {
                Object[] parameters = new Object[6];
                parameters[0] = name;
                parameters[1] = tableNo;
                parameters[2] = numOfPpl;
                parameters[3] = timestamp;
                parameters[4] = notes;
                parameters[5] = tableNo;
                return BasicDAO.executeTransaction(sqls, sqlNums, parameters);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return -1;
            }
        }

    }
}
