package tankgameproject;

import java.util.Vector;

public class EnemyTankManager implements Runnable{

    static Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSetSize = 3;

    public EnemyTankManager() {
        for (int i = 0; i < enemyTankSetSize; i++) {
            enemyTanks.add(new EnemyTank(200 * (i + 1), 100));
        }
    }

    public int[] getMyTanksPosition(MyTank myTank) {
        int[] myTankCoordinates = new int[2];
        myTankCoordinates[0] = myTank.x;
        myTankCoordinates[1] = myTank.y;

        return myTankCoordinates;
    }

    public void setEnemyTankDead(int i) {
        enemyTanks.get(i).isAlive = false;
    }


    @Override
    public void run() {
        int tankNum = 0;
        while (true) {
            tankNum = enemyTanks.size();
            System.out.println("Number of enemy tanks left: " + tankNum);
            for (int i = 0; i < tankNum; i++) {
                EnemyTank thisTank = enemyTanks.get(i);
                int[] myTankCoordinates = getMyTanksPosition(MyPanel.myTank);
                thisTank.judgeIfCloseToMyTank(myTankCoordinates);

                if (thisTank.isAlive) {
                    thisTank.randomMove(0, 0, 950, 700);
//                    thisTank.randomShoot();
//                } else if (thisTank.isAlive && thisTank.closeToMyTank) {
//                    thisTank.moveTowardsMyTank(0, 0, 950, 700, myTankCoordinates);
//                    thisTank.shootMyTank();
                } else {
                    enemyTanks.remove(i);
                    i--;
                    tankNum--;
                }

            }
            try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
