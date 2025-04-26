package newtankgameproject;

public class EnemyTank extends Tank{
    public EnemyTank(int x, int y) {
        super(x, y);
        this.setMyTank(false);
        this.setDirection('d');
    }

    public void randomMove(int x, int y, int x1, int y1) throws InterruptedException {
        //Pass the size of the panel into randomMove

        //Think for a random time before moving
        Thread.sleep((int)(Math.random() * 800) + 200);
        //Decide a random direction first
        int randomNum = (int)(Math.random() * 4);//[0,4)

        //Decide a number, the tank moves the distance of this number * TANK_MOVE_SPEED
        int randomNumForDistance = (int)(Math.random() * 8);

        switch (randomNum) {
            case 0:
                this.setDirection('u');
                for (int i = 0; i < randomNumForDistance; i++) {
                    if (this.getY() - this.getTANK_MOVE_SPEED() < 0) {
                        break;
                    } else {
                        this.setY(this.getY() - this.getTANK_MOVE_SPEED());
                        Thread.sleep(30);
                    }
                }
                break;
            case 1:
                this.setDirection('r');
                for (int i = 0; i < randomNumForDistance; i++) {
                    if (this.getX() + this.getTANK_MOVE_SPEED() > 1000) {
                        break;
                    } else {
                        this.setX(this.getX() + this.getTANK_MOVE_SPEED());
                        Thread.sleep(30);
                    }
                }
                break;
            case 2:
                this.setDirection('d');
                for (int i = 0; i < randomNumForDistance; i++) {
                    if (this.getY() + this.getTANK_MOVE_SPEED() > 750) {
                        break;
                    } else {
                        this.setY(this.getY() + this.getTANK_MOVE_SPEED());
                        Thread.sleep(30);
                    }
                }
                break;
            case 3:
                this.setDirection('l');
                for (int i = 0; i < randomNumForDistance; i++) {
                    if (this.getX() - this.getTANK_MOVE_SPEED() < 0) {
                        break;
                    } else {
                        this.setX(this.getX() - this.getTANK_MOVE_SPEED());
                        Thread.sleep(30);
                    }
                }
                break;
        }


    }

    public void randomShoot() throws InterruptedException {
        //Think for a random time before shooting
        Thread.sleep((int)(Math.random() * 350) + 50);
        //Decide a number, the tank shoots this many bullets this time
        int bulletsShot = (int)(Math.random() * 3) + 1;
        for (int i = 0; i < bulletsShot; i++) {
            GameEventBus.post(new EnemyTankShoots(this));
            Thread.sleep(150);
        }
    }

    @Override
    public String toString() {
        return "EnemyTank(" + this.getX() + ", " + this.getY() + ")";
    }
}
