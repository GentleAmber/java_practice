package tankgameproject;

public class Bullet implements Runnable{
    int x;
    int y;
    int direction;//0: facing up, 1: right, 2: down, 3: left
    int BULLET_SPEED = 10;

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        //When a bullet is still in the frame, it moves
        while (x > 0 && x < 1000 && y > 0 && y < 750) {
            switch (direction) {
                case 0:
                    y -= BULLET_SPEED;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    x += BULLET_SPEED;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    y += BULLET_SPEED;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    x -= BULLET_SPEED;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        System.out.println("A bullet dies.");
    }
}
