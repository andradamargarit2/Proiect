package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Object_Door1 extends SuperObject {

    public Object_Door1(){
        name="door1";

        try{
            image= ImageIO.read((getClass().getResourceAsStream("/res/lvl1_spritesheet.png"))).getSubimage(5*52,0,52,52);

        }catch(IOException e){
            e.printStackTrace();
        }

        collision=true;
    }
}
