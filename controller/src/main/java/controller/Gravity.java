package controller;

import contract.IAudio;
import contract.ISprite;
import contract.SpriteType;
import model.Background;
import model.Move;
import model.Sprite;

public class Gravity {
    private int ligne = 0;
    private int colonne = 0;
    private boolean gameOver = false;

    public ISprite[][] makeThemFall(ISprite[][] sprites, IAudio audio) {
        ligne = 0;
        for (ISprite sousSpit[] : sprites) {
            colonne = 0;
            for (ISprite spit : sousSpit) {
                if ((spit.getType() == SpriteType.DIAMOND || spit.getType() == SpriteType.ROCK)) {
                    if (isNextToBack(sprites[ligne + 1][colonne]) || isNextToMonster(sprites[ligne + 1][colonne])) {
                        sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
                        spit.setY(spit.getY() + 16);
                        spit.setHasMoved(true);
                        sprites[ligne + 1][colonne] = spit;
                    } else if (isNextToCharacter(sprites[ligne + 1][colonne]) && spit.isHasMoved()) {
                        sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
                        spit.setY(spit.getY() + 16);
                        spit.setHasMoved(true);
                        sprites[ligne + 1][colonne] = spit;
                        audio.playSound("music/die.wav", 40.0f);
                        gameOver();
                    }
                }
                colonne++;
            }
            ligne++;
        }
        return sprites;

    }

    public Boolean isNextToBack(ISprite sprite){
        return sprite.getType() == SpriteType.BACKGROUND;
    }

    public Boolean isNextToMonster(ISprite sprite){
        return sprite.getType() == SpriteType.MONSTER;
    }

    public Boolean isNextToCharacter(ISprite sprite){
        return sprite.getType() == SpriteType.BOULDER;
    }

    public void gameOver(){
        gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
