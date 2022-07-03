package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Object_Button extends  SuperObject{
    public Object_Button(){
        name="button";

        try{
            image= ImageIO.read((getClass().getResourceAsStream("/res/lvl2_spritesheet.png"))).getSubimage(4*52,52,52,26);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
