package newtankgameproject;

public class MyTankShoots implements GameEvent{
    public MyTank myTank;
    public Bullet myBullet;

    public MyTankShoots(MyTank mytank) {
        this.myTank = mytank;
        myBullet = new Bullet(mytank.getX(), mytank.getY(), mytank.getDirection());
        switch (myBullet.getDirection()) {
            case 'u':
                myBullet.setX(myBullet.getX() + 25);
                break;
            case 'r':
                myBullet.setX(myBullet.getX() + 50);
                myBullet.setY(myBullet.getY() + 25);
                break;
            case 'd':
                myBullet.setX(myBullet.getX() + 25);
                myBullet.setY(myBullet.getY() + 50);
                break;
            case 'l':
                myBullet.setY(myBullet.getY() + 25);
                break;
        }
    }
}
