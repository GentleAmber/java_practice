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

    }

    @Override
    public void run() {

    }
}
