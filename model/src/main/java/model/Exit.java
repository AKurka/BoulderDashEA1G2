package model;

import contract.Permeability;
import contract.SpriteType;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Exit extends Sprite{
    public Exit(int x, int y){
        super();
        this.x = x;
        this.y = y;
        this.permeability = Permeability.BLOCKING;
        this.type = SpriteType.EXIT;

        try{
            image = ImageIO.read(new File("image/exit.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
