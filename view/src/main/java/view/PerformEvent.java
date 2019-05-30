package view;

import contract.controller.IOrderPerformer;
import contract.controller.Order;
import contract.view.IPerformEvent;

import java.awt.event.KeyEvent;

public class PerformEvent implements IPerformEvent {

    private IOrderPerformer orderPerformer;

    public PerformEvent(IOrderPerformer orderPerformer){
        this.orderPerformer = orderPerformer;
    }

    private void keyCodeToUserOrder(int keycode) throws Exception{
        switch (keycode){
            case KeyEvent.VK_DOWN :
                this.orderPerformer.OrderPerform(Order.DOWN);
                break;
            case KeyEvent.VK_UP :
                this.orderPerformer.OrderPerform(Order.UP);
                break;
            case KeyEvent.VK_RIGHT :
                this.orderPerformer.OrderPerform(Order.RIGHT);
                break;
            case KeyEvent.VK_LEFT :
                this.orderPerformer.OrderPerform(Order.LEFT);
                break;
        }
    }

    @Override
    public void eventPerform(KeyEvent keyCode) throws Exception{
        this.keyCodeToUserOrder(keyCode.getKeyCode());
    }
}
