package domain;

public class MenuRow {
    private int dish_no;
    private String dish_name;
    private float price;
    private String description;
    private String type;

    public MenuRow() {
    }

    public int getDish_no() {
        return dish_no;
    }

    public void setDish_no(int dish_no) {
        this.dish_no = dish_no;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MenuRow(int dish_no, String dish_name, float price, String description, String type) {
        this.dish_no = dish_no;
        this.dish_name = dish_name;
        this.price = price;
        this.description = description;
        this.type = type;
    }

    @Override
    public String toString() {
        return dish_no + "\t" + dish_name + "\t" + price +
                "\t" + description + "\t" + type;
    }
}
