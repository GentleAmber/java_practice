package domain;

public class Discount_settingRow {
    private short cust_vip_level;
    private float discount;

    public Discount_settingRow(short cust_vip_level, float discount) {
        this.cust_vip_level = cust_vip_level;
        this.discount = discount;
    }

    public Discount_settingRow() {
    }

    public short getCust_vip_level() {
        return cust_vip_level;
    }

    public void setCust_vip_level(short cust_vip_level) {
        this.cust_vip_level = cust_vip_level;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
