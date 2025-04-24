package newtankgameproject;

import java.util.Vector;

public class MyBulletManager implements Runnable, GameEventListener{

    private static final Vector<Bullet> myBullets = new Vector<>();

    public static Vector<Bullet> getMyBullets() {
        return myBullets;
    }

    public MyBulletManager() {
        GameEventBus.register(this);
    }

    @Override
    public void run() {
        while (true) {
            int sizeNum = myBullets.size();
            if (sizeNum > 0) {
                for (int i = 0; i < sizeNum; i++) {
                    Bullet bullet = myBullets.get(i);
                    if (bullet.isAlive())
                        bullet.move();
                    else {
                        myBullets.remove(i);
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

    @Override
    public void onEvent(GameEvent event) {
        if (event instanceof MyTankShoots) {
            System.out.println("MyBulletManager receives MyTankShoots.");
            Bullet myBullet = ((MyTankShoots) event).myBullet;
            myBullets.add(myBullet);
        }
    }
}
