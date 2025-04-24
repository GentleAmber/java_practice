package tankgameproject;

public class Tank {
    int x;
    int y;
    int direction;//0: facing up, 1: right, 2: down, 3: left
    int TANK_MOVE_SPEED = 5;
    boolean isAlive = true;


    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveRight() {
        this.x += TANK_MOVE_SPEED;
    }

    public void moveLeft() {
        this.x -= TANK_MOVE_SPEED;
    }

    public void moveUp() {
        this.y -= TANK_MOVE_SPEED;
    }

    public void moveDown() {
        this.y += TANK_MOVE_SPEED;
    }

    public Bullet shoot() {
        Bullet b = new Bullet(x, y ,direction);
        //Adjusting bullet's coordinates to the end of the tank's gun
        switch (direction) {
            case 0:
                b.x += 25;
                break;
            case 1:
                b.x += 50;
                b.y += 25;
                break;
            case 2:
                b.x += 25;
                b.y += 50;
                break;
            case 3:
                b.y += 25;
                break;
        }
        return b;
    }
}
