package entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Zombie extends Entity {
    GamePanel gp;
    public boolean death = false;

    public Zombie(GamePanel gp) throws IOException {
        solidArea = new Rectangle();
        solidArea.x = 10;
        solidArea.y = 10;
        solidArea.width = 30;
        solidArea.height = 35;


        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        direction = "right";
        x = 312;
        y = 420;
        speed = 6;
        this.gp = gp;
        spriteimg = ImageIO.read(getClass().getResourceAsStream("/lvl2_spritesheet.png")).getSubimage(0, 0, 520, 52);

    }

    public void update() {
        gp.cChecker.checkTile(this);

        if (collisionOn == false) {
            if (direction.equals("right")) {
                x += speed;
            } else {
                x -= speed;
                if (x == 312) {
                    direction = "right";
                }
            }
        } else {
            if (direction.equals("right")) {
                direction = "left";
            } else {
                direction = "right";
            }
            collisionOn = false;

        }
        if (gp.player.y == y && gp.player.keyH.abilityPressed == true) {
            GamePanel.deathZombie = true;

        }
        if (direction == "left") {
            spriteCounter++;
            if (spriteCounter > 5) {
                if (spriteNr == 1) {
                    spriteNr = 2;
                } else {
                    spriteNr = 1;
                }
                spriteCounter = 0;
            }
            if (GamePanel.deathZombie && GamePanel.contorZombie > 5) {
                GamePanel.contorZombie++;
                if (GamePanel.contorZombie == 1) {
                    GamePanel.contorZombie = 2;
                } else if (GamePanel.contorZombie == 2) {
                    GamePanel.contorZombie = 3;
                } else {
                    death = true;
                    GamePanel.contorZombie = 1;

                }
                GamePanel.contorZombie = 0;
            }


        } else if (direction == "right") {
            spriteCounter++;

            if (spriteCounter > 5) {
                if (spriteNr == 1) {
                    spriteNr = 2;
                } else {
                    spriteNr = 1;
                }

                spriteCounter = 0;
            }

            if (GamePanel.deathZombie && GamePanel.contorZombie > 5) {

                GamePanel.contorZombie++;
                if (GamePanel.contorZombie == 1) {
                    GamePanel.contorZombie = 2;
                } else if (spriteNr == 2) {
                    GamePanel.contorZombie = 3;

                } else {
                    death = true;
                    GamePanel.contorZombie = 1;

                }
                GamePanel.contorZombie = 0;
            }


        }


    }

    public void draw(Graphics2D g2) {

        int height = 52;
        BufferedImage image = null;
        switch (direction) {

            case "left":
                if (spriteNr == 1) {
                    image = spriteimg.getSubimage(0, 0, height, height);
                } else if (spriteNr == 2) {
                    image = spriteimg.getSubimage(1 * height, 0, height, height);
                }
                if (GamePanel.deathZombie) {
                    GamePanel.contorZombie++;
                    if (GamePanel.contorZombie == 1) {
                        image = spriteimg.getSubimage(5 * height, 0, height, height);
                    } else if (GamePanel.contorZombie == 2) {
                        image = spriteimg.getSubimage(6 * height, 0, height, height);
                    } else if (GamePanel.contorZombie == 3) {
                        image = spriteimg.getSubimage(7 * height, 0, height, height);
                    }
                }
                break;
            case "right":
                if (spriteNr == 1) {
                    image = spriteimg.getSubimage(2 * height, 0, height, height);
                } else if (spriteNr == 2) {
                    image = spriteimg.getSubimage(3 * height, 0, height, height);
                }
                if (GamePanel.deathZombie) {
                    if (GamePanel.contorZombie == 1) {
                        image = spriteimg.getSubimage(8 * height, 0, height, height);
                    } else if (GamePanel.contorZombie == 2) {
                        image = spriteimg.getSubimage(9 * height, 0, height, height);
                    } else if (GamePanel.contorZombie == 3) {
                        image = spriteimg.getSubimage(10 * height, 0, height, height);
                    }
                }
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
