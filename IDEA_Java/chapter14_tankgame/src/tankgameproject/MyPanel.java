package tankgameproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    //Define my tank
    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks= new Vector<>();
    int enemyTankSize = 3;


    public MyPanel() {
        myTank = new MyTank(500, 600);//Initialise my tank
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank(200 * (i + 1), 100));
        }
    }

    @Override
    public void paint(Graphics g) {//Graphics is like the painting tool
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//Draw the background. By default the colour is black
        //Draw the tanks - method encapsulated
        drawTank(myTank.x, myTank.y, g, myTank.direction,0);
        for (EnemyTank e : enemyTanks) {
            drawTank(e.x, e.y, g, e.direction, 1);
        }
    }


    /**
     *
     * @param x the x-coordinate of the tank
     * @param y the y-coordinate of the tank
     * @param g painting tool
     * @param direction the direction the tank faces
     * @param type is this my tank or enemy tank or whatever
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            //Decide the tank's colour according to their type
            case 0: //my tank
                g.setColor(Color.CYAN);
                break;
            case 1: //enemy tank
                g.setColor(Color.YELLOW);
                break;
        }

        switch (direction) {
            case 0: //Facing up
                g.fill3DRect(x, y, 10, 50, false);
                g.fill3DRect(x + 10, y + 10, 30, 40, false);
                g.fill3DRect(x + 40, y, 10, 50, false);
                g.fillOval(x + 15, y + 20, 20, 20);
                g.drawLine(x + 25, y, x + 25, y + 20);
                break;

            case 1: //Facing right
                g.fill3DRect(x, y, 50, 10, false);
                g.fill3DRect(x, y + 10, 40, 30, false);
                g.fill3DRect(x, y + 40, 50, 10, false);
                g.fillOval(x + 10, y + 15, 20, 20);
                g.drawLine(x + 30, y + 25, x + 50, y + 25);
                break;

            case 2: //Facing down
                g.fill3DRect(x, y, 10, 50, false);
                g.fill3DRect(x + 10, y, 30, 40, false);
                g.fill3DRect(x + 40, y, 10, 50, false);
                g.fillOval(x + 15, y + 10, 20, 20);
                g.drawLine(x + 25, y + 30, x + 25, y + 50);
                break;

            case 3: //Facing left
                g.fill3DRect(x, y, 50, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 30, false);
                g.fill3DRect(x, y + 40, 50, 10, false);
                g.fillOval(x + 20, y + 15, 20, 20);
                g.drawLine(x + 20, y + 25, x, y + 25);
                break;

            default:
                System.out.println("To be programmed");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            myTank.moveDown();
            myTank.direction = 2;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            myTank.moveUp();
            myTank.direction = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            myTank.moveLeft();
            myTank.direction = 3;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            myTank.moveRight();
            myTank.direction = 1;
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
