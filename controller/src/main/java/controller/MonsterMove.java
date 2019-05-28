package controller;

import contract.IAudio;
import contract.IMonsterMove;
import contract.ISprite;
import contract.SpriteType;
import model.Background;

import java.io.File;

public class MonsterMove implements IMonsterMove {
    private int ligne = 0;
    private int colonne = 0;
    private boolean gameOver = false;

    public ISprite[][] toMoveMonsters(ISprite[][] sprites, IAudio audio){
        ligne = 0;
        for(ISprite sousSpit[] : sprites){
            colonne = 0;
            for(ISprite spit : sousSpit){
                if((spit.getType() == SpriteType.MONSTER)){
                    if((isSpriteNearToBackground(sprites[ligne + 1][colonne])
                    || isSpriteNearToBackground(sprites[ligne - 1][colonne])
                    || isSpriteNearToCharacter(sprites[ligne + 1][colonne])
                    || isSpriteNearToCharacter(sprites[ligne - 1][colonne])
                    && !sprites[ligne][colonne].isHasMoved())){
                        if(isSpriteNearToCharacter(sprites[ligne + 1][colonne]) && spit.getDirection() == 2){
                            sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
                            spit.setY(spit.getDirection() + 16);
                            spit.setHasMoved(true);
                            sprites[ligne + 1][colonne] = spit;
                            audio.playSound(new File("music/die.wav"), 30.0f);
                            gameOver();
                        }
                        else if(isSpriteNearToCharacter(sprites[ligne - 1][colonne]) && spit.getDirection() == 1){
                            sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
                            spit.setY(spit.getDirection() - 16);
                            spit.setHasMoved(true);
                            sprites[ligne - 1][colonne] = spit;
                            audio.playSound(new File("music/die.wav"), 30.0f);
                            gameOver();
                        }
                        else if (spit.getDirection() == 1){
                            if(sprites[ligne - 1][colonne].getType() == SpriteType.BACKGROUND){
                                MoveUp(sprites, spit);
                            } else {
                                MoveDown(sprites, spit);
                            }
                        } else if (spit.getDirection() == 2){
                            if(sprites[ligne + 1][colonne].getType() == SpriteType.BACKGROUND){
                                MoveDown(sprites, spit);
                            } else {
                                MoveUp(sprites, spit);
                            }
                        } else if (isSpriteNearToBackground(sprites[ligne + 1][colonne])){
                            MoveDown(sprites, spit);
                        } else if (isSpriteNearToBackground(sprites[ligne - 1][colonne])){
                            MoveUp(sprites, spit);
                        }
                    }
                }
                colonne++;
            }
            ligne++;
        }
        return sprites;
    }

    public ISprite[][] MoveUp(ISprite[][] sprites, ISprite spit){
        sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
        spit.setY(spit.getY() - 16);
        spit.setHasMoved(true);
        spit.setDirection(1);
        sprites[ligne - 1][colonne] = spit;
        return sprites;
    }

    public ISprite[][] MoveDown(ISprite[][] sprites, ISprite spit) {
        sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
        spit.setY(spit.getY() + 16);
        spit.setHasMoved(true);
        spit.setDirection(2);
        sprites[ligne + 1][colonne] = spit;
        return sprites;
    }

    public Boolean isSpriteNearToBackground(ISprite sprites){
        return sprites.getType() == SpriteType.BACKGROUND;
    }

    public Boolean isSpriteNearToCharacter(ISprite sprites){
        return sprites.getType() == SpriteType.BOULDER;
    }

    public void gameOver(){
        gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
