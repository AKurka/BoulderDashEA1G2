package model;

import contract.model.IBDModel;
import contract.model.IElement;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

public class BDModel extends Observable implements IBDModel {

    private Mine mine;
    private Image gameOver;
    private boolean game;
    private int score;

    public BDModel() throws Exception{
        this.mine = new Mine(this);
        this.gameOver = Element.loadSprite("gameover");
        this.game = true;
    }

    @Override
    public IElement[][] getElement(){
        return this.mine.getElement();
    }

    @Override
    public IElement[][] getElementPosition(int x, int y){
        return this.mine.getElement()[x][y];
    }

    @Override
    synchronized public void addElement(IElement element){
        this.mine.setElement(element.getPosition().getX(), element.getPosition().getY(), element);
    }

    @Override
    synchronized public void removeElement(IElement element){
        this.mine.setElement(element.getPosition().getX(), element.getPosition().getY(), null);
    }

    public void effectiveChanged(){
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    synchronized public void getDiamond(IElement element) throws Exception{
        Boulder boulder = Boulder.getInstance();
        this.mine.destructionElement(element);
        boulder.setDiamonds(boulder.getDiamonds()+1);
        System.out.println(boulder.getDiamonds());
        this.effectiveChanged();
    }

    @Override
    public int diamondCounter() throws Exception{
        Boulder boulder = Boulder.getInstance();

        if(boulder == null)
            throw new Exception("Hero is dead");
        return this.score = boulder.getDiamonds();
    }

    @Override
    public IElement getBoulder(){
        return this.getMine().getBoulder();
    }

    @Override
    synchronized public CopyOnWriteArrayList<IElement> getMonster(){
        return this.getMine().getMonster();
    }

    @Override
    synchronized public CopyOnWriteArrayList<IElement> getGravity(){
        return this.getMine().getGravity();
    }

    private Mine getMine(){
        return mine;
    }

    public void setMine(Mine mine){
        this.mine = mine;
    }

    @Override
    public void observerAdd(Observer o){
        addObserver(o);
    }

    @Override
    public void observerDelete(Observer o){
        this.deleteObserver(o);
    }

    @Override
    public Image getGameOver() {
        return gameOver;
    }

    @Override
    public boolean isGame() {
        return game;
    }

    @Override
    public void setGame(boolean game) {
        this.game = game;
    }

    @Override
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
