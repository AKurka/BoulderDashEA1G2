package entity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Boulder extends Sprite{
    public Boulder(int x, int y){
        super();
        this.permeability = Permeability.PERMEABLE;
        this.x = x;
        this.y = y;
        this.type = SpriteType.BOULDER;
        try{
            image = ImageIO.read(new File("image/boulder.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
