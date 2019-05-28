package controller;

import contract.*;
import model.MapBuilder;
import model.Move;
import view.Audio;
import view.Frame;

import java.io.File;
import java.util.Observable;

public class Controller implements IController {
    private UserOrder stackOrder = UserOrder.NOOP;
    private int SET_SIZE = 0, colonne = 0, ligne = 0, finalDiamonds = 0;
    private IPanel panel;
    private ISprite sprite;
    private MapBuilder builder;
    private Move move;
    private Gravity gravity;
    private Frame frame;
    private MonsterMove monsterMove;

    private Audio backSound;
    private Audio start;
    private Audio gravitySounds;
    private Audio moveSounds;
    private Audio gameOver;
    private Audio victory;
    private End end;

    public Controller(ISprite sprite, IPanel panel, int SET_SIZE, MapBuilder builder, Frame frame, int finalDiamonds){
        this.panel = panel;
        this.sprite = sprite;
        this.SET_SIZE = SET_SIZE;
        this.builder = builder;
        this.frame = frame;
        this.finalDiamonds = finalDiamonds;

        move = new Move(builder.getSprites(), SET_SIZE, frame.getPanel());
        gravity = new Gravity();
        monsterMove = new MonsterMove();
        backSound = new Audio();
        backSound.playSound(new File("music/jeu.wav"), -20.0f);
        start = new Audio();
        start.playSound(new File("music/new.wav"), 40.0f);
        gravitySounds = new Audio();
        moveSounds = new Audio();
        gameOver = new Audio();
        victory = new Audio();
        end = new End(this.panel, this.frame);
    }

    public final void directionControl() throws InterruptedException {
        if (sprite.getType() == SpriteType.BOULDER) {

            Thread.sleep(50);
            builder.setAllHasMovedToFalse(builder.getSprites());
            move.setVictory(false);
            move.gameOver(false);

            colonne = sprite.getX() / SET_SIZE;
            ligne = sprite.getY() / SET_SIZE;

            switch (this.getStackOrder()) {
                case RIGHT:
                    builder.setSprites(move.goRight(colonne, ligne, sprite, moveSounds));
                    break;
                case LEFT:
                    builder.setSprites(move.goLeft(colonne, ligne, sprite, moveSounds));
                    break;
                case DOWN:
                    builder.setSprites(move.goDown(colonne, ligne, sprite, moveSounds));
                    break;
                case UP:
                    builder.setSprites(move.goUp(colonne, ligne, sprite, moveSounds));
                    break;
                case NOOP:
                default:
                    break;
            }
            gravity.makeThemFall(builder.getSprites(), gravitySounds);

            if (move.isGameOver()) {
                backSound.stopSound();
                end.gameOver();
            }

            monsterMove.MoveMonsters(builder.getSprites(), gravitySounds);

            if (gravity.isGameOver() || monsterMove.isGameOver()) {
                backSound.stopSound();
                end.gameOver();
            }

            if (panel.getDiamondGet() >= finalDiamonds) {
                setExitToPermeable(builder.getSprites());
            }

            if (move.isVictory()) {
                backSound.stopSound();
                end.victory();
                victory.stopSound();
            }
            stackOrder = UserOrder.NOOP;
            panel.update();
        }
    }

    public UserOrder getStackOrder(){
        return stackOrder;
    }

    public void setStackOrder(UserOrder stackOrder){
        this.stackOrder = stackOrder;
    }

    @Override
    public void update(Observable obs, Object obj){
        if(obs instanceof BKeyListener){
            try{
                directionControl();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    public void setExitToPermeable(ISprite[][] sprites) {
        for (ISprite[] sousSpit : sprites) {
            for (ISprite spit : sousSpit) {
                if (spit.getType() == SpriteType.EXIT) {
                    spit.setPermeability(Permeability.PERMEABLE);
                }
            }
        }
    }

}
