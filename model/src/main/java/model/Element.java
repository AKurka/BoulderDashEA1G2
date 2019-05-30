package model;

import contract.model.Direction;
import contract.model.IElement;
import contract.model.Position;

import java.awt.*;

public class Element implements IElement {

    private Position position;
    private Image Sprite;
    ComportmentMove comportment;
    private Mine mine;
    private String SpriteType;
    Direction direction;

    Element(Position position, String sprite, Mine mine){
        this.position = position;
        this.SpriteType = sprite;
        this.Sprite = loadSprite(this.SpriteType);
        this.mine = mine;
    }

    public static Image loadSprite(String sprite){
        String path = "model/image/"+sprite+".png";
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image result = toolkit.getImage(path);

        if(result == null){
            System.out.println("error");
        }

        return result;
    }

    @Override
    public Position getPosition(){
        return this.position;
    }

    @Override
    public void setPosition(Position position){
        this.position = position;
    }

    public Mine getMine(){
        return this.mine;
    }

    @Override
    public Image getSprite(){
        return this.Sprite;
    }

    @Override
    public void setSprite(String sprite){
        this.Sprite = loadSprite(sprite);
        this.SpriteType = sprite;
    }

    @Override
    public String getSpriteType(){
        return SpriteType;
    }

    public ComportmentMove getComportment(){
        return this.comportment;
    }

    public void setCommportment(ComportmentMove comportment){
        this.commportment = commportment;
    }

    @Override
    public Direction getDirection(){
        return direction;
    }

    @Override
    public void setDirection(Direction direction){
        this.direction = direction;
    }
}
