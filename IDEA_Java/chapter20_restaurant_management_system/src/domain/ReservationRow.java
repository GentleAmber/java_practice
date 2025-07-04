package domain;

import java.sql.Timestamp;

public class ReservationRow {
    private int reserv_no;
    private String customer_name;
    private int table_no;
    private short num_of_ppl;
    private Timestamp arrival_time;
    private String notes;

    public ReservationRow() {
    }

    public int getReserv_no() {
        return reserv_no;
    }

    public void setReserv_no(int reserv_no) {
        this.reserv_no = reserv_no;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getTable_no() {
        return table_no;
    }

    public void setTable_no(int table_no) {
        this.table_no = table_no;
    }

    public short getNum_of_ppl() {
        return num_of_ppl;
    }

    public void setNum_of_ppl(short num_of_ppl) {
        this.num_of_ppl = num_of_ppl;
    }

    public Timestamp getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Timestamp arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ReservationRow(int reserv_no, String customer_name, int table_no, short num_of_ppl, Timestamp arrival_time, String notes) {
        this.reserv_no = reserv_no;
        this.customer_name = customer_name;
        this.table_no = table_no;
        this.num_of_ppl = num_of_ppl;
        this.arrival_time = arrival_time;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "\t" + reserv_no +
                "\t\t" + customer_name + "\t\t\t" + table_no +
                "\t\t\t" + num_of_ppl +
                "\t\t" + arrival_time +
                "\t" + notes;
    }
}
