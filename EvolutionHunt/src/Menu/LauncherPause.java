package Menu;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LauncherPause {
    public BufferedImage menuBK,menuButon;
    public Button[] buttons;

    public LauncherPause() throws IOException {
        menuBK= ImageIO.read(getClass().getResourceAsStream("/menuBK.png"));
        menuButon= ImageIO.read(getClass().getResourceAsStream("/menuBUTON.png"));
        buttons=new Button[4];
        buttons[0]=new Button(210,125,375,100,"Resume",menuButon);
        buttons[1]=new Button(210,225,375,100,"New Game",menuButon);
        buttons[2]=new Button(210,325,375,100,"Instructions",menuButon);
        buttons[3]=new Button(210,425,375,100,"Exit",menuButon);
    }

    public void draw(Graphics2D g2){

        g2.drawImage(menuBK,0,0, GamePanel.screenWidth,GamePanel.screenHeight,null);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].draw(g2);

        }

    }
}
