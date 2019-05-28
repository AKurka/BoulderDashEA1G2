package model;

import contract.*;

import java.awt.*;

public class Move implements IMove {

    protected ISprite[][] sprites;
    protected int SET_SIZE;
    protected IPanel panel;
    protected static boolean gameOver = false;
    protected static boolean victory = false;
    protected Image image;

    public Move(ISprite[][] sprites, int SET_SIZE, IPanel panel){
        this.sprites = sprites;
        this.SET_SIZE = SET_SIZE;
        this.panel = panel;
    }

    public ISprite[][] goLeft(int colonne, int ligne, ISprite sprite, IAudio audio) {
        GoLeft left = new GoLeft(sprites, ligne, panel);
        return left.goLeft(colonne, ligne, sprite, this.sprites, this.panel, audio);
    }

    public ISprite[][] goRight(int colonne, int ligne, ISprite sprite, IAudio audio) {
        GoRight right = new GoRight(sprites, ligne, panel);
        return right.goRight(colonne, ligne, sprite, this.sprites, this.panel, audio);
    }

    public ISprite[][] goUp(int colonne, int ligne, ISprite sprite, IAudio audio) {
        GoUp up = new GoUp(sprites, ligne, panel);
        return up.goUp(colonne, ligne, sprite, this.sprites, this.panel, audio);
    }

    public ISprite[][] goDown(int colonne, int ligne, ISprite sprite, IAudio audio) {
        GoDown down = new GoDown(sprites, ligne, panel);
        return down.goDown(colonne, ligne, sprite, this.sprites, this.panel, audio);
    }

    public Boolean isSpriteOn(ISprite sprite){
        return sprite.getPermeability() == Permeability.BLOCKING;
    }

    public Boolean nextToDiamond(ISprite sprite){
        return sprite.getType() == SpriteType.DIAMOND;
    }

    public Boolean nextToMonster(ISprite sprite){
        return sprite.getType() == SpriteType.MONSTER;
    }

    public Boolean nextToBack(ISprite sprite){
        return  sprite.getType() == SpriteType.BACKGROUND;
    }

    public Boolean nextToRock(ISprite sprite){
        return sprite.getType() == SpriteType.ROCK;
    }

    public Boolean nextToExitOpen(ISprite sprite){
        return (sprite.getType() == SpriteType.EXIT && sprite.getPermeability() == Permeability.PERMEABLE);
    }

    public void gameOver(boolean gameOver){
        Move.gameOver = gameOver;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public boolean isVictory(){
        return victory;
    }

    public void setVictory(boolean victory){
        Move.victory = victory;
    }
}
