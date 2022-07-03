package entity;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.awt.Rectangle;

public class Entity {

    public int x,y;
    public int speed;

    public BufferedImage spriteimg;
    public String direction;
    public int spriteCounter=0;
    public int spriteNr=1;
    public Rectangle solidArea;
    public int solidAreaDefaultX,solidAreaDefaultY;
    public boolean collisionOn=false;

}
