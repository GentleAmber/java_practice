package inner_class;

import javafx.scene.control.Cell;

public class InnerClassExercise01 {
    public void testAlarmclock() {
        Bell bell = new Bell() {
            @Override
            public void ring() {
                System.out.println("Wake up, lazy pig.");
            }
        };
        CellPhone phone = new CellPhone();
        phone.alarmclock(bell);

        phone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("Let's have class.");
            }
        });
    }

    public static void main(String[] args) {
        new InnerClassExercise01().testAlarmclock();
    }
}

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmclock(Bell bell) {
        bell.ring();
    }
}