package tankgame_fortestonly;

public class EnemyTank extends Tank{
    public EnemyTank(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.setMyTank(false);
        this.setDirection('d');
    }

    public void randomMove() throws InterruptedException {
        //Pass the size of the panel into randomMove

        //Decide whether to move this circle: 40% not to move
        if (Math.random() < 0.4)
            return;
        //Decide a random direction first
        int randomNum = (int)(Math.random() * 4);//[0,4)

        //Decide a number, the tank moves the distance of this number * TANK_MOVE_SPEED
        int randomNumForDistance = (int)(Math.random() * 4);

        switch (randomNum) {
            case 0:
                this.setDirection('u');
                for (int i = 0; i < randomNumForDistance; i++) {
                    if (this.getY() - this.getTANK_MOVE_SPEED() < 0) {
                        break;
                    } else {
                        this.setY(this.getY() - this.getTANK_MOVE_SPEED());
                        Thread.sleep(10);
                    }
                }
                break;
            case 1:
                this.setDirection('r');
                for (int i = 0; i < randomNumForDistance; i++) {
                    if (this.getX() + 50 + this.getTANK_MOVE_SPEED() > this.panelWidth) {
                        break;
                    } else {
                        this.setX(this.getX() + this.getTANK_MOVE_SPEED());
                        Thread.sleep(10);
                    }
                }
                break;
            case 2:
                this.setDirection('d');
                for (int i = 0; i < randomNumForDistance; i++) {
                    if (this.getY() + 50 + this.getTANK_MOVE_SPEED() > this.panelHeight) {
                        break;
                    } else {
                        this.setY(this.getY() + this.getTANK_MOVE_SPEED());
                        Thread.sleep(10);
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
                        Thread.sleep(10);
                    }
                }
                break;
        }
    }
}
