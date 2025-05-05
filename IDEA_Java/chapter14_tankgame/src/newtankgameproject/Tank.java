package newtankgameproject;


public class Tank {
    private int x;
    private int y;
    private char direction;//u: up, d: down, l: left, r: right
    private int TANK_MOVE_SPEED = 5;
//    private boolean isAlive = true;
    private boolean isMyTank;
    private  Status status = Status.ALIVE;
    enum Status{
        ALIVE, DYING, DEAD
    }
    private int dyingCounter = 0;


    public void setTANK_MOVE_SPEED(int TANK_MOVE_SPEED) {
        this.TANK_MOVE_SPEED = TANK_MOVE_SPEED;
    }

    public void moveDown() {
        if (getY() + TANK_MOVE_SPEED + 100 < MyPanel.height) {
            this.setY(getY() + TANK_MOVE_SPEED);
        }
        this.setDirection('d');

    }

    public void moveUp() {
        if (getY() - TANK_MOVE_SPEED >= 0) {
            this.setY(getY() - TANK_MOVE_SPEED);
        }
        this.setDirection('u');
    }

    public void moveLeft() {
        if (getX() - TANK_MOVE_SPEED >= 0) {
            this.setX(getX() - TANK_MOVE_SPEED);
        }
        this.setDirection('l');
    }

    public void moveRight() {
        if (getX() + 60 + TANK_MOVE_SPEED < MyPanel.width) {
            this.setX(getX() + TANK_MOVE_SPEED);
        }
        this.setDirection('r');
    }

    public void isDying() {
        System.out.println(this + " is dying");
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDyingCounter() {
        return dyingCounter;
    }

    public void dyingCounterIncrement() {
        this.dyingCounter++;
    }
}
