package contract.model;

import java.awt.*;

public interface IElement {

    Position getPosition();

    void setPosition(Position position);

    Image getImage();

    void setImage(String image);

    IComportment getComportment();

    String getImageName();

    Direction getDirection();

    void setDirection(Direction direction);
}
