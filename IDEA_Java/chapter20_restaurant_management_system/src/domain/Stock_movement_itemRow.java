package domain;

public class Stock_movement_itemRow {
    private int movement_no;
    private int cost_no;
    private int num;

    public Stock_movement_itemRow() {
    }

    public int getMovement_no() {
        return movement_no;
    }

    public void setMovement_no(int movement_no) {
        this.movement_no = movement_no;
    }

    public int getCost_no() {
        return cost_no;
    }

    public void setCost_no(int cost_no) {
        this.cost_no = cost_no;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Stock_movement_itemRow(int movement_no, int cost_no, int num) {
        this.movement_no = movement_no;
        this.cost_no = cost_no;
        this.num = num;
    }
}
