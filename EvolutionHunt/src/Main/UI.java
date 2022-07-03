package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;


public class UI {

    GamePanel gp;
    Font arial_50b;
    Font arial_20b;
    public double playTime;
    DecimalFormat dFormat=new DecimalFormat("#0.00");
    BufferedImage menuBK= ImageIO.read(getClass().getResourceAsStream("/menuBK.png"));
    BufferedImage happy= ImageIO.read(getClass().getResourceAsStream("/happy.png"));



    public UI(GamePanel gp) throws IOException {
        this.gp = gp;
        arial_50b=new Font("Arial",Font.BOLD,50);
        arial_20b=new Font("Arial",Font.BOLD,20);

    }



    public void draw(Graphics2D g2){

        if(GamePanel.gameFinished==true){
            g2.drawImage(menuBK,0,0, GamePanel.screenWidth,GamePanel.screenHeight,null);
            g2.drawImage(happy,gp.screenWidth/2-110,gp.screenHeight/2-300,150,200,null);
            g2.setFont(arial_50b);
            g2.setColor(Color.black);
            String text;
            int textLength;
            int x;
            int y;

            text="Ai castigat!!!";
            textLength=(int)(g2.getFontMetrics().getStringBounds(text,g2).getWidth());
            x=gp.screenWidth/2-textLength/2;
            y=gp.screenHeight/2-(gp.tileSize*5)-37;
            g2.drawString(text,x,y);

            text="Timp: "+dFormat.format(playTime)+" s";
            textLength=(int)(g2.getFontMetrics().getStringBounds(text,g2).getWidth());
            x=gp.screenWidth/2-textLength/2;
            y=gp.screenHeight/2-(gp.tileSize*1);
            g2.drawString(text,x,y);

             //gp.gameThread=null;

        }
        else {
            g2.setFont(arial_20b);
            g2.setColor(Color.black);
            g2.drawString("Obiecte colectate X " + gp.player.nrObjects, gp.tileSize+20, gp.tileSize+20);

            //TIME
            playTime+=(double) 1/60;
            g2.drawString("Time: "+ dFormat.format(playTime)+" s", gp.tileSize+20,gp.tileSize+40);
        }
    }
}
