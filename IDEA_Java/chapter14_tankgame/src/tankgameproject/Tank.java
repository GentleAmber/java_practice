package tankgameproject;

public class Tank {
    int x;
    int y;
    int direction;//0: facing up, 1: right, 2: down, 3: left
    int TANK_MOVE_SPEED = 5;

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
}
