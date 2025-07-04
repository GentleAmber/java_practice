package domain;

public class Cost_itemRow {
    private int cost_no;
    private String cost_name;
    private String unit;

    public Cost_itemRow(int cost_no, String cost_name, String unit) {
        this.cost_no = cost_no;
        this.cost_name = cost_name;
        this.unit = unit;
    }

    public Cost_itemRow() {
    }

    public int getCost_no() {
        return cost_no;
    }

    public void setCost_no(int cost_no) {
        this.cost_no = cost_no;
    }

    public String getCost_name() {
        return cost_name;
    }

    public void setCost_name(String cost_name) {
        this.cost_name = cost_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
