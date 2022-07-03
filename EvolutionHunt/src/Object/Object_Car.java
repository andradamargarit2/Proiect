package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Object_Car extends SuperObject{
    public Object_Car(){
        name="car";

        try{
            image= ImageIO.read((getClass().getResourceAsStream("/res/lvl2_spritesheet.png"))).getSubimage(52,3*52,52,52);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
