package newtankgameproject;
import java.util.Vector;

public class EnemyTankManager implements Runnable, GameEventListener{

    private static final Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTankManager() {
        for (int i = 0; i <3; i++) {
            enemyTanks.add(new EnemyTank(200 * (i + 1), 100));
        }
        GameEventBus.register(this);
    }

    @Override
    public void run() {
        int tankNum;
        while (true) {
            tankNum = enemyTanks.size();
            for (int i = 0; i < tankNum; i++) {
                EnemyTank thisTank = enemyTanks.get(i);

                if (thisTank.isAlive()) {
                    continue;
                } else {
                    enemyTanks.remove(i);
                    i--;
                    tankNum--;
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
            enemyTanks.remove(deadTank); // 或者标记为 dead
        }
    }
}
