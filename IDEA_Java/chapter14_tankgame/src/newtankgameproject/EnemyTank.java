package newtankgameproject;

public class EnemyTank extends Tank{
    public EnemyTank(int x, int y, char direction) {
        super(x, y, direction);
        this.setMyTank(false);
    }
}
