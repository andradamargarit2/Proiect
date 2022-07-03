package Object;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision=false;
    public int wordX,wordY;
    public Rectangle solidArea=new Rectangle(0,0,52,52);
    public int solidAreaDefaultX=0;
    public int solidAreaDefaultY=0;

    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, wordX,wordY, gp.tileSize, gp.tileSize, null);

    }
}
