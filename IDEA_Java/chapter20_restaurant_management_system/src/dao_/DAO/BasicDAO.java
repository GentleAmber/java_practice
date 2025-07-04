package dao_.DAO;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import utils.IOUtils;
import utils.MySQLUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.*;
import java.util.List;

public class BasicDAO {
    private static ComboPooledDataSource comboPooledDataSource;

    static {
        comboPooledDataSource = new ComboPooledDataSource("restaurant_system");
    }

    public static String[] getColumns(String sql) throws SQLException {
        Connection connection = comboPooledDataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        String[] strings = new String[columnCount];

        for (int i = 0; i < columnCount; i++) {
            strings[i] = metaData.getColumnName(i + 1);
        }

        MySQLUtils.closeConnection(connection, null, null);

        return strings;

    }

    public static <T> List<T> queryRows(String sql, Class<T> clazz, Object... params) throws SQLException {
        Connection connection = comboPooledDataSource.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        List<T> query = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), params);

        MySQLUtils.closeConnection(connection, null, null);

        return query;
    }



    public static <T> T queryARow(String sql, Class<T> clazz, Object... params) throws SQLException {
        Connection connection = comboPooledDataSource.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        T query = queryRunner.query(connection, sql, new BeanHandler<>(clazz), params);

        MySQLUtils.closeConnection(connection, null, null);

        return query;
    }

    public static Object queryScalar(String sql, Object... params) throws SQLException {
        Connection connection = comboPooledDataSource.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        Object query = queryRunner.query(connection, sql, new ScalarHandler<>(), params);

        MySQLUtils.closeConnection(connection, null, null);

        return query;
    }

//    public static Object queryScalar(Connection conn, boolean ifCloseConn, String sql, Object... params) throws SQLException {
//        QueryRunner queryRunner = new QueryRunner();
//
//        Object query = queryRunner.query(conn, sql, new ScalarHandler<>(), params);
//
//        if (ifCloseConn) {
//            MySQLUtils.closeConnection(conn, null, null);
//        }
//
//        return query;
//    }

    /**
     * Execute both DDL and DML statements with preparedStatement.
     * @return number of rows influenced.
     */
    public static int update(String sql, Object... params) throws SQLException {
        Connection connection = comboPooledDataSource.getConnection();
        return update(connection, true, sql, params);
    }

    public static int update(Connection conn, boolean ifCloseConn, String sql, Object... params) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();

        int rows = queryRunner.update(conn, sql, params);

        if (ifCloseConn) {
            MySQLUtils.closeConnection(conn, null, null);
        }
        return rows;
    }

    /**
     * sql[] takes all the queries, paraNum records the number of parameters for each sql,
     * and parameters take overall parameters. Inside this function, parameters and their according sqls
     * will be sorted out, and be queried together within one transaction.
     * @param sql Sql queries with parameters being placeholder "?"
     * @param paraNum Number of parameters for each sql query
     * @param parameters Overall parameters for all the sql queries, put in order
     * @return -2 when there's inconsistency within arguments.
     * @throws SQLException
     */
    public static int executeTransaction(String[] sql, int[] paraNum, Object[] parameters) throws SQLException {
        // Consistency check
        if (sql.length != paraNum.length) {
            return -2;
        }

        int sum = 0;
        for (int i : paraNum) {
            sum += i;
        }

        if (sum != parameters.length) {
            return -2;
        }

        Connection connection = comboPooledDataSource.getConnection();
        connection.setAutoCommit(false);
        QueryRunner queryRunner = new QueryRunner();

        int countQuery = 0;
        int i, k;
        int index = 0;

        // For every sql query, extract its number of parameters, and fetch the paras from
        // Object[] parameters
        for (i = 0; i < sql.length; i++) {

            Object[] paras = new Object[paraNum[i]];
            int parasI;

            if (paraNum[i] != 0) {
                for (k = index, parasI = 0; k < paraNum[i] + index; k++, parasI++) { // k == 2 if first paraNum = 2, after this for loop
                    paras[parasI] = parameters[k];
                }
                queryRunner.update(connection, sql[i], paras);
            } else {
                queryRunner.update(connection, sql[i]);
            }

            countQuery++;
            index += paraNum[i];
        }

        connection.commit();

        MySQLUtils.closeConnection(connection, null, null);

        return countQuery;
    }



    /**
     * Used for insert query with multiple parameters. Every array in params represents
     * a complete row for insert sentence, so it can be a mix-up of different data types.
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static int insertBatch(Connection conn, boolean ifCloseConn, String sql, Object[]... params) throws SQLException {
        // Inconsistency check
        int length = params[0].length;

        if (length == 0) {
            return -1;
        }

        for (int i = 0; i < params.length; i++) {
            if (params[i].length != length)
                return -1;
        }

        PreparedStatement statement = conn.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            for (int j = 0; j < params[i].length; j++) {
                statement.setObject(j + 1, params[i][j]);
            }
            statement.addBatch();
        }

        statement.executeBatch();

        if (ifCloseConn) {
            MySQLUtils.closeConnection(conn, null, statement);
        } else {
            MySQLUtils.closeConnection(null, null, statement);
        }

        return params.length;
    }

    public static int insertBatch(String sql, Object[]... params) throws SQLException {
        Connection connection = comboPooledDataSource.getConnection();
        return insertBatch(connection, true, sql, params);
    }

    /**
     * This function is used for batch execution & transaction. The transaction may be closed in
     * the function or after executing other queries beyond this function.
     * @param conn
     * @param ifCloseConn
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */

    public static int insertBatch(Connection conn, boolean ifCloseConn, String sql, Object... params) throws SQLException {
        // Inconsistency check
        int length = params.length;

        if (length == 0) {
            return -1;
        }

        PreparedStatement statement = conn.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
            statement.addBatch();
        }

        statement.executeBatch();

        if (ifCloseConn) {
            MySQLUtils.closeConnection(conn, null, statement);
        } else {
            MySQLUtils.closeConnection(null, null, statement);
        }

        return params.length;
    }

    public static int insertBatch(String sql, Object... params) throws SQLException {
        Connection connection = comboPooledDataSource.getConnection();
        return insertBatch(connection, true, sql, params);
    }



    public static Connection getConnectionForTransaction() throws SQLException {
        Connection connection = comboPooledDataSource.getConnection();
        connection.setAutoCommit(false);

        return connection;
    }

}
