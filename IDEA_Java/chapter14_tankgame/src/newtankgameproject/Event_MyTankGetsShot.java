package newtankgameproject;

public class Event_MyTankGetsShot implements GameEvent {
    public Bullet enemyBullet;

    public Event_MyTankGetsShot(Bullet enemyBullet) {
        System.out.println(System.currentTimeMillis() + ": My tank gets shot.");
        this.enemyBullet = enemyBullet;
    }
}
