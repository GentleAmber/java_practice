package newtankgameproject;

public class Event_MyTankGetsShot implements GameEvent {
    public MyTank myTank;
    public Bullet enemyBullet;

    public Event_MyTankGetsShot(MyTank myTank, Bullet enemyBullet) {
        this.myTank = myTank;
        this.enemyBullet = enemyBullet;
    }
}
