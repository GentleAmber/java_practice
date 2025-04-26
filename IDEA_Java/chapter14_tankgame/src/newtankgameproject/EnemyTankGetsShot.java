package newtankgameproject;

public class EnemyTankGetsShot implements GameEvent{
    public EnemyTank killedTank;
    public Bullet hitBullet;

    public EnemyTankGetsShot(EnemyTank killedTank, Bullet hitBullet) {
        this.killedTank = killedTank;
        this.hitBullet = hitBullet;
    }
}
