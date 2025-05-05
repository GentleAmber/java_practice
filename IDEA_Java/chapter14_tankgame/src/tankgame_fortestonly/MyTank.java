package tankgame_fortestonly;

public class MyTank extends Tank{
    private int life;
    public MyTank(int x, int y, int life, int width, int height) {
        super(x, y, width, height);
        this.life = life;
        this.setMyTank(true);
        this.setDirection('u');
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
