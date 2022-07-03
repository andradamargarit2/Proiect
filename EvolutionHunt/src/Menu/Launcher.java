package Menu;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Launcher {
   public BufferedImage menuBK,menuButon;
   public Button[] buttons;

    public Launcher() throws IOException {
        menuBK= ImageIO.read(getClass().getResourceAsStream("/menuBK.png"));
        menuButon= ImageIO.read(getClass().getResourceAsStream("/menuBUTON.png"));
        buttons=new Button[4];
        buttons[0]=new Button(210,175,375,100,"Start",menuButon);
        buttons[1]=new Button(210,275,375,100,"Instructions",menuButon);
        buttons[2]=new Button(210,375,375,100,"Load",menuButon);
        buttons[3]=new Button(210,475,375,100,"Exit",menuButon);
    }

    public void draw(Graphics2D g2){
        g2.drawImage(menuBK,0,0, GamePanel.screenWidth,GamePanel.screenHeight,null);
        Font arial_48b=new Font("Arial",Font.BOLD,48);
        g2.setFont(arial_48b);
        g2.setColor(Color.black);
        g2.drawString("Evolution Hunt",220,125);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].draw(g2);

        }

    }
}
