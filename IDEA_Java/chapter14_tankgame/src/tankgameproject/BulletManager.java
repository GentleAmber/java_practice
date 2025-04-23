package tankgameproject;

import java.util.Vector;

public class BulletManager implements Runnable{
    static Vector<Bullet> bullets = new Vector<>();
    int bulletMaxSize = 50;

    @Override
    public void run() {
        // The method updates the coordinates of all the bullets
        // as well as removes dead bullets from the vector
        while (true) {
            int sizeNum = bullets.size();
            if (sizeNum > 0) {
                for (int i = 0; i < sizeNum; i++) {
                    Bullet bullet = bullets.get(i);
                    if (bullet.isAlive)
                        bullet.move();
                    else {
                        bullets.remove(i);
                        i--;
                        sizeNum--;
                    }
                }
            }

            try {
                Thread.sleep(30);//Keep the FPS the same as myPanel
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("当前屏幕上子弹数：" + sizeNum);
        }
    }
}
