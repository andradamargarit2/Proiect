package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Object_Telephone extends SuperObject{
    public Object_Telephone(){
        name="telephone";

        try{
            image= ImageIO.read((getClass().getResourceAsStream("/res/lvl2_spritesheet.png"))).getSubimage(2*52,3*52,52,52);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
