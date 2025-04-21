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
    Vector<Bullet> bullets= new Vector<>();
    int bulletSize = 50;

    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;
    boolean jPressed = false;


    public MyPanel() {
        myTank = new MyTank(500, 600);//Initialise my tank
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank(200 * (i + 1), 100));
        }
        Timer timer = new Timer(16, e -> {
            updateGameStatus();
            repaint();
        });  // 60 FPS
        timer.start();
    }

    public void updateGameStatus() {
        if (downPressed) {
            myTank.moveDown();
            myTank.direction = 2;
        } else if (upPressed) {
            myTank.moveUp();
            myTank.direction = 0;
        } else if (leftPressed) {
            myTank.moveLeft();
            myTank.direction = 3;
        } else if (rightPressed) {
            myTank.moveRight();
            myTank.direction = 1;
        } else if (jPressed) {
            Bullet bullet = myTank.shoot();
            bullets.add(bullet);
            new Thread(bullet).start();//Bullet start moving upon being shot
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
        if (bullets.size() > 0)
            drawBullets(g);
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

        }
    }

    public void drawBullets(Graphics g) {
        int bulletsNum = bullets.size();
        for (int i = 0; i < bulletsNum; i++) {
            Bullet b = bullets.get(i);
            if (b.x > 0 && b.x < 1000 && b.y > 0 && b.y < 750) {
                switch (b.direction) {
                    case 0:
                        g.drawLine(b.x, b.y, b.x, b.y - 10);
                        break;
                    case 1:
                        g.drawLine(b.x, b.y, b.x + 10, b.y);
                        break;
                    case 2:
                        g.drawLine(b.x, b.y, b.x, b.y + 10);
                        break;
                    case 3:
                        g.drawLine(b.x, b.y, b.x - 10, b.y);
                        break;
                }
            } else {
                bullets.remove(i);
                i--;
                bulletsNum--;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            jPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            downPressed = false;
        else if (e.getKeyCode() == KeyEvent.VK_UP)
            upPressed = false;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            leftPressed = false;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightPressed = false;
        else if (e.getKeyCode() == KeyEvent.VK_J)
            jPressed = false;
    }
}
