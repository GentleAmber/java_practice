package tankgame_fortestonly;

public class GameEvent_MyTankShoots implements GameEvent{
    public MyTank myTank;
    public Bullet bullet;

    public GameEvent_MyTankShoots(MyTank myTank) {
        this.myTank = myTank;
        bullet = new Bullet(myTank);
    }
}
