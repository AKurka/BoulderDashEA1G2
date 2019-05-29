package model;

import contract.IAudio;
import contract.IPanel;
import contract.ISprite;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GoRight extends Move {

    public GoRight(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
        super(sprites, SET_SIZE, panel);
    }

    public ISprite[][] goRight(int colonne, int ligne, ISprite sprite, ISprite[][] sprites, IPanel panel, IAudio audio) {
        try {
            image = ImageIO.read(new File("/resources/image/right.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (nextToDiamond(sprites[ligne][colonne + 1])) {
            panel.setDiamondsGet(panel.getDiamondGet() + 1);
            audio.playSound(new File("music/move.wav"), 40.4f);
        }
        if (nextToExitOpen(sprites[ligne][colonne + 1])) {
            setVictory(true);
        }
        if (nextToMonster(sprites[ligne][colonne + 1])) {
            sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
            sprite.setX(sprite.getX() + 16);
            sprites[ligne][colonne + 1] = new Monster(sprite.getX(), sprite.getY());
            audio.playSound(new File("music/die.wav"), 40.4f);
            gameOver(true);
            return sprites;
        }
        if (nextToRock(sprites[ligne][colonne + 1]) && nextToBack(sprites[ligne][colonne + 2])) {
            sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
            sprite.setX(sprite.getX() + 16);
            sprite.setImage(image);
            sprites[ligne][colonne + 1] = sprite;
            sprites[ligne][colonne + 2] = new Rock((sprite.getX() + 16), sprite.getY());
            return sprites;
        } else if (isSpriteOn(sprites[ligne][colonne + 1])) {
            audio.playSound(new File("music/dig.wav"), 40.4f);
            return sprites;
        }

        else {
            sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
            sprite.setX(sprite.getX() + 16);
            sprite.setImage(image);
            sprites[ligne][colonne + 1] = sprite;
            return sprites;
        }
    }
}
