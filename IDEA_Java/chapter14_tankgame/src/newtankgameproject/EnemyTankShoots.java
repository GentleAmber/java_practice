package newtankgameproject;

public class EnemyTankShoots implements GameEvent{
    public EnemyTank shootingTank;

    public EnemyTankShoots(EnemyTank shootingTank) {
        this.shootingTank = shootingTank;
    }
}
