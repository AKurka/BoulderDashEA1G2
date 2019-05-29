package model;

import contract.ISprite;
import contract.Permeability;
import contract.SpriteType;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Background extends Sprite implements ISprite {
   public Background(int x, int y){
       super();
       this.permeability = Permeability.PERMEABLE;
       this.x = x;
       this.y = y;
       this.type = SpriteType.BACKGROUND;

       try {
           image = ImageIO.read(new File("model/src/main/resources/image/back.png"));
       }
       catch (IOException e){
           e.printStackTrace();
       }
   }
}
