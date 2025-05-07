package newtankgameproject;

public class Event_EnemyTankGetsShot implements GameEvent{
    public EnemyTank killedTank;
    public Bullet hitBullet;
    public int scoreAdded = 10;

    public Event_EnemyTankGetsShot(EnemyTank killedTank, Bullet hitBullet) {
        this.killedTank = killedTank;
        this.hitBullet = hitBullet;
    }
}
