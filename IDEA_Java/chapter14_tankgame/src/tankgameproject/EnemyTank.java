package tankgameproject;



public class EnemyTank extends Tank implements Runnable{
    boolean isAlive;

    public EnemyTank(int x, int y) {
        super(x, y);
        direction = 2;
    }

    @Override
    public void run() {
        while (true) {
            randomMove(0, 0, 950, 700);
            randomShoot();

        }
    }

    public void randomMove(int x1, int y1, int x2, int y2) {
        //The parameters are to confine the space the enemy tanks can move
        //Enemy tank wait for a random time between 0-1.5 sec before moving
        int randomSleepTime = (int)(Math.random() * 1500);
        try {
            Thread.sleep(randomSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //When it's time to move, it's inclined to move down,
        // if it doesn't move down, it then chooses a random direction from 0 to 3
        if (Math.random() >= 0.6) {
            direction = 2;
        } else {
            int randomDirection = (int) (Math.random() * 4);//[0,4)
            direction = randomDirection;
        }
        //and a random moving distance from 1-5 times its speed
        int randomTimes = (int)(Math.random() * 5 + 1);
        //Then it starts moving
        for (int i = 0; i < randomTimes; i++) {
            try {
                Thread.sleep(50);//Same sleep time as bullets have
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direction) {
                case 0:
                    if (y - TANK_MOVE_SPEED >= y1) {
                        moveUp();
                    }
                    break;
                case 1:
                    if (x + TANK_MOVE_SPEED <= x2) {
                        moveRight();
                    }
                    break;
                case 2:
                    if (y + TANK_MOVE_SPEED <= y2) {
                        moveDown();
                    }
                    break;
                case 3:
                    if (x - TANK_MOVE_SPEED >= x1) {
                        moveLeft();
                    }
                    break;
            }

        }
    }

    public void randomShoot() {
        //Every 1s, ask if the tank wants to shoot any bullet(s). The tank doesn't want to by default
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean shoot = false;
        if (Math.random() > 0.75)
            shoot = true;

        //If it wants to shoot, ask how many bullets it wants to shoot. The range is between
        // 1 to 3
        int bulletNum = 0;
        if (shoot)
            bulletNum = (int)(Math.random() * 3 + 1);

        //Start adding these bullets to the vector and start their threads
        for (int i = 0; i < bulletNum; i++) {
            MyPanel.bullets.add(this.shoot());
            try {
                Thread.sleep((int)(Math.random() * 100 + 50));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(MyPanel.bullets.get(i)).start();
        }
    }
}
