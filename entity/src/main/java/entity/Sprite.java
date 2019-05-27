package entity;

import java.awt.*;

public class Sprite implements ISprite{
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


}
