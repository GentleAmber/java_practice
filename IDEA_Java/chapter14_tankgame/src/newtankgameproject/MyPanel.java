package newtankgameproject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

public class MyPanel extends JPanel implements Runnable, KeyListener {
    static int width = 1000;
    static int height = 750;
    static MyTank myTank = null;

    private Vector<GameEvent> gameEvents = new Vector<>();

    EnemyTankManager enemyTankManager = null;
    Vector<EnemyTank> enemyTanksForPanel = null;

    MyBulletManager myBulletManager = null;
    Vector<Bullet> myBulletsForPanel = null;

    EnemyBulletManager enemyBulletManager = null;
    Vector<Bullet> enemyBulletsForPanel = null;

    ClashMonitor clashMonitor = null;

    public static MyTank getMyTank() {
        return myTank;
    }

    public MyPanel() {
        enemyBulletManager = new EnemyBulletManager();

        myTank = new MyTank(500, 600, 3);//Initialise my tank

        myBulletManager = new MyBulletManager();

        enemyTankManager = new EnemyTankManager();

        clashMonitor = new ClashMonitor();

        new Thread(enemyTankManager).start();
        new Thread(myBulletManager).start();
        new Thread(enemyBulletManager).start();
        new Thread(clashMonitor).start();

    }

    @Override
    public void paint(Graphics g) {//Graphics is like the painting tool
        super.paint(g);
        g.fillRect(0, 0, width, height);//Draw the background. By default the colour is black
        //Take a snapshot of everything and draw them
        enemyTanksForPanel = EnemyTankManager.getEnemyTanksCopy();
        myBulletsForPanel = MyBulletManager.getMyBulletsCopy();
        enemyBulletsForPanel = EnemyBulletManager.getEnemyBulletsCopy();

        if (myTank.getStatus() == Tank.Status.ALIVE) {
            drawTank(myTank, g, true);
        } else if (myTank.getStatus() == Tank.Status.DYING) {
            drawExplosionCircle(g, myTank.getX() + 25, myTank.getY() + 25,
                    10 + myTank.getDyingCounter() * 1);
            myTank.dyingCounterIncrement();
        }

        for (EnemyTank e : enemyTanksForPanel) {
            if (e.getStatus() == Tank.Status.ALIVE)
                drawTank(e, g, false);
            else if (e.getStatus() == Tank.Status.DYING) {
                //Explosion on top of the tank
                drawExplosionCircle(g, e.getX() + 25, e.getY() + 25,
                        10 + e.getDyingCounter() * 1);
                e.dyingCounterIncrement();
            }
        }

        for (Bullet b : myBulletsForPanel) {
            if (b.isAlive())
                drawBullet(g, b);
        }

        for (Bullet b : enemyBulletsForPanel) {
            if (b.isAlive()) {
                drawBullet(g, b);
            }
        }

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

    public void drawBullet(Graphics g, Bullet b) {
        g.setColor(Color.WHITE);
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

    public void drawExplosionCircle(Graphics g, int centerX, int centerY, int radius) {
        g.setColor(Color.WHITE);
        g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        g.setColor(Color.RED);
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
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
        if (myTank.getStatus() == Tank.Status.ALIVE) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                myTank.moveDown();
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                myTank.moveUp();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                myTank.moveLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                myTank.moveRight();
            } else if (e.getKeyCode() == KeyEvent.VK_J) {
                GameEventBus.post(new Event_MyTankShoots(myTank));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



}
