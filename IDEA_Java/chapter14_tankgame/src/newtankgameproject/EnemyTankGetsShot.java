package newtankgameproject;

public class EnemyTankGetsShot implements GameEvent{
    public EnemyTank killedTank;

    public EnemyTankGetsShot(EnemyTank killedTank) {
        this.killedTank = killedTank;
    }
}
