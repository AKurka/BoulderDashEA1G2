package contract;

import java.awt.*;

public interface IMapBuilder {

    public void mapCreation(final int SET_SIZE);

    public void drawMap(Graphics g);

    public ISprite[][] getSprites();

    public void setSprites(ISprite[][] sprites);

    public void setAllHasMovedToFalse(ISprite[][] sprites);
}