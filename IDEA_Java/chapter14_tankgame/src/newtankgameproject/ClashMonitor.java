package newtankgameproject;

import java.util.Vector;

public class ClashMonitor implements GameEvent, Runnable{
    @Override
    public void run() {
        System.out.println("Clash monitor starts.");
        while (true) {
            ifEnemyIsShot(EnemyTankManager.getEnemyTanks(), MyBulletManager.getMyBullets());
//        ifMyTankIsShot(MyPanel.getMyTank(), EnemyBulletManager.getEnemyBullets());
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
                    GameEventBus.post(new EnemyTankGetsShot(eTank, b));
                    // When this event is posted, the two vectors here will soon be changed
                    // so the loop cannot continue. It has to quit and wait for the next loop
                    return;
                }
            }
        }
    }

    public void ifMyTankIsShot(MyTank myTank, Vector<Bullet> enemyBullets) {
        for (Bullet b : enemyBullets) {
            
        }
    }
}
