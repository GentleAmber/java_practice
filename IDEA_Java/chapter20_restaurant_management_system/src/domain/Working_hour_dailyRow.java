package domain;


import java.sql.Date;

public class Working_hour_dailyRow {
    private Date date;
    private String niNumber;
    private float working_hour;

    public Working_hour_dailyRow() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    public float getWorking_hour() {
        return working_hour;
    }

    public void setWorking_hour(float working_hour) {
        this.working_hour = working_hour;
    }

    public Working_hour_dailyRow(Date date, String niNumber, float working_hour) {
        this.date = date;
        this.niNumber = niNumber;
        this.working_hour = working_hour;
    }
}
