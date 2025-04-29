package newtankgameproject;
import java.util.Vector;

public class EnemyTankManager implements Runnable, GameEventListener{

    private static final Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTankManager() {
        GameEventBus.register(this);
    }

    @Override
    public void run() {
        int tankNum;
        while (true) {
            tankNum = enemyTanks.size();
            for (int i = 0; i < tankNum; i++) {
                EnemyTank thisTank = enemyTanks. get(i);

                if (thisTank.getStatus() == Tank.Status.ALIVE) {
                    try {
                        thisTank.randomMove();
                        thisTank.randomShoot();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (thisTank.getStatus() == Tank.Status.DEAD){
                    enemyTanks.remove(i);
                    i--;
                    tankNum--;
                    System.out.println(thisTank + " is removed.");
                } else {//It's still dying
                    thisTank.isDying();
                }
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    @Override
    public void onEvent(GameEvent event) {
        if (event instanceof EnemyTankGetsShot) {
            EnemyTank deadTank = ((EnemyTankGetsShot) event).killedTank;
            deadTank.setStatus(Tank.Status.DYING);
            //First put it into a dying status so that the explosion effect can be drawn
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//After 2 sec, it really dies.
            deadTank.setStatus(Tank.Status.DEAD);
        }
    }
}
