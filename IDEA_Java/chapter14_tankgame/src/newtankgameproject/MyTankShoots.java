package newtankgameproject;

public class MyTankShoots implements GameEvent{
    MyTank mytank;

    public MyTankShoots(MyTank mytank) {
        this.mytank = mytank;
    }
}
