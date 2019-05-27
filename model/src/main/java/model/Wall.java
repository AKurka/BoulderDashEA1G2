package model;

import contract.Permeability;
import contract.SpriteType;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Wall extends Sprite{

    public Wall(int x, int y){
        super();
        this.permeability = Permeability.BLOCKING;
        this.x = x;
        this.y = y;
        this.type = SpriteType.WALL;

        try{
            image = ImageIO.read(new File("image/wall.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
