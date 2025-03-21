package homework;

public class Homework08 {
    public static void main(String[] args) {
        Colour[] members = Colour.values();

        for (Colour member : members) {
            switch (member) {
                case RED:
                    System.out.println("This is pure red!");
                    member.show();
                    break;
                case BLUE:
                    System.out.println("This is pure blue!");
                    member.show();
                    break;
                case GREEN:
                    System.out.println("This is pure green!");
                    member.show();
                    break;
                default:
                    member.show();
            }
        }
    }
}

enum Colour implements DigitalTool{
    RED(255,0,0),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Colour(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("Red value: " + redValue + "\tGreen value: " + greenValue
                + "\tBlue value: " + blueValue);
    }
}

interface DigitalTool {
    void show();
}