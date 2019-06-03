package view;

import contract.controller.IOrderPerformer;
import contract.model.IModel;
import contract.view.IEventPerformer;
import contract.view.IView;

/**
 * <h1>The class View</h1>
 *
 * @author Groupe 2
 */

public class View  implements Runnable, IView {

    /** Allow to perform an element to the controller */
    private IEventPerformer eventPerformer;

    /** Print the different model's element on the screen */
    private IMaker maker;

    /** The controller */
    private IOrderPerformer orderPerformer;

    /** The model, principal data of the game */
    private IModel model;

    /**
     * Instantiate a new View
     */
    public View(){

    }

    /**
     * @see IView
     * @param message
     *      the message to display
     */
    @Override
    public void displayMessage(String message) {

    }

    /**
     * Set the current model and take the actual order
     * @param model
     * 		Use for set the actual model
     * @param orderPerformer
     *      Use for set the order perform
     */
    public void start(IModel model, IOrderPerformer orderPerformer){
        this.orderPerformer = orderPerformer;
        this.model = model;
        this.run();
    }


    /**
     * @see Runnable
     */
    @Override
    public void run() {
        this.eventPerformer = new EventPerformer(this.orderPerformer);
        this.maker = new Maker(this.model);
        new Frame("BoulderDash", this.eventPerformer, maker, model);
    }
}
