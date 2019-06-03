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

    /** The position of the element */
    private Position position;

    /** The sprite of the element  */
    private Image image;

    /** The move comportment of the element */
    Comportment comportment;

    /** The map that contains the element */
    private Map map;

    /** The sprite's name of the element */
    private String ImageName;

    /** Direction of the element */
    Direction direction;

    /**
     * Instantiates a new Element
     * @param position
     * 		Position of the Element
     */
    public Element(Position position, String image, Map map){
        this.position = position;
        this.ImageName = image;
        this.image = loadImage(this.ImageName);
        this.map = map;
    }

    /**
     * Get the sprite in the database
     * @param image
     * 		The sprite's name to load
     * @return the sprite's image
     */
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


    /**
     * Gets the Position.
     * @return the position
     */
    @Override
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the position
     * @param position
     * 		Position of the element to set
     */
    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Get the element's map
     * @return the map
     */
    public Map getMap(){
        return this.map;
    }

    /**
     * Gets the sprite of the element
     * @return the sprite
     */
    @Override
    public Image getImage() {
        return this.image;
    }

    /**
     * Sets the sprite of the element
     */
    @Override
    public void setImage(String image) {
        this.image = loadImage(image);
        this.ImageName = image;
    }

    /**
     * Gets the movement comportement of the element
     * @return the behavior of move
     */
    @Override
    public IComportment getComportment() {
        return this.comportment;
    }

    /**
     * Get the name of the sprite's element
     * @return The name of the sprite
     */
    @Override
    public String getImageName() {
        return ImageName;
    }

    /**
     * Get the direction of the element
     */
    @Override
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Sets the movement behavior of the element
     * @param comportment
     * 		The movement comportment to set
     */
    public void setComportment(Comportment comportment) {
        this.comportment = comportment;
    }

    /**
     * Set the direction to the element
     * @param direction
     * 		The direction to set
     */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
