package newtankgameproject;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    public EnemyTank(int x, int y) {
        super(x, y);
        this.setMyTank(false);
        this.setDirection('d');
        this.setTANK_MOVE_SPEED(getTANK_MOVE_SPEED() - 1);
    }

    public EnemyTank(int x, int y, char direction) {
        super(x, y);
        this.setMyTank(false);
        this.setDirection(direction);
        this.setTANK_MOVE_SPEED(getTANK_MOVE_SPEED() - 1);
    }

    public void randomMove() throws InterruptedException {

        //Decide whether or not to move
        if (Math.random() < 0.2)
            return;

        //Decide a random direction first
        int randomNum = (int)(Math.random() * 4);//[0,4)
        int randomMoveTimes = (int)(Math.random() * 20 + 5);

        switch (randomNum) {
            case 0:
                this.setDirection('u');

                for (int i = 0; i < randomMoveTimes; i++) {
                    if (collisionDetect('u', EnemyTankManager.enemyTanks,
                            MyPanel.myTank, MyPanel.width, MyPanel.height)) {
                        this.setY(this.getY() - getTANK_MOVE_SPEED());
                        Thread.sleep(30);
                    } else
                        break;
                }

                break;

            case 1:
                this.setDirection('r');

//                if (this.getX() + 50 + this.getTANK_MOVE_SPEED() <= this.panelWidth)
//                    this.setX(this.getX() + this.getTANK_MOVE_SPEED());

                for (int i = 0; i < randomMoveTimes; i++) {
                    if (collisionDetect('r', EnemyTankManager.enemyTanks,
                            MyPanel.myTank, MyPanel.width, MyPanel.height)) {
                        this.setX(this.getX() + getTANK_MOVE_SPEED());
                        Thread.sleep(30);
                    } else
                        break;
                }

                break;

            case 2:
                this.setDirection('d');

//                if (this.getY() + 50 + this.getTANK_MOVE_SPEED() <= MyPanel.height)
//                    this.setY(this.getY() + this.getTANK_MOVE_SPEED());
                for (int i = 0; i < randomMoveTimes; i++) {
                    if (collisionDetect('d', EnemyTankManager.enemyTanks,
                            MyPanel.myTank, MyPanel.width, MyPanel.height)) {
                        this.setY(this.getY() + getTANK_MOVE_SPEED());
                        Thread.sleep(30);
                    } else
                        break;
                }

                break;

            case 3:
                this.setDirection('l');
//                if (this.getX() - this.getTANK_MOVE_SPEED() >= 0)
//                    this.setX(this.getX() - this.getTANK_MOVE_SPEED());
                for (int i = 0; i < randomMoveTimes; i++) {
                    if (collisionDetect('l', EnemyTankManager.enemyTanks,
                            MyPanel.myTank, MyPanel.width, MyPanel.height)) {
                        this.setX(this.getX() - getTANK_MOVE_SPEED());
                        Thread.sleep(50);
                    } else
                        break;
                }

                break;
        }


    }

    public void randomShoot() throws InterruptedException {
        //Decide whether or not to shoot
        if (Math.random() < 0.5)
            return;

        //Decide a number, the tank shoots this many bullets this time
        int bulletsNum = (int) (Math.random() * 3 + 1);

        for (int i = 0; i < bulletsNum; i++) {
            GameEventBus.post(new Event_EnemyTankShoots(this));
        }
    }

    @Override
    public String toString() {
        return "EnemyTank(" + this.getX() + ", " + this.getY() + ")"
                 + hashCode();
    }

    @Override
    public void run() {
        while (true) {
            try {
                randomMove();
                randomShoot();
                Thread.sleep(150 + (int)(Math.random() * 400));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if (getStatus() != Status.ALIVE) {
                break;
            }
        }
    }


}
