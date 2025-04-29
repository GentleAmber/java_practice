package newtankgameproject;

public class MyTankGetsShot implements GameEvent {
    public MyTank myTank;
    public Bullet enemyBullet;

    public MyTankGetsShot(MyTank myTank, Bullet enemyBullet) {
        this.myTank = myTank;
        this.enemyBullet = enemyBullet;
    }
}
