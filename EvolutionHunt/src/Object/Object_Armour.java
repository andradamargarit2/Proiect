package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Object_Armour extends SuperObject {

    public Object_Armour(){
        name="armour";

        try{
            image= ImageIO.read((getClass().getResourceAsStream("/res/lvl1_spritesheet.png"))).getSubimage(0,0,52,52);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
