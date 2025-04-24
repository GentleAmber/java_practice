package newtankgameproject;

import tankgameproject.Bullet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyTank extends Tank implements KeyListener {
    public MyTank(int x, int y, char direction) {
        super(x, y, direction);
        this.setMyTank(true);

    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_J) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
