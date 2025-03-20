package interface_;

public class InterfaceExercise02 {
}
interface AAA {
    int x = 0;//public static final int x = 0
}
class BBB {
    int x = 1;
}

class CCC extends BBB implements AAA {
    public void pX() {
        System.out.println(super.x);//Cannot just say "x"
        System.out.println(AAA.x);

    }

    public static void main(String[] args) {
        new CCC().pX();
    }
}