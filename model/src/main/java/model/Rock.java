package model;

import contract.Permeability;
import contract.SpriteType;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Rock extends Sprite{

    public Rock(int x, int y){
        super();
        this.x = x;
        this.y = y;
        this.permeability = Permeability.BLOCKING;
        this.type = SpriteType.ROCK;

        try{
            image = ImageIO.read(new File("model/src/main/resources/image/rock.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
