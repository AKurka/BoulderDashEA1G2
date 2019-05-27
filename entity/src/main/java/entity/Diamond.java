package entity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Diamond extends Sprite{

    public Diamond(int x, int y){
        super();
        this.permeability = Permeability.PERMEABLE;
        this.x = x;
        this.y = y;
        this.type = SpriteType.BOULDER;

        try{
            image = ImageIO.read(new File("image/diamond.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
