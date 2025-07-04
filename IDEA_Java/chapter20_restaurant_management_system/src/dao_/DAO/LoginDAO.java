package dao_.DAO;

import java.sql.SQLException;

public class LoginDAO extends BasicDAO{
    public static int updateLogin(String niNumber, String account, String password, String ifAdminInput, boolean ifAdminBit) throws SQLException {
        if (account == null && password == null && ifAdminInput == null) {
            return 0;
        } else {

            String updateQuery = "UPDATE login SET ";

            if (account != null) {
                String accountUpdateQuery = updateQuery + "account = ? WHERE nINumber = ?;";
                update(accountUpdateQuery, account, niNumber);
            }

            if (password != null) {
                String passwordUpdateQuery = updateQuery + "password = MD5(?) WHERE nINumber = ?;";
                update(passwordUpdateQuery, password, niNumber);
            }

            if (ifAdminInput != null) {
                String ifAdminUpdateQuery = updateQuery + "ifAdmin = ? WHERE nINumber = ?;";
                update(ifAdminUpdateQuery, ifAdminBit, niNumber);
            }

            return 1;
        }
    }
}
