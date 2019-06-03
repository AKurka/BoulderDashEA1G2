package contract.model;

import java.awt.*;
import java.util.Observer;

/**
 * <h1>The interface IElement</h1>
 *
 * @author Groupe2
 */

public interface IElement {

    /**
     * Gets the Position.
     * @return the position
     */
    Position getPosition();

    /**
     * Sets the position
     * @param position
     * 		Position of the element to set
     */
    void setPosition(Position position);

    /**
     * Gets the image of the element
     * @return the image
     */
    Image getImage();

    /**
     * Sets the image of the element
     * @param image
     *      image want to apply
     */
    void setImage(String image);

    /**
     * Get the move's comportment of the element
     * @return the comportment
     */
    IComportment getComportment();

    /**
     * Get the name of the element's image
     * @return the image name
     */
    String getImageName();

    /**
     * Get the direction of a element
     * @return the direction of the element
     */
    Direction getDirection();

    /**
     * Set the direction of a element
     * @param direction
     *      direction like up, down...
     */
    void setDirection(Direction direction);

}
