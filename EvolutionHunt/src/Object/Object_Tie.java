package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Object_Tie extends SuperObject{
    public Object_Tie(){
        name="tie";

        try{
            image= ImageIO.read((getClass().getResourceAsStream("/res/lvl2_spritesheet.png"))).getSubimage(0,3*52,52,52);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
