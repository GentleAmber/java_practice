package homework;

public class TestFrock {
    public static void main(String[] args) {
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();

        System.out.println(frock1.getSerialNum());
        System.out.println(frock2.getSerialNum());
        System.out.println(frock3.getSerialNum());
    }
}

class Frock {
    private static int currentNum = 100000;
    private int serialNum;

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public Frock() {
        this.serialNum = getNextNum();
    }
}