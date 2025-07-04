package connection;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Connection02 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/jdbc_db";

        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "wkx");

        Connection connect = driver.connect(url, info);
        System.out.println(connect);

        connect.close();

        // Can also use DriverManager to register Driver. It's easier to manager drivers
        // DriverManager.registerDriver(driver); -> This line can be deleted as when Driver is
        //  constructed, it has already been registers.
        // Connection connect = DriverManager.getConnection(url, user, password);

    }
}
