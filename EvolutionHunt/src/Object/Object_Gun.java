package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Object_Gun extends SuperObject {
    public Object_Gun(){
        name="gun";

        try{
            image= ImageIO.read((getClass().getResourceAsStream("/res/lvl1_spritesheet.png"))).getSubimage(2*52,0,52,52);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
