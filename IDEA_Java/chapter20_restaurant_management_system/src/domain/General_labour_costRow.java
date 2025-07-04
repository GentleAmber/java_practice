package domain;


import java.sql.Date;

public class General_labour_costRow {
    private String niNumber;
    private float cost_per_hr;
    private Date valid_date;

    public General_labour_costRow() {
    }

    public General_labour_costRow(String niNumber, float cost_per_hr, Date valid_date) {
        this.niNumber = niNumber;
        this.cost_per_hr = cost_per_hr;
        this.valid_date = valid_date;
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    public float getCost_per_hr() {
        return cost_per_hr;
    }

    public void setCost_per_hr(float cost_per_hr) {
        this.cost_per_hr = cost_per_hr;
    }

    public Date getValid_date() {
        return valid_date;
    }

    public void setValid_date(Date valid_date) {
        this.valid_date = valid_date;
    }
}
