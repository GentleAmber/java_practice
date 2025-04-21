package tankgameproject;

public class Bullet implements Runnable{
    int x;
    int y;
    int direction;//0: facing up, 1: right, 2: down, 3: left
    int BULLET_SPEED = 10;
    boolean isAlive = true;

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        //When a bullet is still in the frame, it moves
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direction) {
                case 0:
                    y -= BULLET_SPEED;
                    break;
                case 1:
                    x += BULLET_SPEED;
                    break;
                case 2:
                    y += BULLET_SPEED;
                    break;
                case 3:
                    x -= BULLET_SPEED;
                    break;
            }
//            System.out.println("Bullet's coordinate: x=" + x + ", y=" + y);

            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isAlive = false;
                break;
            }
        }
    }
}
