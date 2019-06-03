package model;

import contract.model.IElement;
import contract.model.IModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
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
        try {
            this.gameOver = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/gameover.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.game = true;
    }

    @Override
    public IElement[][] getElements() {
        return this.map.getElements();
    }

    private Map getMap(){
        return map;
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
        boulder.setDiamonds(boulder.getDiamonds()+1);
        System.out.println(boulder.getDiamonds());
        this.effectiveChanged();
    }

    @Override
    public int diamondCounter() throws Exception {
        Boulder boulder = Boulder.getInstance();

        if(boulder == null){
            throw new Exception("You loose");

        }
        return this.score = boulder.getDiamonds();
    }

    @Override
    public IElement getBoulder() {
        return this.getMap().getBoulder();
    }

    @Override
    public CopyOnWriteArrayList<IElement> getMonster() {
        return this.getMap().getMonster();
    }

    @Override
    public CopyOnWriteArrayList<IElement>getGravity() {
        return this.getMap().getGravity();
    }

    @Override
    public Image getGameOver() {
        return gameOver;
    }

    @Override
    public void observerDelete(Observer o) {
        //this.deleteObservers(o);
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

    public void effectiveChanged(){
        this.setChanged();
        this.notifyObservers();
    }
}
