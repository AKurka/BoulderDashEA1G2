package model;

import contract.IPanel;
import contract.ISprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GoLeft extends Move {

    public GoLeft(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
        super(sprites, SET_SIZE, panel);
    }

    public ISprite[][] goLeft(int colonne, int ligne, ISprite sprite, ISprite[][] sprites, IPanel panel) {
        try {
            image = ImageIO.read(new File("image/left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (nextToDiamond(sprites[ligne][colonne - 1])) {
            panel.setDiamondsGet(panel.getDiamondGet() + 1);
        }
        if (nextToExitOpen(sprites[ligne][colonne - 1])) {
            setVictory(true);
        }
        if (nextToMonster(sprites[ligne][colonne - 1])) {
            sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
            sprite.setX(sprite.getX() - 16);
            sprites[ligne][colonne - 1] = new Monster(sprite.getX(), sprite.getY());
            gameOver(true);
            return sprites;
        }
        if (nextToRock(sprites[ligne][colonne - 1]) && nextToBack(sprites[ligne][colonne - 2])) {
            sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
            sprite.setX(sprite.getX() - 16);
            sprite.setImage(image);
            sprites[ligne][colonne - 1] = sprite;
            sprites[ligne][colonne - 2] = new Rock((sprite.getX() - 16), sprite.getY());
            return sprites;
        } else if (isSpriteOn(sprites[ligne][colonne - 1])) {
            return sprites;
        }

        else {
            sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
            sprite.setX(sprite.getX() - 16);
            sprite.setImage(image);
            sprites[ligne][colonne - 1] = sprite;
            return sprites;
        }

    }
}
