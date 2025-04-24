package newtankgameproject;

import java.util.Vector;

public class EnemyBulletManager implements GameEventListener, Runnable{

    Vector<Bullet> enemyBullets = new Vector<>();

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
