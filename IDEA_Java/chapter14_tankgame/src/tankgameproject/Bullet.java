package tankgameproject;

import java.util.Vector;

public class Bullet{
    int x;
    int y;
    int direction;//0: facing up, 1: right, 2: down, 3: left
    int BULLET_SPEED = 7;
    boolean isAlive = true;

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move() {
        //When a bullet is still in the frame, it moves
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

        //When it's out of the frame, it's dead.
        if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
            isAlive = false;
        }

        //When it hits an enemy tank, it's dead
        int[] enemyTankCoordinates = getEnemyTanksCoordinates(MyPanel.eTManager);
        for (int i = 0; i < enemyTankCoordinates.length; i++) {
            int enemyTankX = enemyTankCoordinates[i++];
            int enemyTankY = enemyTankCoordinates[i];

            if (this.x >= enemyTankX && this.x <= enemyTankX + 50
            && this.y >= enemyTankY && this.y <= enemyTankY + 50) {
                this.isAlive = false;//This bullet dies.
                Vector<EnemyTank> enemyTanks = MyPanel.eTManager.enemyTanks;
                enemyTanks.get(i / 2).isAlive = false;//The enemy tank dies.
            }
        }
    }

    public int[] getEnemyTanksCoordinates(EnemyTankManager eTM) {
        Vector<EnemyTank> enemyTanks = eTM.enemyTanks;
        int tankNum = enemyTanks.size();
        int[] coordinates = new int[tankNum * 2];

        for (int i = 0, j = 0; j < tankNum - 1; i++, j = i / 2) {
                coordinates[i++] = enemyTanks.get(j).x;
                coordinates[i] = enemyTanks.get(j).y;
        }

        return coordinates;
    }
}
