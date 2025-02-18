package encapsulation;

public class TestAccount {
    public static void main(String[] args) {
        Account jack = new Account("Jack", "830243", 900000);
        Account amanda = new Account("Amanda", "2349023", -5);

        jack.showInfo();
        amanda.showInfo();
    }
}
