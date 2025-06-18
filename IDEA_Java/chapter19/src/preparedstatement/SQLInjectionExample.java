package preparedstatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class SQLInjectionExample {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");

        Connection connection = DriverManager.getConnection(url, user, password);

        // ”master key“: user name: 1' or, password: or '1' = '1
        // The only two users in the table are: tom, 123 and jay, 456
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter user name:");
        String username = scanner.nextLine();
        System.out.println("Please enter password:");
        String pwd = scanner.nextLine();

        String sql = "SELECT * FROM user WHERE username = '" + username +
                "' AND password = '" + pwd +"';";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
