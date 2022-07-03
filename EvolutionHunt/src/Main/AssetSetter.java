package Main;
import Object.*;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }

    public void setObject(){
        if(GamePanel.level==0) {
            gp.obj[0] = new Object_Armour();
            gp.obj[0].wordX = 12 * gp.tileSize;
            gp.obj[0].wordY = 2 * gp.tileSize;

            gp.obj[1] = new Object_Fire();
            gp.obj[1].wordX = 1 * gp.tileSize;
            gp.obj[1].wordY = 5 * gp.tileSize;

            gp.obj[2] = new Object_Gun();
            gp.obj[2].wordX = 12 * gp.tileSize;
            gp.obj[2].wordY = 8 * gp.tileSize;

            gp.obj[3] = new Object_Door1();
            gp.obj[3].wordX = 1 * gp.tileSize;
            gp.obj[3].wordY = 13 * gp.tileSize;
        }
        if(GamePanel.level==1 || GamePanel.level==2) {
            gp.obj[0] = new Object_Tie();
            gp.obj[0].wordX = 13 * gp.tileSize;
            gp.obj[0].wordY = 2 * gp.tileSize;

            gp.obj[1] = new Object_Telephone();
            gp.obj[1].wordX = 1 * gp.tileSize;
            gp.obj[1].wordY = 5 * gp.tileSize;

            gp.obj[2] = new Object_Car();
            gp.obj[2].wordX = 13 * gp.tileSize;
            gp.obj[2].wordY = 7 * gp.tileSize;

            gp.obj[3] = new Object_Door2();
            gp.obj[3].wordX = 1 * gp.tileSize;
            gp.obj[3].wordY = 13 * gp.tileSize;
        }


    }

}
