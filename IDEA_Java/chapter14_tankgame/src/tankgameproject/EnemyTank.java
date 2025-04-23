package tankgameproject;



public class EnemyTank extends Tank{
    boolean isAlive = true;
    boolean closeToMyTank = false;

    public EnemyTank(int x, int y) {
        super(x, y);
        direction = 2;
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
        //and a random moving distance from 2-9 times its speed
        int randomTimes = (int)(Math.random() * 8 + 2);
        //Then it starts moving
        for (int i = 0; i < randomTimes; i++) {
            try {
                Thread.sleep(30);//Same sleep time as bullets have
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

        //Start adding these bullets to the bullets vector.
        for (int i = 0; i < bulletNum; i++) {
            BulletManager.bullets.add(this.shoot());
            try {
                Thread.sleep((int)(Math.random() * 100 + 50));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void judgeIfCloseToMyTank(int[] myTankCoordinates) {
        int criticalDistance = 350;
        int xDiff = this.x - myTankCoordinates[0];
        int yDiff = this.y - myTankCoordinates[1];

        double distance = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
        if ((int)distance < criticalDistance) {
            closeToMyTank = true;
        }
    }

    public void shootMyTank() {
        //Every 0.8s, ask if the tank wants to shoot any bullet(s). The tank doesn't want to by default
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ask how many bullets it wants to shoot. The range is between
        // 2 to 5
        int bulletNum = (int)(Math.random() * 3 + 2);

        //Start adding these bullets to the bullets vector.
        for (int i = 0; i < bulletNum; i++) {
            BulletManager.bullets.add(this.shoot());
            try {
                Thread.sleep((int)(Math.random() * 100 + 30));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveTowardsMyTank(int x1, int y1, int x2, int y2, int[] myTankCoordinates) {
        int myTankX = myTankCoordinates[0];
        int myTankY = myTankCoordinates[1];

        int xDiff = this.x - myTankX;
        int yDiff = this.y - myTankY;

        if (yDiff < 0) {// If this enemyTank is above my tank
            direction = 2;
        } else if (yDiff == 0) {// at the same y level
            if (xDiff > 0) {// This enemyTank is on the right of my tank
                direction = 3;
            } else {
                direction = 1;
            }
        } else {
            direction = 0;
        }

        //and a random moving distance from 4-6 times its speed
        int randomTimes = (int)(Math.random() * 4 + 2);
        //Then it starts moving
        for (int i = 0; i < randomTimes; i++) {
            try {
                Thread.sleep(30);// Moves faster
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
}
