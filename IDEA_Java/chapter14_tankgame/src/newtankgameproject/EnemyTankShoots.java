package newtankgameproject;

public class EnemyTankShoots implements GameEvent{
    public EnemyTank shootingTank;
    public Bullet enemyBullet;

    public EnemyTankShoots(EnemyTank shootingTank) {
        this.shootingTank = shootingTank;
        enemyBullet = new Bullet(shootingTank.getX(), shootingTank.getY(), shootingTank.getDirection());
        switch (shootingTank.getDirection()) {
            case 'u':
                enemyBullet.setX(shootingTank.getX() + 25);
                break;
            case 'r':
                enemyBullet.setX(shootingTank.getX() + 50);
                enemyBullet.setY(shootingTank.getY() + 25);
                break;
            case 'd':
                enemyBullet.setX(shootingTank.getX() + 25);
                enemyBullet.setY(shootingTank.getY() + 50);
                break;
            case 'l':
                enemyBullet.setY(shootingTank.getY() + 25);
                break;
        }
    }
}
