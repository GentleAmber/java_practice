package tankgame_fortestonly;

public class Bullet {
    private int x;
    private int y;
    private char direction;
    private boolean shotByMe;
    private int BULLET_MOVE_SPEED = 8;
    private boolean isAlive = true;

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

    public int getBULLET_MOVE_SPEED() {
        return BULLET_MOVE_SPEED;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

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

        //When it's out of the frame, it's dead.
        if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
            isAlive = false;
        }
    }

    public Bullet(Tank tank) {
        this.direction = tank.getDirection();
        switch (direction) {
            case 'u':
                this.x = tank.getX() + 25;
                break;
            case 'r':
                this.x = tank.getX() + 50;
                this.y = tank.getY() + 25;
                break;
            case 'd':
                this.x = tank.getX() + 25;
                this.y = tank.getY() + 50;
                break;
            case 'l':
                this.y = tank.getY() + 25;
                break;
        }
    }
}
