package connection.connectionpool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0_ConfigConnect {
    public static void main(String[] args) throws SQLException {
        // a config xml document is put under src/
        ComboPooledDataSource wkxtest = new ComboPooledDataSource("wkxtest");
        Connection connection = wkxtest.getConnection();

        System.out.println(connection);
        connection.close();

    }
}
