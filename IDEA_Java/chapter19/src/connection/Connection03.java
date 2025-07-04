package connection;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connection03 {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/jdbc_db";

        Connection connect = DriverManager.getConnection(url, "root", "wkx");
        System.out.println(connect);

        connect.close();
    }
}
