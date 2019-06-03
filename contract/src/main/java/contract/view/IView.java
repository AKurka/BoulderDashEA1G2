package contract.view;

import contract.controller.IOrderPerformer;
import contract.model.IModel;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Groupe2
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);

    /**
     * start the game view
     * @param model
     *      Get actual Model
     * @param order
     *      Get the order
     */
    void start(IModel model, IOrderPerformer order);

}
