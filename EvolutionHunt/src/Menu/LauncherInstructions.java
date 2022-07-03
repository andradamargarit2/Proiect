package Menu;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LauncherInstructions extends Launcher {
    public BufferedImage instr,menuButon;
    public Button button;

    public LauncherInstructions() throws IOException {
        instr= ImageIO.read(getClass().getResourceAsStream("/Instructions.png"));
        menuButon= ImageIO.read(getClass().getResourceAsStream("/menuBUTON.png"));
        button=new Button(550,650,200,100,"Return",menuButon);

    }
    public void draw(Graphics2D g2) {

        g2.drawImage(instr, 0, 0, GamePanel.screenWidth, GamePanel.screenHeight, null);
        button.draw(g2);
    }
    }

