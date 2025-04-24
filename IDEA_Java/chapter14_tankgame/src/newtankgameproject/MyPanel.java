package newtankgameproject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements Runnable, KeyListener {
    MyTank myTank = null;
    EnemyTankManager enemyTankManager = null;
    Vector<EnemyTank> enemyTanks = null;

    MyBulletManager myBulletManager = null;
    Vector<Bullet> myBullets = null;

    EnemyBulletManager enemyBulletManager = null;
    Vector<Bullet> enemyBullets = null;


    public MyPanel() {
        myTank = new MyTank(500, 600);//Initialise my tank
        enemyTankManager = new EnemyTankManager();
        enemyTanks = enemyTankManager.getEnemyTanks();

        myBulletManager = new MyBulletManager();
        myBullets = myBulletManager.getMyBullets();

        enemyBulletManager = new EnemyBulletManager();
        enemyBullets = enemyBulletManager.getEnemyBullets();

        new Thread(enemyTankManager).start();
        new Thread(myBulletManager).start();
        new Thread(enemyBulletManager).start();

    }

    @Override
    public void paint(Graphics g) {//Graphics is like the painting tool
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//Draw the background. By default the colour is black
        //Draw the tanks - method encapsulated
        drawTank(myTank, g, true);
        for (EnemyTank e : enemyTanks) {
            drawTank(e, g, false);
        }
        drawAllTheBullets(g);

    }

    public void drawTank(Tank tank, Graphics g, boolean isMyTank) {
        //Decide the tank's colour according to their type
        if (isMyTank) { //my tank
            g.setColor(Color.CYAN);
        } else { //enemy tank
            g.setColor(Color.YELLOW);
        }

        char direction = tank.getDirection();
        int x = tank.getX();
        int y = tank.getY();
        switch (direction) {
            case 'u': //Facing up
                g.fill3DRect(x, y, 10, 50, false);
                g.fill3DRect(x + 10, y + 10, 30, 40, false);
                g.fill3DRect(x + 40, y, 10, 50, false);
                g.fillOval(x + 15, y + 20, 20, 20);
                g.drawLine(x + 25, y, x + 25, y + 20);
                break;

            case 'r': //Facing right
                g.fill3DRect(x, y, 50, 10, false);
                g.fill3DRect(x, y + 10, 40, 30, false);
                g.fill3DRect(x, y + 40, 50, 10, false);
                g.fillOval(x + 10, y + 15, 20, 20);
                g.drawLine(x + 30, y + 25, x + 50, y + 25);
                break;

            case 'd': //Facing down
                g.fill3DRect(x, y, 10, 50, false);
                g.fill3DRect(x + 10, y, 30, 40, false);
                g.fill3DRect(x + 40, y, 10, 50, false);
                g.fillOval(x + 15, y + 10, 20, 20);
                g.drawLine(x + 25, y + 30, x + 25, y + 50);
                break;

            case 'l': //Facing left
                g.fill3DRect(x, y, 50, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 30, false);
                g.fill3DRect(x, y + 40, 50, 10, false);
                g.fillOval(x + 20, y + 15, 20, 20);
                g.drawLine(x + 20, y + 25, x, y + 25);
                break;
        }
    }

    public void drawAllTheBullets(Graphics g) {
        g.setColor(Color.WHITE);
        for (Bullet b : enemyBullets) {
            int x = b.getX();
            int y = b.getY();
            switch (b.getDirection()) {
                case 'u':
                    g.drawLine(x, y, x, y - 10);
                    break;
                case 'r':
                    g.drawLine(x, y, x + 10, y);
                    break;
                case 'd':
                    g.drawLine(x, y, x, y + 10);
                    break;
                case 'l':
                    g.drawLine(x, y, x - 10, y);
                    break;
            }
        }

        for (Bullet b : myBullets) {
            int x = b.getX();
            int y = b.getY();
            switch (b.getDirection()) {
                case 'u':
                    g.drawLine(x, y, x, y - 10);
                    break;
                case 'r':
                    g.drawLine(x, y, x + 10, y);
                    break;
                case 'd':
                    g.drawLine(x, y, x, y + 10);
                    break;
                case 'l':
                    g.drawLine(x, y, x - 10, y);
                    break;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("Pressed J.");
            GameEventBus.post(new MyTankShoots(myTank));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
