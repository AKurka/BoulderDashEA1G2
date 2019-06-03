package contract.model;

/**
 *  <h1>The interface of Model</h1>
 *
 * @author Groupe2
 *
 */

import java.awt.*;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

public interface IModel {

    /**
     * Get all elements from the tab
     * @return all the elements
     */
    IElement[][] getElements();

    /**
     * Add elements on the tab
     * @param element all the elements
     */
    void addElement(IElement element);

    /**
     * Remove element from the tab
     * @param element all the elements
     */
    void removeElement(IElement element);

    /**
     * Add an observer
     * @param o the observer
     */
    void observerAdd(Observer o);

    /**
     * Get an element by the position in the tab
     * @param x the x coordinate
     * @param y the y coordinate
     * @return an element by his position
     */
    IElement getElementByPosition(int x, int y);

    /**
     *
     * @param element all the elements
     * @throws Exception
     */
    void getDiamond(IElement element) throws Exception;

    /**
     * The count of the diamonds caught by the player
     * @return the number of diamonds
     * @throws Exception
     */
    int diamondCounter() throws Exception;

    /**
     * Get the boulder from the tab
     * @return the boulder instance
     */
    IElement getBoulder();

    /**
     * Get monsters from the tab
     * @return the monsters instances
     */
    CopyOnWriteArrayList<IElement> getMonster();

    /**
     * Get the gravity from the tab
     * @return the gravity instances
     */
    CopyOnWriteArrayList<IElement> getGravity();

    /**
     * Get the variable gameOver
     * @return the variable gameOver
     */
    Image getGameOver();

    /**
     * Delete the observer
     * @param o the observer
     */
    void observerDelete(Observer o);

    /**
     * Get if the game is still on
     * @return the variable game
     */
    boolean isGame();

    /**
     * set the variable game
     * @param game the game
     */
    void setGame(boolean game);

    /**
     * get the score of the player
     * @return the score of the player
     */
    int getScore();
}
