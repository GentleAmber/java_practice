package utils;

import dao_.DAO.BasicDAO;

import java.sql.*;

public class MySQLUtils {

    /**
    Pass null to the arguments when no such thing has been created for the query.
     */
    public static void closeConnection(Connection connection, ResultSet rs, PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }

        if (rs != null) {
            rs.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

    public static Object loginVerification(String account, String password) {
        // Accordance to the table structure
        if (account.length() > 4) {
            return null;
        }

        String sql = "SELECT ifAdmin FROM login WHERE account = ? AND password = MD5(?);";
        try {
            Object o = BasicDAO.queryScalar(sql, account, password);
            return o;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }


    public static Object ifExist(String tableName, String checkedColumnName, String returnColumnName, Object para) throws SQLException {
        String sql = "SELECT " + returnColumnName + " FROM " + tableName + " WHERE " + checkedColumnName + " =?";
        if (BasicDAO.queryScalar(sql, para) != null) {
            return true;
        }
        return false;
    }

    public static boolean ifExist(String tableName, String checkedColumnName, Object para) throws SQLException {
        String sql = "SELECT " + checkedColumnName + " FROM " + tableName + " WHERE " + checkedColumnName + " =?";
        if (BasicDAO.queryScalar(sql, para) != null) {
            return true;
        }
        return false;
    }

}
