package domain;

import java.sql.Timestamp;

public class Stock_movementRow {
    private int movement_no;
    private Timestamp operation_time;
    private String mov_type;

    public Stock_movementRow() {
    }

    public int getMovement_no() {
        return movement_no;
    }

    public void setMovement_no(int movement_no) {
        this.movement_no = movement_no;
    }

    public Timestamp getOperation_time() {
        return operation_time;
    }

    public void setOperation_time(Timestamp operation_time) {
        this.operation_time = operation_time;
    }

    public String getMov_type() {
        return mov_type;
    }

    public void setMov_type(String mov_type) {
        this.mov_type = mov_type;
    }

    public Stock_movementRow(int movement_no, Timestamp operation_time, String mov_type) {
        this.movement_no = movement_no;
        this.operation_time = operation_time;
        this.mov_type = mov_type;
    }
}
