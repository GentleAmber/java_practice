package newtankgameproject;


public class MyTank extends Tank implements GameEventListener{
    private int life;
    public MyTank(int x, int y, int life) {
        super(x, y);
        this.setMyTank(true);
        this.setDirection('u');
        this.setLife(life);
        GameEventBus.register(this);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public void onEvent(GameEvent event) {
        if (event instanceof Event_MyTankGetsShot) {
            this.setStatus(Tank.Status.DYING);
            System.out.println(System.currentTimeMillis() + ": My tank sets to DYING.");
            //First put it into a dying status so that the explosion effect can be drawn
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//After 2 sec, it really dies.
            this.setStatus(Tank.Status.DEAD);
            System.out.println(System.currentTimeMillis() + ": My tank sets to DEAD.");
        }
    }
}
