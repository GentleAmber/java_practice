package domain;

public class Customer_infoRow {
    private String cus_no;
    private String customer_name;
    private String cus_tel;
    private String cus_mail;
    private short cust_vip_level;
    private double total_spending;

    public Customer_infoRow(String cus_no, String customer_name, String cus_tel, String cus_mail, short cust_vip_level, double total_spending) {
        this.cus_no = cus_no;
        this.customer_name = customer_name;
        this.cus_tel = cus_tel;
        this.cus_mail = cus_mail;
        this.cust_vip_level = cust_vip_level;
        this.total_spending = total_spending;
    }

    public Customer_infoRow() {
    }

    public String getCus_no() {
        return cus_no;
    }

    public void setCus_no(String cus_no) {
        this.cus_no = cus_no;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCus_tel() {
        return cus_tel;
    }

    public void setCus_tel(String cus_tel) {
        this.cus_tel = cus_tel;
    }

    public String getCus_mail() {
        return cus_mail;
    }

    public void setCus_mail(String cus_mail) {
        this.cus_mail = cus_mail;
    }

    public short getCust_vip_level() {
        return cust_vip_level;
    }

    public void setCust_vip_level(short cust_vip_level) {
        this.cust_vip_level = cust_vip_level;
    }

    public double getTotal_spending() {
        return total_spending;
    }

    public void setTotal_spending(double total_spending) {
        this.total_spending = total_spending;
    }
}
