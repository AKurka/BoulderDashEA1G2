package view;

import contract.controller.IOrderPerformer;
import contract.controller.Order;
import contract.view.IEventPerformer;

import java.awt.event.KeyEvent;

public class EventPerformer implements IEventPerformer {

    private IOrderPerformer orderPerformer;

    public EventPerformer(IOrderPerformer orderPerformer){
        this.orderPerformer = orderPerformer;
    }

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

    @Override
    public void eventPerformer(KeyEvent keyEvent) throws Exception {
        this.keyCodeUser(keyEvent.getKeyCode());
    }
}
