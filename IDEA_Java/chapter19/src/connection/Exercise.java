package connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Exercise {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");

        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        String create = "create table news (id int primary key, `name` varchar(200) not null," +
                " summary varchar(2000))";
        String insert = "insert into news values (1, 'At least 200 killed in Air India plane crash as one British passenger reportedly survives', null)," +
                "(2, 'Trustees fined more than £11,000 over near-drowning in leisure pool', null)," +
                "(3, 'NHS Grampian in U-turn over scrapping free nappies', null)," +
                "(4, 'Teen with learning disabilities made to pay college costs', null)," +
                "(5, 'Third time lucky for Walter Scott Prize winner Miller', null);";
        String update = "update news set summary = 'Amber Wang' where id = 3;";
        String delete = "delete from news where id = 4;";

        int a = statement.executeUpdate(create);
        System.out.println(a == 0 ? "Create: succeeded" : "Create: failed");
        int b = statement.executeUpdate(insert);
        System.out.println(b > 0 ? "Insert: succeeded" : "Insert: failed");
        int c = statement.executeUpdate(update);
        System.out.println(c == 1 ? "Update: succeeded" : "Update: failed");
        int d = statement.executeUpdate(delete);
        System.out.println(d == 1 ? "Delete: succeeded" : "Delete: failed");

        statement.close();
        connection.close();

    }
}
