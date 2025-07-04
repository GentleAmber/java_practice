package domain;

public class LoginRow {
    private String account;
    private String password;
    private String nINumber;
    private boolean ifAdmin;

    public LoginRow(String account, String password, String nINumber, boolean ifAdmin) {
        this.account = account;
        this.password = password;
        this.nINumber = nINumber;
        this.ifAdmin = ifAdmin;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public LoginRow() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getnINumber() {
        return nINumber;
    }

    public void setnINumber(String nINumber) {
        this.nINumber = nINumber;
    }

    public boolean isIfAdmin() {
        return ifAdmin;
    }

    public void setIfAdmin(boolean ifAdmin) {
        this.ifAdmin = ifAdmin;
    }

    @Override
    public String toString() {
        return nINumber + "\t\t" +account + "\t\t" + ifAdmin;
    }
}
