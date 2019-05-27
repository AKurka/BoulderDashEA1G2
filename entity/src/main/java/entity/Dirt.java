package entity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Dirt extends Sprite{
    public Dirt(int x, int y){
        super();
        this.permeability = Permeability.PERMEABLE;
        this.x = x;
        this.y = y;
        this.type = SpriteType.DIRT;

        try{
            image = ImageIO.read(new File("image/dirt.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
