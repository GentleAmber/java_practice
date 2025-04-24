package newtankgameproject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyTank extends Tank{
    public MyTank(int x, int y) {
        super(x, y);
        this.setMyTank(true);
        this.setDirection('u');
    }



}
