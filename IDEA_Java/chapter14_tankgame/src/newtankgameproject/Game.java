package newtankgameproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

public class Game extends JFrame implements GameEventListener{
    //Define my panel
    private MyPanel myPanel = null;
    public int score = 0;
    public Properties tankGameFile = new Properties();

    public static void main(String[] args) {
        Game game = new Game();
    }

    public Game() {
        GameEventBus.register(this);
        setTitle("Tank War");

        JMenuBar menuBar = new JMenuBar();
        Font bigFont = new Font("Arial", Font.PLAIN, 20); // bigger font
        menuBar.setFont(bigFont);

        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(bigFont);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(bigFont);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setFont(bigFont);

        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.setFont(bigFont);

        fileMenu.add(exitItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        exitItem.addActionListener((ActionEvent e) -> System.exit(0));
        saveItem.addActionListener((ActionEvent e) -> saveGame());
        loadItem.addActionListener((ActionEvent e) -> loadGame());

        myPanel = new MyPanel(score);
        new Thread(myPanel).start();
        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(1000, 750);//Set the size of frame to be the same as that of panel
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//When the frame window is closed, program exits
        this.setVisible(true);//Without this, the frame won't show
    }

    public void saveGame() {

        tankGameFile = new Properties();
        tankGameFile.setProperty("Score", Integer.toString(score));
        Vector<EnemyTank> enemyTanks = EnemyTankManager.getEnemyTanksCopy();
        int enemyTankNum = enemyTanks.size();
        tankGameFile.setProperty("Number of enemy tanks", Integer.toString(enemyTankNum));
        for (int i = 0; i < enemyTankNum; i++) {
            tankGameFile.setProperty("EnemyTank" + i + "'s x", Integer.toString(enemyTanks.get(i).getX()));
            tankGameFile.setProperty("EnemyTank" + i + "'s y", Integer.toString(enemyTanks.get(i).getY()));
        }
        tankGameFile.setProperty("My tank's x", Integer.toString(MyPanel.myTank.getX()));
        tankGameFile.setProperty("My tank's y", Integer.toString(MyPanel.myTank.getY()));

        try (FileOutputStream fops = new FileOutputStream("src\\tankGame.properties")) {
            tankGameFile.store(fops, null);
            System.out.println("Game is saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGame() {
        try (FileInputStream fips = new FileInputStream("src\\tankGame.properties")) {
            tankGameFile.load(fips);
            System.out.println("File is loaded.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        score = Integer.parseInt(tankGameFile.getProperty("Score"));
        int enemyTankNum = Integer.parseInt(tankGameFile.getProperty("Number of enemy tanks"));

        Vector<EnemyTank> enemyTanks = EnemyTankManager.enemyTanks;
        int size = enemyTanks.size();

        if (size <= enemyTankNum) {
            for (int i = 0; i < size; i++) {
                int enemyTankX = Integer.parseInt(tankGameFile.getProperty("EnemyTank" + i + "'s x"));
                int enemyTankY = Integer.parseInt(tankGameFile.getProperty("EnemyTank" + i + "'s y"));
                enemyTanks.get(i).setX(enemyTankX);
                enemyTanks.get(i).setY(enemyTankY);
            }

            if (size < enemyTankNum) {
                for (int i = size; i < enemyTankNum; i++) {
                    int enemyTankX = Integer.parseInt(tankGameFile.getProperty("EnemyTank" + i + "'s x"));
                    int enemyTankY = Integer.parseInt(tankGameFile.getProperty("EnemyTank" + i + "'s y"));

                    enemyTanks.add(new EnemyTank(enemyTankX, enemyTankY));
                }
            }
        } else if (size > enemyTankNum) {
            for (int i = 0; i < enemyTankNum; i++) {
                int enemyTankX = Integer.parseInt(tankGameFile.getProperty("EnemyTank" + i + "'s x"));
                int enemyTankY = Integer.parseInt(tankGameFile.getProperty("EnemyTank" + i + "'s y"));
                enemyTanks.get(i).setX(enemyTankX);
                enemyTanks.get(i).setY(enemyTankY);
            }
            for (int i = enemyTankNum; i < size; i++) {
                enemyTanks.remove(i);
            }
        }

        int myTankX = Integer.parseInt(tankGameFile.getProperty("My tank's x"));
        int myTankY = Integer.parseInt(tankGameFile.getProperty("My tank's y"));

        MyPanel.myTank.setX(myTankX);
        MyPanel.myTank.setY(myTankY);

    }

    @Override
    public void onEvent(GameEvent event) {
        if (event instanceof Event_EnemyTankGetsShot) {
            score += ((Event_EnemyTankGetsShot) event).scoreAdded;
            myPanel.setScoreForPanel(score);
        }
    }
}
