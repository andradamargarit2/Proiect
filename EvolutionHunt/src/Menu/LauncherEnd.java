package Menu;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LauncherEnd extends Launcher{
    public BufferedImage menuBK,menuButon;
    public Button[] buttons;

    public LauncherEnd() throws IOException {
        menuBK= ImageIO.read(getClass().getResourceAsStream("/menuBK.png"));
        menuButon= ImageIO.read(getClass().getResourceAsStream("/menuBUTON.png"));
        buttons=new Button[2];
        buttons[0]=new Button(210,375,375,100,"New Game",menuButon);
        buttons[1]=new Button(210,475,375,100,"Exit",menuButon);
    }

    public void draw(Graphics2D g2){

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].draw(g2);
        }

    }
}
