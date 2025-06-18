package dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DBUtils_Use {

    @Test
    public void testQueryMany() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id >= ?";

        ResultSetHandler<List<Actor>> rsh = new BeanListHandler<>(Actor.class);
        List<Actor> actorList = queryRunner.query(connection, sql, rsh, 0);

        for (Actor a : actorList) {
            System.out.println(a);
        }

        // queryRunner.query() closes the resultSet and preparedStatement in it, so only have to
        // close the connection manually
        connection.close();
    }

}
