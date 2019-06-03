package view;

import contract.controller.IOrderPerformer;
import contract.controller.Order;
import contract.view.IEventPerformer;

import java.awt.event.KeyEvent;
/**
 * <h1>The class EventPerformer</h1>
 *
 * @author Groupe2
 */
public class EventPerformer implements IEventPerformer {

    /** Allow to perform an element to the controller */
    private IOrderPerformer orderPerformer;

    /**
     * Instantiate EventPerformer
     * @param orderPerformer
     * 		Set what order is perform
     */
    public EventPerformer(IOrderPerformer orderPerformer){
        this.orderPerformer = orderPerformer;
    }

    /**
     * do a action in function of what command type by the player
     * @param keyCode
     * 		the key code of the order
     * @throws Exception
     * 		Order perform exception
     */
    private void keyCodeUser(int keyCode) throws Exception{
        switch (keyCode){
            case KeyEvent.VK_DOWN :
                this.orderPerformer.orderPerformer(Order.DOWN);
                break;
            case KeyEvent.VK_UP :
                this.orderPerformer.orderPerformer(Order.UP);
                break;
            case KeyEvent.VK_RIGHT :
                this.orderPerformer.orderPerformer(Order.RIGHT);
                break;
            case KeyEvent.VK_LEFT :
                this.orderPerformer.orderPerformer(Order.LEFT);
                break;
        }
    }

    /**
     * @see IEventPerformer
     * @param keyEvent
     * 		The key code of the event
     * @throws Exception
     * 		the exception of key code
     */
    @Override
    public void eventPerformer(KeyEvent keyEvent) throws Exception {
        this.keyCodeUser(keyEvent.getKeyCode());
    }
}
