package tankgame_fortestonly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class NPCControlCenter implements Runnable, GameEventListener{
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    private Vector<Bullet> myBullets = new Vector<>();
    private Vector<Bullet> enemyBullets = new Vector<>();
    private ArrayList<GameEvent> events = new ArrayList<>();

    private NPCControlCenter() {
        GameEventBus.register(this);
        for (int i = 0; i < 3; i++) {
            enemyTanks.add(new EnemyTank(200 * (i + 1), 100, MyPanel.width, MyPanel.height));
        }
    }

    public static NPCControlCenter getInstance() {
        NPCControlCenter controlCenter = new NPCControlCenter();
        return controlCenter;
    }

    public Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public Vector<Bullet> getMyBullets() {
        return myBullets;
    }

    public Vector<Bullet> getEnemyBullets() {
        return enemyBullets;
    }

    public void enemyTanksCheck() {
        int enemyTankNum = enemyTanks.size();
        for (int i = 0; i < enemyTankNum; i++) {
            EnemyTank thisTank = enemyTanks.get(i);

            if (thisTank.getStatus() == Tank.Status.ALIVE) {
                try {
                    thisTank.randomMove();
//                    thisTank.randomShoot();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (thisTank.getStatus() == Tank.Status.DEAD){
                enemyTanks.remove(i);
                i--;
                enemyTankNum--;
            } else {//It's still dying
                thisTank.isDying();
            }
        }
    }

    public void myBulletsCheck() {
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

    public void enemyBulletsCheck() {

    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            enemyTanksCheck();
            myBulletsCheck();
            eventPoolCheck();
        }
    }

    public void eventPoolCheck() {
        synchronized (events) {
            Iterator iterator = events.iterator();
            while (iterator.hasNext()) {
                GameEvent event = (GameEvent) iterator.next();
                if (event instanceof GameEvent_MyTankShoots) {
                    myBullets.add(((GameEvent_MyTankShoots) event).bullet);
                }
            }
            events.clear();
        }
    }

    @Override
    public void onEvent(GameEvent event) {
        synchronized (events) {
            events.add(event);
        }
    }
}
