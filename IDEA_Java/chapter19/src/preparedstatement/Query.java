package preparedstatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class Query {
    @SuppressWarnings({"all"})
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");

        Connection connection = DriverManager.getConnection(url, user, password);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter user name:");
        String username = scanner.nextLine();
        System.out.println("Please enter password:");
        String pwd = scanner.nextLine();

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?;";
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, pwd);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " logged in.");
        } else {
            System.out.println("Failed");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
