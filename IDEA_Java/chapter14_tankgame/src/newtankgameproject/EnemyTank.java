package newtankgameproject;

public class EnemyTank extends Tank{
    public EnemyTank(int x, int y) {
        super(x, y);
        this.setMyTank(false);
        this.setDirection('d');
    }
}
