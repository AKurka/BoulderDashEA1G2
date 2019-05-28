package contract;

import java.util.Observable;

public interface IController {

    public void directionControl() throws InterruptedException;

    public void setStackOrder(final UserOrder userOrder);

    void update(Observable obs, Object obj);
}
