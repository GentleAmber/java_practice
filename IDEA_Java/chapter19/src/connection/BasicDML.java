package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.mysql.jdbc.*;

public class BasicDML {
    public static void main(String[] args) throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/jdbc_db";

        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "wkx");

        Connection connect = driver.connect(url, info);

        String sql = "create table actor( id int, `name` varchar(32), birthday date);";
        Statement statement = connect.createStatement();
        int result = statement.executeUpdate(sql);

        System.out.print("Result of creating table: ");
        System.out.println(result == 0 ? "Success" : "Fail");

        if (result == 0) {
            String insert = "insert into actor values (1, 'Jay Chou', '1979-01-18');";
            int result2 = statement.executeUpdate(insert);

            System.out.print("Result of inserting value: ");
            System.out.println(result2 > 0 ? "Success" : "Fail");
        }

        statement.close();
        connect.close();

    }
}
