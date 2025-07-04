package domain;

import java.sql.Timestamp;

public class OrderRow {
    private int order_no;
    private Timestamp order_time;
    private int table_no;
    private String customer_name;

    public OrderRow() {
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public int getTable_no() {
        return table_no;
    }

    public void setTable_no(int table_no) {
        this.table_no = table_no;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public OrderRow(int order_no, Timestamp order_time, int table_no, String customer_name) {
        this.order_no = order_no;
        this.order_time = order_time;
        this.table_no = table_no;
        this.customer_name = customer_name;
    }
}
