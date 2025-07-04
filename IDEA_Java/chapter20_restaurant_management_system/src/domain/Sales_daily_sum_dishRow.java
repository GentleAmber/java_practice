package domain;

public class Sales_daily_sum_dishRow {
    private int sum_no;
    private int dish_no;
    private int dish_num;

    public Sales_daily_sum_dishRow() {
    }

    public int getSum_no() {
        return sum_no;
    }

    public void setSum_no(int sum_no) {
        this.sum_no = sum_no;
    }

    public int getDish_no() {
        return dish_no;
    }

    public void setDish_no(int dish_no) {
        this.dish_no = dish_no;
    }

    public int getDish_num() {
        return dish_num;
    }

    public void setDish_num(int dish_num) {
        this.dish_num = dish_num;
    }

    public Sales_daily_sum_dishRow(int sum_no, int dish_no, int dish_num) {
        this.sum_no = sum_no;
        this.dish_no = dish_no;
        this.dish_num = dish_num;
    }
}
