package newtankgameproject;

import java.util.Vector;

public class ClashMonitor implements GameEvent, Runnable{
    @Override
    public void run() {
        while (true) {
            ifEnemyIsShot(EnemyTankManager.getEnemyTanksCopy(), MyBulletManager.getMyBulletsCopy());
            ifMyTankIsShot(EnemyBulletManager.getEnemyBulletsCopy());
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void ifEnemyIsShot(Vector<EnemyTank> enemyTanks, Vector<Bullet> myBullets) {
        for (EnemyTank eTank : enemyTanks) {
            for (Bullet b : myBullets) {
                if (b.getX() >= eTank.getX() && b.getX() <= eTank.getX() + 50
                        && b.getY() >= eTank.getY() && b.getY() <= eTank.getY() + 50) {
                    //If it hits
                    System.out.println(eTank + " gets shot by" + b);
                    GameEventBus.post(new Event_EnemyTankGetsShot(eTank, b));
                    // When this event is posted, the two vectors here will soon be changed
                    // so the loop cannot continue. It has to quit and wait for the next loop
                    return;
                }
            }
        }
    }

    public void ifMyTankIsShot(Vector<Bullet> enemyBullets) {
        for (Bullet b : enemyBullets) {
            MyTank myTank = MyPanel.myTank;
            if (myTank.getStatus() == Tank.Status.ALIVE &&
                    b.getX() >= myTank.getX() && b.getX() <= myTank.getX() + 50
                    && b.getY() >= myTank.getY() && b.getY() <= myTank.getY() + 50) {
                GameEventBus.post(new Event_MyTankGetsShot(b));
            }
        }
    }
}
