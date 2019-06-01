package model;

import contract.model.Direction;
import contract.model.IComportment;
import contract.model.IElement;
import contract.model.Position;

import java.awt.*;

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

    public static Image loadImage(String image){
        String path = "resources/images/"+image+".png";

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image result = toolkit.getImage(path);

        if(result == null){
            System.out.println("Error loading image");
        }
        return result;
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
