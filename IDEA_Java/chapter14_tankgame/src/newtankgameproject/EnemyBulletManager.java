package newtankgameproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class EnemyBulletManager implements GameEventListener, Runnable{

    static final Vector<Bullet> enemyBullets = new Vector<>();
    private ArrayList<GameEvent> gameEvents = new ArrayList<>();
    private int maxBulletSize = 20;

    public static Vector<Bullet> getEnemyBulletsCopy() {
        Vector<Bullet> enemyBulletsCopy = (Vector<Bullet>) enemyBullets.clone();
        return enemyBulletsCopy;

    }

    public EnemyBulletManager() {
        GameEventBus.register(this);
    }

    @Override
    public void onEvent(GameEvent event) {
        synchronized (gameEvents) {
            gameEvents.add(event);
        }
    }

    public void checkEnemyBullets() {
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
    }

    public void checkGameEvents() {
        synchronized (gameEvents) {
            Iterator<GameEvent> iterator = gameEvents.iterator();

            while (iterator.hasNext()) {
                GameEvent event = iterator.next();
                if (event instanceof Event_EnemyTankShoots) {
                    if (enemyBullets.size() < maxBulletSize) {
                        Bullet enemyBullet = ((Event_EnemyTankShoots) event).enemyBullet;
                        enemyBullets.add(enemyBullet);
                    }
                } else if (event instanceof Event_MyTankGetsShot) {
                    System.out.println(System.currentTimeMillis() + ": EnemyBulletManager receives event MyTankGetsShot.");
                    Bullet enemyBullet = ((Event_MyTankGetsShot) event).enemyBullet;
                    enemyBullets.remove(enemyBullet);
                    System.out.println(System.currentTimeMillis() + ": " + enemyBullet +
                            " is removed.");
                }
            }

            gameEvents.clear();
        }
    }

    @Override
    public void run() {
        while (true) {
            checkEnemyBullets();
            checkGameEvents();
            try {
                Thread.sleep(30);//Keep the FPS the same as myPanel
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
