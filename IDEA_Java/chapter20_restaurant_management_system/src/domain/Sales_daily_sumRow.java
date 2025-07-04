package domain;


import java.sql.Date;

public class Sales_daily_sumRow {
    private int sum_no;
    private Date date;
    private float total_income;
    private float net_income;

    public Sales_daily_sumRow() {
    }

    public int getSum_no() {
        return sum_no;
    }

    public void setSum_no(int sum_no) {
        this.sum_no = sum_no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotal_income() {
        return total_income;
    }

    public void setTotal_income(float total_income) {
        this.total_income = total_income;
    }

    public float getNet_income() {
        return net_income;
    }

    public void setNet_income(float net_income) {
        this.net_income = net_income;
    }

    public Sales_daily_sumRow(int sum_no, Date date, float total_income, float net_income) {
        this.sum_no = sum_no;
        this.date = date;
        this.total_income = total_income;
        this.net_income = net_income;
    }
}
