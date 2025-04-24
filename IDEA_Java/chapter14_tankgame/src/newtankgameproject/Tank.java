package newtankgameproject;


public class Tank {
    private int x;
    private int y;
    private char direction;//u: up, d: down, l: left, r: right
    private int TANK_MOVE_SPEED = 5;
    private boolean isAlive = true;
    private boolean isMyTank;

    public void moveDown() {
        this.setY(getY() + TANK_MOVE_SPEED);
        this.setDirection('d');
    }

    public void moveUp() {
        this.setY(getY() - TANK_MOVE_SPEED);
        this.setDirection('u');
    }

    public void moveLeft() {
        this.setX(getX() - TANK_MOVE_SPEED);
        this.setDirection('l');
    }

    public void moveRight() {
        this.setX(getX() + TANK_MOVE_SPEED);
        this.setDirection('r');
    }



    public Tank(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public boolean isMyTank() {
        return isMyTank;
    }

    public void setMyTank(boolean myTank) {
        isMyTank = myTank;
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

    public int getTANK_MOVE_SPEED() {
        return TANK_MOVE_SPEED;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
