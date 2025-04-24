package newtankgameproject;

public class Bullet {
    private int x;
    private int y;
    private char direction;
    private boolean shotByMe;
    private int BULLET_MOVE_SPEED = 8;
    private boolean isAlive = true;

    public void move() {
        //When a bullet is still in the frame, it moves
        switch (direction) {
            case 'u':
                y -= BULLET_MOVE_SPEED;
                break;
            case 'r':
                x += BULLET_MOVE_SPEED;
                break;
            case 'd':
                y += BULLET_MOVE_SPEED;
                break;
            case 'l':
                x -= BULLET_MOVE_SPEED;
                break;
        }
            System.out.println("Bullet's coordinate: x=" + x + ", y=" + y);

        //When it's out of the frame, it's dead.
        if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
            isAlive = false;
        }
    }

    public Bullet(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public boolean isShotByMe() {
        return shotByMe;
    }

    public void setShotByMe(boolean shotByMe) {
        this.shotByMe = shotByMe;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getBULLET_MOVE_SPEED() {
        return BULLET_MOVE_SPEED;
    }
}
