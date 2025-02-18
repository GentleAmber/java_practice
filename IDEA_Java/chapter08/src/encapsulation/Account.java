package encapsulation;

public class Account {
    private String name;
    private String password;
    private double balance;

    public Account(String name, String password, double balance) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6)
            this.password = password;
        else{
            System.out.println("Password should be 6 digits. Default password 000000 is set.");
            this.password = "000000";
        }

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance >= 0)
            this.balance = balance;
        else{
            System.out.println("Balance should be >= 0. Default value 0 is set.");
            this.balance = 0;
        }
    }

    public void showInfo(){
        System.out.println("Name: " + name + "\tBalance: " + balance + "\tPassword: " + password);
    }
}
