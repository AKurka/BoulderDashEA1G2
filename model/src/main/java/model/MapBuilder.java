package model;

import contract.IMapBuilder;
import contract.ISprite;
import contract.SpriteType;

import java.awt.*;

public class MapBuilder implements IMapBuilder {
    private ISprite[][] sprites = new Sprite[15][15];
    private SpriteType map[][];
    private int x = 0;
    private int y = 0;
    private int ligne = 0;
    private int colonne = 0;

    public MapBuilder(Translation translation){
        this.map = translation.getMap();
    }

    public void mapCreation(final int SET_SIZE) {
        ligne = 0;
        for (SpriteType sousSpitTp[] : map) {
            x = 0;
            colonne = 0;
            for (SpriteType SpitTp : sousSpitTp) {
                switch (SpitTp) {
                    case WALL:
                        sprites[ligne][colonne] = new Wall(x, y);
                        break;
                    case DIRT:
                        sprites[ligne][colonne] = new Dirt(x, y);
                        break;
                    case BACKGROUND:
                        sprites[ligne][colonne] = new Background(x, y);
                        break;
                    case ROCK:
                        sprites[ligne][colonne] = new Rock(x, y);
                        break;
                    case DIAMOND:
                        sprites[ligne][colonne] = new Diamond(x, y);
                        break;
                    case BOULDER:
                        sprites[ligne][colonne] = new Character(x, y);
                        break;
                    case EXIT:
                        sprites[ligne][colonne] = new Exit(x, y);
                        break;
                    case MONSTER:
                        sprites[ligne][colonne] = new Monster(x, y);
                        break;
                    default:
                        break;
                }
                x = x + SET_SIZE;
                colonne++;
            }
            y = y + SET_SIZE;
            ligne++;
        }
    }

    public void drawMap(Graphics g) {
        for (ISprite[] sousSpit : sprites) {
            for (ISprite spit : sousSpit) {
                g.drawImage(spit.getImage(), spit.getX(), spit.getY(), null);
            }
        }
    }

    public ISprite getCharacter(int colonne, int ligne) {
        return sprites[ligne][colonne];
    }

    public void setSprites(ISprite[][] sprites) {
        this.sprites = sprites;
    }

    public void setAllHasMovedToFalse(ISprite[][] sprites) {
        for (ISprite sousSpit[] : sprites) {
            for (ISprite spit : sousSpit) {
                spit.setHasMoved(false);
            }
        }
    }
}
