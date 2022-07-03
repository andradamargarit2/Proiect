package Main;

import entity.Player;
import entity.Zombie;
import tile.TileManager;
import Menu.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Object.SuperObject;

public class GamePanel extends JPanel implements Runnable {

    private static GamePanel gamePanel;

    //screen sett
    final static int originalTileSise= 26;
    final static int scale=2;

    public static final int tileSize= originalTileSise*scale;
    public static final int maxScreenCol = 15;
    public static final int maxScreenRow= 15;
    public static final int screenWidth= tileSize* maxScreenCol; //780 pix
    public static final int screenHeight= tileSize* maxScreenRow;//780 pix

    public static int level;
    public static boolean playing=false;
    public static boolean pause=false;
    public static boolean gameFinished=false;
    public static boolean newGame=false;
    public static boolean instructions=false;
    public static boolean deathZombie=false;
    public static int contorZombie;


    int FPS=60;//FPS

    public static TileManager tileM;

    Thread gameThread;
    KeyHandler keyH= new KeyHandler();
    MouseHandler mouseH=new MouseHandler();

    public static Player player;
    public Zombie zombie;

    public static SuperObject obj[];
    public static int Obiecte[];
    public static AssetSetter aSetter;

    public CollisionChecker cChecker;

    public static UI ui;//nr obiecte colectate pe ecran

    BufferedImage bk;


    public final int optionsState=5;

    public static Launcher launcher;
    public static LauncherPause launcherPause;
    public static LauncherEnd launcherEnd;
    public static LauncherInstructions launcherInstructions;


    private GamePanel()  {

        try {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.addMouseListener(mouseH);
            this.addMouseMotionListener(mouseH);
            this.setFocusable(true);
            launcher = new Launcher();
            launcherPause = new LauncherPause();
            launcherEnd = new LauncherEnd();
            launcherInstructions = new LauncherInstructions();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static GamePanel getInstance(){
        if(gamePanel==null)
            gamePanel=new GamePanel();
        return gamePanel;


    }

    public static void Reset(){
        gamePanel=null;
    }

    public void setupGame(){
        aSetter.setObject();
    }

    public void startGameThread(){

        gameThread=new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double drawInterval=1000000000/FPS;
        double delta=0;
        long lastTime= System.nanoTime();
        long currentTime;

        while(gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {

                update();//Update info

                repaint();//Draw
                delta--;

            }
        }

    }

    public void update(){
        if(newGame){
            try {
                init();
            } catch (IOException e) {
                e.printStackTrace();
            }
            level=0;
            setupGame();
            newGame=false;
            gameFinished=false;
            deathZombie=false;
            player=new Player(this,keyH);
        }
        if(gameFinished){
            playing=false;
        }
        if(instructions==false) {
            if (level == 2 && zombie.death == false) {
                zombie.update();
            }
            player.update();
        }
    }


    public void resetGame(){
        newGame=false;
    }

    public void init() throws IOException {

        tileM=new TileManager(this);
      player= new Player(this,keyH);
      zombie=new Zombie(this);
      obj=new SuperObject[5];
      aSetter=new AssetSetter(this);
      cChecker =new CollisionChecker(this);
      ui=new UI(this);//nr obiecte colectate pe ecran
        Obiecte=new int[3];

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D) g;

        try{

            bk= ImageIO.read(getClass().getResourceAsStream("/res/lvl1_spritesheet.png")).getSubimage(4*52,0,52,52);

        }catch (IOException e){
            e.printStackTrace();
        }
        //background
        g2.drawImage(bk,0,0,screenWidth,screenHeight,null);


        if(instructions){
            launcherInstructions.draw(g2);
        }
        else if(playing) {
            tileM.draw(g2);//TILE

            if(level==1){
                setupGame();
                player.setDefaulValues();
                player.getPlayerImage();
                level=2;
                for (int i = 0; i <Obiecte.length ; i++) {
                    Obiecte[i]=0;
                }

            }


            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }

            if(level==2 && zombie.death==false){
            zombie.draw(g2);
            }


            player.draw(g2);

            ui.draw(g2);


        }
        else if(pause){

            launcherPause.draw(g2);
        }
        else if(gameFinished==true) {
            //UI
            ui.draw(g2);
            launcherEnd.draw(g2);

        }
        else if(playing==false ){
            launcher.draw(g2);
        }



        g2.dispose();
    }

}
