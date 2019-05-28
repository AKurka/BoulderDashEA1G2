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

    public ISprite[][] toMoveMonsters(ISprite[][] sprites, IAudio audio){
        ligne = 0;
        for(ISprite sousSpit[] : sprites){
            colonne = 0;
            for(ISprite spit : sousSpit){
                if((spit.getType() == SpriteType.MONSTER)){
                    if((isSpriteNearToBackground(sprites[ligne + 1][colonne])
                    || isSpriteNearToBackground(sprites[ligne - 1][colonne])
                    || isSprteNearToCharacter(sprites[ligne + 1][colonne])
                    || isSpriteNearToCharacter(sprites[ligne - 1][colonne])
                    && !sprites[ligne][colonne].isHasMoved())){
                        if(isSpriteNearToCharacter(sprites[ligne + 1][colonne]) && spit.getDirection() == 2){
                            sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
                            spit.setY(spit.getDirection() + 16);
                            spit.setHasMoved(true);
                            sprites[ligne + 1][colonne] = spit;
                            audio.playSound(new File("music/die.wav"), 30.0f);

                        }
                    }
                }
            }
        }
    }

}
