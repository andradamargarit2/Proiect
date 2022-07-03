package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Object_Fire extends SuperObject {
    public Object_Fire(){
        name="fire";

        try{
            image= ImageIO.read((getClass().getResourceAsStream("/res/lvl1_spritesheet.png"))).getSubimage(52,0,52,52);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
