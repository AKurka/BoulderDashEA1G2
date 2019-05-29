package model;

import contract.Permeability;
import contract.SpriteType;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Monster extends Sprite{
    public Monster(int x, int y){
        super();
        this.x = x;
        this.y = y;
        this.permeability = Permeability.KILL;
        this.type = SpriteType.MONSTER;

        try{
            image = ImageIO.read(new File("model/src/main/resources/image/monster.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
