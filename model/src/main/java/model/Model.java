package model;

import contract.model.IElement;
import contract.model.IModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <h1>The Class Moodel</h1>
 *
 * @author Groupe2
 */
public class Model extends Observable implements IModel {

    /** The  map who contains the elements */
    private Map map;

    /** The game over image*/
    private Image gameOver;

    /** True if the game is running, false in case of game over or win */
    private boolean game;

    /**
     * The score of the player
     */
    private int score;

    /**
     * Instantiates the Moodel.
     * @throws Exception
     * 		map exception
     */
    public Model() throws Exception{
        this.map = new Map(this);
        try {
            this.gameOver = ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/gameover.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.game = true;
    }

    /**
     * Gets the list of the elements
     * @return a list of the elements
     */
    @Override
    public IElement[][] getElements() {
        return this.map.getElements();
    }

    /**
     * Gets the map
     * @return the map of the model
     */
    private Map getMap(){
        return map;
    }

    /**
     * Adds an object to the list of the elements
     * @param element
     * 		element to add in the list
     */
    @Override
    public void addElement(IElement element) {
        this.map.setElement(element.getPosition().getX(), element.getPosition().getY(), element);
    }

    /**
     * Removes an object of the list of elements
     * @param element
     * 		element to remove of the list
     */
    @Override
    public void removeElement(IElement element) {
        this.map.setElement(element.getPosition().getX(), element.getPosition().getY(), null);
    }

    /**
     * The function which add observers
     * @param o
     */
    @Override
    public void observerAdd(Observer o) {
        addObserver(o);
    }

    /**
     * Permits to get an element by the position
     * @param x
     * @param y
     * @return
     */
    @Override
    public IElement getElementByPosition(int x, int y) {
        return this.map.getElements()[x][y];
    }

    /**
     * Add a diamond for the hero
     * @throws Exception
     * 		Destroy Exception
     *
     */
    @Override
    public void getDiamond(IElement element) throws Exception {
        Boulder boulder = Boulder.getInstance();
        this.map.destroyElement(element);
        boulder.setDiamonds(boulder.getDiamonds()+1);
        System.out.println(boulder.getDiamonds());
        this.effectiveChanged();
    }

    /**
     * Get the number of diamond get by the hero
     * @throws Exception
     * 		Destroy Exception
     */
    @Override
    public int diamondCounter() throws Exception {
        Boulder boulder = Boulder.getInstance();

        if(boulder == null){
            throw new Exception("You loose");

        }
        return this.score = boulder.getDiamonds();
    }

    /**
     * Get the boulder
     * @return
     */
    @Override
    public IElement getBoulder() {
        return this.getMap().getBoulder();
    }

    /**
     * Get the monsters from the tab
     * @return
     */
    @Override
    public CopyOnWriteArrayList<IElement> getMonster() {
        return this.getMap().getMonster();
    }

    /**
     * Get the gravity from the tab
     * @return
     */
    @Override
    public CopyOnWriteArrayList<IElement>getGravity() {
        return this.getMap().getGravity();
    }

    /**
     * Get the variable gameOver
     * @return
     */
    @Override
    public Image getGameOver() {
        return gameOver;
    }

    /**
     * Delete the observers
     * @param o
     */
    @Override
    public void observerDelete(Observer o) {
        //this.deleteObservers(o);
    }

    /**
     * Chech if the game is still on
     * @return
     */
    @Override
    public boolean isGame() {
        return game;
    }

    /**
     * Set the game
     * @param game
     */
    @Override
    public void setGame(boolean game) {
        this.game = game;
    }

    /**
     * Get the score of the player
     * @return
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * Notify the observers
     */
    public void effectiveChanged(){
        this.setChanged();
        this.notifyObservers();
    }
}
