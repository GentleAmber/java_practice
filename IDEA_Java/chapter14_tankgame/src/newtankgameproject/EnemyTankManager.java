package newtankgameproject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class EnemyTankManager implements Runnable, GameEventListener{

    static Vector<EnemyTank> enemyTanks = new Vector<>();
    private ArrayList<GameEvent> gameEvents = new ArrayList<>();

    public EnemyTankManager() {

        GameEventBus.register(this);
        for (int i = 0; i <3; i++) {
            enemyTanks.add(new EnemyTank(200 * (i + 1), 100));
        }

        // Start enemy tank threads
        for (int i = 0; i < 3; i++) {
            new Thread(enemyTanks.get(i)).start();
        }
    }

    @Override
    public void run() {

        while (true) {
            checkGameEvents();
            checkEnemyTanks();

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static Vector<EnemyTank> getEnemyTanksCopy() {

        Vector<EnemyTank> enemyTanksCopy = (Vector<EnemyTank>) enemyTanks.clone();
        return enemyTanksCopy;
    }

    public void checkEnemyTanks() {
        int tankNum;
        tankNum = enemyTanks.size();
        for (int i = 0; i < tankNum; i++) {
            EnemyTank thisTank = enemyTanks.get(i);

            if (thisTank.getStatus() == Tank.Status.ALIVE) {
//                    System.out.println(System.currentTimeMillis() + ": " +
//                            thisTank + " moves.");
            } else if (thisTank.getStatus() == Tank.Status.DEAD){
                System.out.println(System.currentTimeMillis() + ": " + thisTank + " is removed.");
                enemyTanks.remove(i);
                i--;
                tankNum--;
            } else {//It's still dying
                System.out.println(System.currentTimeMillis() + ": " + thisTank + " is dying.");
            }
        }
    }

    public void checkGameEvents() {
        synchronized (gameEvents) {
            Iterator<GameEvent> iterator = gameEvents.iterator();
            while (iterator.hasNext()) {
                GameEvent event = iterator.next();
                if (event instanceof Event_EnemyTankGetsShot) {
                    EnemyTank deadTank = ((Event_EnemyTankGetsShot) event).killedTank;
                    deadTank.setStatus(Tank.Status.DYING);
                    System.out.println(System.currentTimeMillis() + ": " + deadTank + " sets to DYING.");
                    //First put it into a dying status so that the explosion effect can be drawn
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }//After 2 sec, it really dies.
                    deadTank.setStatus(Tank.Status.DEAD);
                    System.out.println(System.currentTimeMillis() + ": " + deadTank + " sets to DEAD.");
                }
            }

            gameEvents.clear();
        }
    }

    @Override
    public void onEvent(GameEvent event) {
        synchronized (gameEvents) {
            gameEvents.add(event);
        }
    }
}
