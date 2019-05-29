package model;

import contract.IAudio;
import contract.IPanel;
import contract.ISprite;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GoDown extends Move{

    public GoDown(ISprite[][] sprites, int SET_SIZE, IPanel panel){
        super(sprites, SET_SIZE, panel);
    }

    public ISprite[][] goDown(int colonne, int ligne, ISprite sprite, ISprite[][] sprites, IPanel panel, IAudio audio) {
        try {
            image = ImageIO.read(new File("/resources/image/down.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (nextToDiamond(sprites[ligne + 1][colonne])) {
            panel.setDiamondsGet(panel.getDiamondGet() + 1);
            audio.playSound(new File("music/move.wav"), 40.4f);
        }
        if (nextToExitOpen(sprites[ligne + 1][colonne])) {
            setVictory(true);
        }
        if (nextToMonster(sprites[ligne + 1][colonne])) {
            sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
            sprite.setY(sprite.getY() + 16);
            sprites[ligne + 1][colonne] = new Monster(sprite.getX(), sprite.getY());
            audio.playSound(new File("music/die.wav"), 40.4f);
            gameOver(true);
            return sprites;
        } else if (isSpriteOn(sprites[ligne + 1][colonne])) {
            audio.playSound(new File("music/dig.wav"), 40.4f);
            return sprites;
        } else {
            sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
            sprite.setY(sprite.getY() + 16);
            sprite.setImage(image);
            sprites[ligne + 1][colonne] = sprite;
            return sprites;
        }
    }
}
