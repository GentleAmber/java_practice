package newtankgameproject;

import java.util.Vector;

public class EnemyBulletManager implements GameEventListener, Runnable{

    private static final Vector<Bullet> enemyBullets = new Vector<>();

    public static Vector<Bullet> getEnemyBullets() {
        return enemyBullets;
    }

    public EnemyBulletManager() {
        GameEventBus.register(this);
    }

    @Override
    public void onEvent(GameEvent event) {
        if (event instanceof EnemyTankShoots) {
            Bullet enemyBullet = ((EnemyTankShoots) event).enemyBullet;
            enemyBullets.add(enemyBullet);
        }
    }

    @Override
    public void run() {
        while (true) {
            int sizeNum = enemyBullets.size();
            if (sizeNum > 0) {
                for (int i = 0; i < sizeNum; i++) {
                    Bullet bullet = enemyBullets.get(i);
                    if (bullet.isAlive())
                        bullet.move();
                    else {
                        enemyBullets.remove(i);
                        i--;
                        sizeNum--;
                    }
                }
            }

            try {
                Thread.sleep(30);//Keep the FPS the same as myPanel
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
