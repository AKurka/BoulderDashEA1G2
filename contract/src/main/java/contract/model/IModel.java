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
     * @return
     */
    IElement[][] getElements();

    /**
     * Add elements on the tab
     * @param element
     */
    void addElement(IElement element);

    /**
     * Remove element from the tab
     * @param element
     */
    void removeElement(IElement element);

    /**
     * Add an observer
     * @param o
     */
    void observerAdd(Observer o);

    /**
     * Get an element by the position in the tab
     * @param x
     * @param y
     * @return
     */
    IElement getElementByPosition(int x, int y);

    /**
     * Get diamonds from the tab
     * @param element
     * @throws Exception
     */
    void getDiamond(IElement element) throws Exception;

    /**
     * The count of the diamonds caught by the player
     * @return
     * @throws Exception
     */
    int diamondCounter() throws Exception;

    /**
     * Get the boulder from the tab
     * @return
     */
    IElement getBoulder();

    /**
     * Get monsters from the tab
     * @return
     */
    CopyOnWriteArrayList<IElement> getMonster();

    /**
     * Get the gravity from the tab
     * @return
     */
    CopyOnWriteArrayList<IElement> getGravity();

    /**
     * Get the variable gameOver
     * @return
     */
    Image getGameOver();

    /**
     * Delete the observer
     * @param o
     */
    void observerDelete(Observer o);

    /**
     * Get if the game is still on
     * @return
     */
    boolean isGame();

    /**
     * set the variable game
     * @param game
     */
    void setGame(boolean game);

    /**
     * get the score of the player
     * @return
     */
    int getScore();
}
