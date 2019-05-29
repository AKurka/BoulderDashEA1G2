package model;

import contract.Permeability;
import contract.SpriteType;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Character extends Sprite{
    public Character(int x, int y){
        super();
        this.permeability = Permeability.PERMEABLE;
        this.x = x;
        this.y = y;
        this.type = SpriteType.BOULDER;
        try{
            image = ImageIO.read(new File("model/src/main/resources/image/boulder.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
