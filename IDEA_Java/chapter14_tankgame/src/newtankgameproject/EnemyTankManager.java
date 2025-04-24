package newtankgameproject;

import java.util.Vector;

public class EnemyTankManager implements Runnable, GameEventListener{

    private Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTankManager(Vector<EnemyTank> enemyTanks) {
        GameEventBus.register(this);
    }

    @Override
    public void run() {

    }

    @Override
    public void onEvent(GameEvent event) {
        if (event instanceof EnemyTankGetsShot) {
            EnemyTank deadTank = ((EnemyTankGetsShot) event).killedTank;
            enemyTanks.remove(deadTank); // 或者标记为 dead
        }
    }
}
