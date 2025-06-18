package preparedstatement;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DMLAndResultSet {
    @SuppressWarnings({"all"})
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");

        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "SELECT * FROM news";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData rsmeta = resultSet.getMetaData();
        int column = rsmeta.getColumnCount();

        for (int i = 1; i <= column; i++) {
            System.out.print(rsmeta.getColumnName(i) + "\t");
        }
        System.out.println();

        while (resultSet.next()) {
            for (int i = 1; i <= column; i++) {
                System.out.print(resultSet.getObject(i) + "\t");
            }
            System.out.println();
        }

        String sql2 = "UPDATE news SET summary = ? WHERE id = ?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setString(1, "Bullshit");
        preparedStatement2.setInt(2, 2);

        int i = preparedStatement2.executeUpdate();
        if (i > 0) {
            System.out.println("\n===========================");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                for (int j = 1; j <= column; j++) {
                    System.out.print(resultSet.getObject(j) + "\t");
                }
                System.out.println();
            }
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();


    }
}
