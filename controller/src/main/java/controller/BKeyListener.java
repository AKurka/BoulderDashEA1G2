package controller;

import contract.IBKeyListener;
import contract.IController;
import contract.UserOrder;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

public class BKeyListener extends Observable implements KeyListener, IBKeyListener{
    private IController controller;

    public UserOrder keyUserOrder(final int keyCode){
        UserOrder userOrder;

                switch (keyCode) {
                    case KeyEvent.VK_RIGHT:
                        userOrder = UserOrder.RIGHT;
                        break;

                    case KeyEvent.VK_LEFT:
                        userOrder = UserOrder.LEFT;
                        break;

                    case KeyEvent.VK_UP:
                        userOrder = UserOrder.UP;
                        break;

                    case KeyEvent.VK_DOWN:
                        userOrder = UserOrder.DOWN;
                        break;

                    default:
                        userOrder = UserOrder.NOOP;
                        break;
                }
                return userOrder;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.getController().setStackOrder(keyUserOrder(keyEvent.getKeyCode()));
        setChanged();
        notifyObservers(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent e){

    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    public IController getController(){
        return this.controller;
    }

    public void setController(IController controller){
        this.controller = controller;
    }
}
