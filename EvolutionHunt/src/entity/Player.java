package entity;

import Main.GamePanel;
import Main.KeyHandler;
import tile.TileManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Exception.InvalidCoordonatesException;


public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public int nrObjects= 0;

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp=gp;
        this.keyH=keyH;

        solidArea=new Rectangle();
        solidArea.x=10;
        solidArea.y=10;
        solidArea.width=30;
        solidArea.height=35;

        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;


        setDefaulValues();
        getPlayerImage();
    }

    public void setDefaulValues(){

        x=100;
        y=100;
        speed=5;
        direction ="initial";
    }

    public void getPlayerImage(){

        try{
            if(GamePanel.level==0)
            spriteimg=ImageIO.read((getClass().getResourceAsStream("/res/lvl1_spritesheet.png")));
            if(GamePanel.level==1|| GamePanel.level==2){
                spriteimg=ImageIO.read((getClass().getResourceAsStream("/res/lvl2_spritesheet.png")));

            }


        } catch(IOException e){
            e.printStackTrace();
        }


    }

    public void update(){

        try {
            if (keyH.upPressed == true) {
                direction = "up";
                spriteCounter++;
                if (GamePanel.level == 2) {
                    if (spriteCounter > 5) {
                        if (spriteNr == 1) {
                            spriteNr = 2;
                        } else if (spriteNr == 2) {
                            spriteNr = 3;
                        } else {
                            spriteNr = 1;
                        }
                        spriteCounter = 0;
                    }
                }

            } else if (keyH.leftPressed == true) {
                direction = "left";
                spriteCounter++;
                if (spriteCounter > 5) {
                    if (spriteNr == 1) {
                        spriteNr = 2;
                    } else if (spriteNr == 2) {
                        spriteNr = 3;
                    } else {
                        spriteNr = 1;
                    }
                    spriteCounter = 0;
                }


            } else if (keyH.rightPressed == true) {
                direction = "right";
                spriteCounter++;

                if (spriteCounter > 5) {
                    if (spriteNr == 1) {
                        spriteNr = 2;
                    } else if (spriteNr == 2) {
                        spriteNr = 3;
                    } else {
                        spriteNr = 1;
                    }

                    spriteCounter = 0;
                }

            } else if (keyH.abilityPressed == true) {
                direction = "ability";
                spriteCounter++;
                if (GamePanel.level == 0) {
                    if (spriteCounter > 5) {
                        if (spriteNr == 1) {
                            spriteNr = 2;
                        } else {
                            spriteNr = 1;
                        }
                        spriteCounter = 0;
                    }
                }
                if (GamePanel.level == 2) {
                    if (spriteCounter > 5) {
                        if (spriteNr == 1) {
                            spriteNr = 2;
                        } else if (spriteNr == 2) {
                            spriteNr = 3;
                        } else if (spriteNr == 3) {
                            spriteNr = 4;
                        } else {
                            spriteNr = 1;
                        }
                        spriteCounter = 0;
                    }


                }


            } else {
                direction = "gravity";

            }

            //tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            if (GamePanel.level == 2 && gp.zombie.x >= gp.player.x - 5 && gp.zombie.x <= gp.player.x + 5 && gp.zombie.y >= gp.player.y - 5 && gp.zombie.y <= gp.player.y + 5) {
                gp.cChecker.checkZombie(this);
            }


            //obj collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        y -= speed;

                        break;
                    case "gravity":
                        y += speed;

                        break;
                    case "left":
                        x -= speed;

                        break;
                    case "right":
                        x += speed;

                        break;
                    case "ability":
                        break;
                }
            }


            if (x < 0 || y < 0) {
                throw new InvalidCoordonatesException("Coordonatele sunt negative");
            }

        }catch (InvalidCoordonatesException exc){
            System.out.println(exc.getMessage());
        }
    }

    public void pickUpObject(int i){

        if(i!=99){

            String objectName= gp.obj[i].name;

            switch (objectName){
                case "armour":
                    nrObjects++;
                    gp.obj[i]=null;
                    GamePanel.Obiecte[i]=1;
                    break;
                case "gun":
                    nrObjects++;
                    gp.obj[i]=null;
                    GamePanel.Obiecte[i]=1;
                    break;
                case "fire":
                    nrObjects++;
                    gp.obj[i]=null;
                    GamePanel.Obiecte[i]=1;
                    break;
                case "door1":
                    if(nrObjects==3) {
                        GamePanel.level = 1;
                        gp.tileM.loadMap("/Map/map2.txt");
                        nrObjects = 0;
                    }
                    break;
                case "door2":
                    if (nrObjects == 3) {
                        GamePanel.gameFinished = true;
                    }
                    break;
                case "tie":
                    nrObjects++;
                    gp.obj[i]=null;
                    GamePanel.Obiecte[i]=1;
                    break;
                case "telephone":
                    nrObjects++;
                    gp.obj[i]=null;
                    GamePanel.Obiecte[i]=1;
                    break;
                case "car":
                    nrObjects++;
                    gp.obj[i]=null;
                    GamePanel.Obiecte[i]=1;
                    break;

            }

        }

    }


    public void draw(Graphics2D g2){

        int height=52;
        BufferedImage image=null;
        switch (direction) {
            case "initial":
                if (GamePanel.level == 0) {
                    image = spriteimg.getSubimage(0, height, height, height);
                }
                if (GamePanel.level == 2) {
                    image = spriteimg.getSubimage(3 * height, 2 * height, height, height);
                }
                break;
            case "ability":
                if(GamePanel.level==0) {
                if (spriteNr == 1) {
                    image = spriteimg.getSubimage(8 * height, height, height, height);
                } else if (spriteNr == 2) {
                    image = spriteimg.getSubimage(9 * height, height, height, height);
                }
        }
                if(GamePanel.level==2 ){
                    if(spriteNr==1){
                        image=spriteimg.getSubimage(10*height,2*height,height,height);
                    }
                    else if(spriteNr==2){
                        image=spriteimg.getSubimage(11*height,2*height,height,height);
                    }
                    else if(spriteNr==3){
                        image=spriteimg.getSubimage(12*height,2*height,height,height);
                    }
                    else if(spriteNr==4){
                        image=spriteimg.getSubimage(13*height,2*height,height,height);
                    }
            }

                break;
            case "left":
                if(GamePanel.level==0) {
                    if (spriteNr == 1) {
                        image = spriteimg.getSubimage(height, height, height, height);
                    } else if (spriteNr == 2) {
                        image = spriteimg.getSubimage(2 * height, height, height, height);
                    } else if (spriteNr == 3) {
                        image = spriteimg.getSubimage(3 * height, height, height, height);
                    }
                }
                if(GamePanel.level==2){
                    if(spriteNr==1){
                        image=spriteimg.getSubimage(0,2*height,height,height);
                    }
                    else if(spriteNr==2){
                        image=spriteimg.getSubimage(1*height,2*height,height,height);
                    }
                    else if(spriteNr==3){
                        image=spriteimg.getSubimage(2*height,2*height,height,height);
                    }
                }

                break;
            case "right":
                if(GamePanel.level==0) {
                    if (spriteNr == 1) {
                        image = spriteimg.getSubimage(4 * height, height, height, height);
                    } else if (spriteNr == 2) {
                        image = spriteimg.getSubimage(5 * height, height, height, height);
                    } else if (spriteNr == 3) {
                        image = spriteimg.getSubimage(6 * height, height, height, height);
                    }
                }
                if(GamePanel.level==2){

                    if(spriteNr==1){
                        image=spriteimg.getSubimage(3*height,2*height,height,height);
                    }
                    else if(spriteNr==2){
                        image=spriteimg.getSubimage(4*height,2*height,height,height);
                    }
                    else if(spriteNr==3){
                        image=spriteimg.getSubimage(5*height,2*height,height,height);
                    }
                }
                break;
            case "up":
                if(GamePanel.level==0) {
                    image = spriteimg.getSubimage(10 * height, height, height, height);
                }
                if(GamePanel.level==2){
                    if(spriteNr==1){
                        image=spriteimg.getSubimage(7*height,2*height,height,height);
                    }
                    else if(spriteNr==2){
                        image=spriteimg.getSubimage(8*height,2*height,height,height);
                    }
                    else if(spriteNr==3){
                        image=spriteimg.getSubimage(9*height,2*height,height,height);
                    }
                }

                break;
            case "gravity":
                if(GamePanel.level==0) {
                    image = spriteimg.getSubimage(7 * height, height, height, height);
                }
                if(GamePanel.level==2){
                    image=spriteimg.getSubimage(6*height,2*height,height,height);
                }
                break;

        }


        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,null);

    }

}

