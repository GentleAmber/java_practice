package balance_wis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class BalanceWis {
    public static void main(String[] args) {

        Account account = new Account();

        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        int command = 0;

        while(command != 5){
            menu.showMenu();
            command = scanner.nextInt();

            switch (command){
                case 1:
                    account.showTransDetails();
                    break;

                case 2://Register money in
                    System.out.println("Please type the money you put in:");
                    double add = scanner.nextDouble();
                    account.moneyIn(add,"Income");
                    break;

                case 3://Record money out
                    System.out.println("Please type the money out:");
                    double minus = scanner.nextDouble();
                    System.out.println("Please type in the details of this transaction:");
                    String details = scanner.next();
                    account.moneyOut(minus,details);
                    break;

                case 4://Show current balance
                    System.out.println("Current balance: " + account.getBalance());
                    break;

                case 5://Code iteration. Double check if exits
                    //Ideal: one piece of code only does one thing.

                    //This piece only determines if the confirmation loop is over.
                    char exit;
                    while(true){
                        System.out.println("Are you sure you want to exit? (y/n)");
                        exit = scanner.next().charAt(0);
                        if (exit == 'y' || exit == 'n' || exit == 'Y' || exit == 'N') {
                            break;
                        } else {
                            System.out.println("Wrong input. Please type in again.");
                        }
                    }

                    if (exit == 'N' || exit == 'n'){
                        command = 0;//If the user doesn't want to exit, reset the command to 0
                        //so that the while loop continues
                        //else, does nothing and the while loop will automatically end because of the
                        //while judge.
                    }
                    break;
                default:
                    System.out.println("Wrong input. Please select again.");
            }
        }

        System.out.println("Exit successfully. Welcome back.");

    }
}

class Transactions{
    private double currentBalance;
    private String time;
    private double diff;
    private String details;

    public Transactions(double currentBalance, String time, double diff, String details) {
        setCurrentBalance(currentBalance);
        setTime(time);
        setDiff(diff);
        setDetails(details);
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}


class Account{
    private double balance;
    private Transactions[] transactions = new Transactions[300];
    private int index;

    public void moneyIn(double add, String details){
        if (add > 0){
            this.balance += add;
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            transactions[index] = new Transactions(getBalance(),timeStamp,add,details);
            index++;
        } else {
            System.out.println("Wrong number. Amount of money in should be greater than 0.");
        }

    }

    public void moneyOut(double minus, String details){
        if (this.balance >= minus && minus > 0) {
            this.balance -= minus;
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            transactions[index] = new Transactions(getBalance(),timeStamp,-minus,details);
            index++;
        }else {
            System.out.println("Not enough balance or wrong number. Transaction failed.");
        }
    }

    public void showTransDetails(){
        if (index > 0) {
            System.out.println("-------------Transaction Details-------------");
            for (int i = 0; i < index; i++) {
                System.out.println(transactions[i].getDetails() + "  " + transactions[i].getDiff()
                        + "  " + transactions[i].getTime() + "   Balance: " + transactions[i].getCurrentBalance());
            }
        }else {
            System.out.println("No transaction yet.");
        }
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

}

class Menu{
    public void showMenu(){
        System.out.println("---------------Balance Wis Menu---------------");
        System.out.println("\t\t1 Transaction details");
        System.out.println("\t\t2 Register money in");
        System.out.println("\t\t3 Record money out");
        System.out.println("\t\t4 Current balance");
        System.out.println("\t\t5 Exit");
        System.out.println("Please select (1-5) :");
    }
}

