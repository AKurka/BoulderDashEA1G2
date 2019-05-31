package model;

import contract.model.IElement;
import contract.model.IModel;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

public class Model extends Observable implements IModel {

    private Map map;

    private Image gameOver;

    private boolean game;

    private int score;

    public Model(){
        this.map = new Map(this);
        this.gameOver = Element.loadImage("gameover");
        this.game = true;
    }

    @Override
    public IElement[][] getElements() {
        return this.map.getElements();
    }

    @Override
    public void addElement(IElement element) {
        this.map.setElement(element.getPosition().getX(), element.getPosition().getY(), element);
    }

    @Override
    public void removeElement(IElement element) {
        this.map.setElement(element.getPosition().getX(), element.getPosition().getY(), null);
    }

    @Override
    public void observerAdd(Observer o) {
        addObserver(o);
    }

    @Override
    public IElement getElementByPosition(int x, int y) {
        return this.map.getElements()[x][y];
    }

    @Override
    public void getDiamond(IElement element) throws Exception {
        Boulder boulder = Boulder.getInstance();
        this.map.destroyElement(element);
        boulder.setDiamond(boulder.getDiamond()+1);
        System.out.println(boulder.getDiamond());
        this.hasChanged();
    }

    @Override
    public int diamondCounter() throws Exception {
        return 0;
    }

    @Override
    public IElement getBoulder() {
        return null;
    }

    @Override
    public CopyOnWriteArrayList<IElement> getMonster() {
        return null;
    }

    @Override
    public CopyOnWriteArrayList<IElement> getGravity() {
        return null;
    }

    @Override
    public Image getGameOver() {
        return null;
    }

    @Override
    public void observerDelete(Observer o) {

    }

    @Override
    public boolean isGame() {
        return false;
    }

    @Override
    public void setGame(boolean game) {

    }

    @Override
    public int getScore() {
        return 0;
    }
}
