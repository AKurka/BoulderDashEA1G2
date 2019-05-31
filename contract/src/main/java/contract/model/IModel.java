package contract.model;


import java.awt.*;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

public interface IModel {

    IElement[][] getElement();

    void addElement(IElement element);

    void removeElement(IElement element);

    void observerAdd(Observer o);

    IElement getElementByPosition(int x, int y);

    void getDiamond(IElement element) throws Exception;

    int diamondCounter() throws Exception;

    IElement getBoulder();

    CopyOnWriteArrayList<IElement> getMonster();

    CopyOnWriteArrayList<IElement> getGravity();

    Image getGameOver();

    void observerDelete(Observer o);

    boolean isGame();

    void setGame(boolean game);

    int getScore();
}
