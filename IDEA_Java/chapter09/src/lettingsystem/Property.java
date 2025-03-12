package lettingsystem;

public class Property {
    private String landlord;
    private String landlordTel;
    private String address;
    private double monthlyRent;
    private boolean status;//true = rented, false = not rented.
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String statusToString;
        if (status) {
            statusToString = "Rented";
        } else {
            statusToString = "Not rented";
        }

        return id + "\t\t" + landlord + "\t\t" + landlordTel + "\t\t" + address + "\t" + monthlyRent
                + "\t\t" + statusToString;
    }

    //Constructors
    public Property() {
    }

    public Property(String landlord, String landlordTel, String address, double monthlyRent, boolean status) {
        setLandlord(landlord);
        setLandlordTel(landlordTel);
        setAddress(address);
        setMonthlyRent(monthlyRent);
        setStatus(status);
    }

    //Setters and getters
    public String getLandlord() {
        return landlord;
    }

    public void setLandlord(String landlord) {
        this.landlord = landlord;
    }

    public String getLandlordTel() {
        return landlordTel;
    }

    public void setLandlordTel(String landlordTel) {
        this.landlordTel = landlordTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
