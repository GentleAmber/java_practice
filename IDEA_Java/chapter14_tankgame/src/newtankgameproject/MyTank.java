package newtankgameproject;

public class MyTank extends Tank{
    private int life;
    public MyTank(int x, int y, int life, MyPanel myPanel) {
        super(x, y, myPanel);
        this.setMyTank(true);
        this.setDirection('u');
        this.setLife(life);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
