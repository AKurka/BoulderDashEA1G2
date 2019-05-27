package model;

import contract.ISprite;
import contract.Permeability;
import contract.SpriteType;

import java.awt.*;

public class Sprite implements ISprite {
    protected Image image;
    protected int x;
    protected int y;
    protected Permeability permeability;
    protected SpriteType type;
    protected boolean hasMoved = false;
    private int direction = 0;


    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public Image getImage(){
        return image;
    }

    @Override
    public void setImage(Image image){
        this.image = image;
    }

    public Permeability getPermeability(){
        return permeability;
    }

    public void setPermeability(Permeability permeability){
        this.permeability = permeability;
    }

    public SpriteType getType(){
        return type;
    }

    public boolean isHasMoved(){
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved){
        this.hasMoved = hasMoved;
    }

    public int getDirection(){
        return direction;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }
}
