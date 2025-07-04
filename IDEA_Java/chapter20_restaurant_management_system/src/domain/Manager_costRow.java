package domain;


import java.sql.Date;

public class Manager_costRow {
    private String niNumber;
    private float cost_per_month;
    private Date valid_date;

    public Manager_costRow(String niNumber, float cost_per_month, Date valid_date) {
        this.niNumber = niNumber;
        this.cost_per_month = cost_per_month;
        this.valid_date = valid_date;
    }

    public Manager_costRow() {
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    public float getCost_per_month() {
        return cost_per_month;
    }

    public void setCost_per_month(float cost_per_month) {
        this.cost_per_month = cost_per_month;
    }

    public Date getValid_date() {
        return valid_date;
    }

    public void setValid_date(Date valid_date) {
        this.valid_date = valid_date;
    }
}
