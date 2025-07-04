package domain;

import java.sql.Timestamp;

public class Single_transactionRow {
    private int tran_no;
    private int order_no;
    private float payment;
    private Timestamp tran_time;
    private String tran_method;
    private String cus_no;

    public Single_transactionRow() {
    }

    public int getTran_no() {
        return tran_no;
    }

    public void setTran_no(int tran_no) {
        this.tran_no = tran_no;
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public Timestamp getTran_time() {
        return tran_time;
    }

    public void setTran_time(Timestamp tran_time) {
        this.tran_time = tran_time;
    }

    public String getTran_method() {
        return tran_method;
    }

    public void setTran_method(String tran_method) {
        this.tran_method = tran_method;
    }

    public String getCus_no() {
        return cus_no;
    }

    public void setCus_no(String cus_no) {
        this.cus_no = cus_no;
    }

    public Single_transactionRow(int tran_no, int order_no, float payment, Timestamp tran_time, String tran_method, String cus_no) {
        this.tran_no = tran_no;
        this.order_no = order_no;
        this.payment = payment;
        this.tran_time = tran_time;
        this.tran_method = tran_method;
        this.cus_no = cus_no;
    }
}
