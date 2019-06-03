package model;

import contract.model.Direction;
import contract.model.IComportment;
import contract.model.IElement;
import contract.model.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Element implements IElement {

    private Position position;

    private Image image;

    Comportment comportment;

    private Map map;

    private String ImageName;

    Direction direction;

    public Element(Position position, String image, Map map){
        this.position = position;
        this.ImageName = image;
        this.image = loadImage(this.ImageName);
        this.map = map;
    }

    public Image loadImage(String image){
        String path = "img/" +image+".png";
        try {
            return ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    public Map getMap(){
        return this.map;
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public void setImage(String image) {
        this.image = loadImage(image);
        this.ImageName = image;
    }

    @Override
    public IComportment getComportment() {
        return this.comportment;
    }

    @Override
    public String getImageName() {
        return ImageName;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    public void setComportment(Comportment comportment) {
        this.comportment = comportment;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
