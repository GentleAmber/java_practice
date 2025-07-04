package domain;


import java.sql.Date;

public class Cost_registrationRow {
    private int cost_no;
    private int stock_num;
    private float price_per_unit;
    private Date reg_date;

    public int getCost_no() {
        return cost_no;
    }

    public void setCost_no(int cost_no) {
        this.cost_no = cost_no;
    }

    public int getStock_num() {
        return stock_num;
    }

    public Cost_registrationRow() {
    }

    public void setStock_num(int stock_num) {
        this.stock_num = stock_num;
    }

    public float getPrice_per_unit() {
        return price_per_unit;
    }

    public void setPrice_per_unit(float price_per_unit) {
        this.price_per_unit = price_per_unit;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Cost_registrationRow(int cost_no, int stock_num, float price_per_unit, Date reg_date) {
        this.cost_no = cost_no;
        this.stock_num = stock_num;
        this.price_per_unit = price_per_unit;
        this.reg_date = reg_date;
    }
}
