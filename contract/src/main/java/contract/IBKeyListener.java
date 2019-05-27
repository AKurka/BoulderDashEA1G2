package contract;

public interface IBKeyListener {

    public UserOrder keyUserOrder(final int keyCode);

    public IController getController();

    public void setController(IController controller);
}
