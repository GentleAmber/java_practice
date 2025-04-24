package newtankgameproject;

public class Bullet {
    private int x;
    private int y;
    private char direction;
    private boolean shotByMe;
    private int BULLET_MOVE_SPEED = 10;
    private boolean isAlive = true;

    public Bullet(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
