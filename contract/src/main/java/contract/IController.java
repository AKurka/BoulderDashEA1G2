package contract;

public interface IController {

    public void directionControl() throws InterruptedException;

    public void setStackOrder(final UserOrder userOrder);
}
