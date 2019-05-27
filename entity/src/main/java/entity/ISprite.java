package entity;

import entity.Permeability;
import entity.SpriteType;

import java.awt.*;

public interface ISprite {

    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    Image getImage();

    void setImage(Image image);

    Permeability getPermeability();

    void setPermeabilty(Permeability permeabilty);

    SpriteType getType();

    boolean isHasMoved();

    void setHasMoved(boolean hasMoved);

    int getDirection();

    void setDirection(int direction);
}
