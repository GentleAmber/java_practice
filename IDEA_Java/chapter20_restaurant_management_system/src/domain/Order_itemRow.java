package domain;

public class Order_itemRow {
    private int order_no;
    private int dish_no;
    private int dish_num;

    public Order_itemRow() {
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
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

    public Order_itemRow(int order_no, int dish_no, int dish_num) {
        this.order_no = order_no;
        this.dish_no = dish_no;
        this.dish_num = dish_num;
    }
}
