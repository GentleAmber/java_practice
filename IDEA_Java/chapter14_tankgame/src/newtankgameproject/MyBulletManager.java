package newtankgameproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class MyBulletManager implements Runnable, GameEventListener{

    private static final Vector<Bullet> myBullets = new Vector<>();
    private int maxBulletNum = 5;
    private ArrayList<GameEvent> gameEvents = new ArrayList<>();

    public static Vector<Bullet> getMyBulletsCopy() {
        Vector<Bullet> myBulletsCopy = (Vector<Bullet>) myBullets.clone();
        return myBulletsCopy;
    }

    public MyBulletManager() {
        GameEventBus.register(this);
    }

    public void checkMyBullets() {
        int sizeNum = myBullets.size();
        if (sizeNum > 0) {
            for (int i = 0; i < sizeNum; i++) {
                Bullet bullet = myBullets.get(i);
                if (bullet.isAlive())
                    bullet.move();
                else {
                    myBullets.remove(i);
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
                if (event instanceof Event_MyTankShoots) {
//            System.out.println("MyBulletManager receives MyTankShoots.");
                    Bullet myBullet = ((Event_MyTankShoots) event).myBullet;
                    if (myBullets.size() < maxBulletNum) {
                        myBullets.add(myBullet);
                    }
                } else if (event instanceof Event_EnemyTankGetsShot) {
                    Bullet myBullet = ((Event_EnemyTankGetsShot) event).hitBullet;

                    myBullets.remove(myBullet);
                    System.out.println(System.currentTimeMillis() +
                            " : " + myBullet + " is removed.");
                }
            }

            gameEvents.clear();
        }
    }

    @Override
    public void run() {
        while (true) {
            checkMyBullets();
            checkGameEvents();

            try {
                Thread.sleep(30);//Keep the FPS the same as myPanel
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onEvent(GameEvent event) {
        synchronized (gameEvents) {
            gameEvents.add(event);
        }
    }
}
