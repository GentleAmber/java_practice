package newtankgameproject;

import java.util.Vector;

public class MyBulletManager implements Runnable, GameEventListener{

    private Vector<Bullet> myBullets = new Vector<>();

    public MyBulletManager(Vector<Bullet> myBullets) {
        GameEventBus.register(this);
    }

    @Override
    public void run() {

    }

    @Override
    public void onEvent(GameEvent event) {
        if (event instanceof MyTankShoots) {

        }
    }
}
