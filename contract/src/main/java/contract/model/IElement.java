package contract.model;

import java.awt.*;

public interface IElement {

    Position getPosition();

    void setPosition(Position position);

    Image getSprite();

    void setSprite(String sprite);

    IComportmentMove getComportment();

    String getSpriteType();

    Direction getDirection();

    void setDirection(Direction direction);
}
