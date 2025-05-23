package tankgame_fortestonly;

import javax.swing.*;

public class Game extends JFrame {
    //Define my panel
    private MyPanel myPanel = null;
    public static void main(String[] args) {
        Game game = new Game();
    }

    public Game() {
        setTitle("Tank War");
        myPanel = new MyPanel();
        new Thread(myPanel).start();
        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(1000, 750);//Set the size of frame to be the same as that of panel
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//When the frame window is closed, program exits
        this.setVisible(true);//Without this, the frame won't show
    }
}