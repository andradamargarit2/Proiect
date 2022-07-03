package Menu;

import DataBase.DataBase;
import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {
    public int x,y;
    public int width,height;
    public String label;
    public BufferedImage menuButon;

    public Button(int x, int y, int width, int height, String label,BufferedImage menuButon) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = label;
        this.menuButon=menuButon;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial",Font.BOLD,50));
        g2.drawImage(menuButon,getX(),getY(),getWidth(),getHeight(),null);


        FontMetrics fm=g2.getFontMetrics();
        int stringX=(getWidth()-fm.stringWidth(getLabel()))/2;
        int stringY=(fm.getAscent()+(getHeight()-(fm.getAscent()+fm.getDescent()))/2);
        g2.drawString(getLabel(),stringX+getX(),stringY+getY());

    }

    public void triggerEvent(){
        if(getLabel().toLowerCase().contains("start")){
            GamePanel.playing=true;
        }
        else if(getLabel().toLowerCase().contains("load")){
            GamePanel.playing=true;
            DataBase.load();
            if(GamePanel.level==2){
                GamePanel.tileM.loadMap("/Map/map2.txt");
                GamePanel.aSetter.setObject();
            }
            for(int i=0; i<GamePanel.Obiecte.length;i++){
                if(GamePanel.Obiecte[i]==1)
                    GamePanel.obj[i]=null;
            }
            GamePanel.player.getPlayerImage();

        }
        else if(getLabel().toLowerCase().contains("exit")){
            DataBase.save();
            System.exit(0);
        }
        else if(getLabel().toLowerCase().contains("resume")){
            GamePanel.playing=true;
        }
        else if(getLabel().toLowerCase().contains("new game")){
          GamePanel.newGame=true;
          GamePanel.playing=true;

        }
        else if(getLabel().toLowerCase().contains("instructions")){
            GamePanel.instructions=true;

        }
        else if(getLabel().toLowerCase().contains("return")){
            GamePanel.instructions=false;

        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
