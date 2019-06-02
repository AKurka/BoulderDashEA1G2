package view;

import contract.controller.IOrderPerformer;
import contract.model.IModel;
import contract.view.IEventPerformer;
import contract.view.IView;

public class View  implements Runnable, IView {

    private IEventPerformer eventPerformer;

    private IMaker maker;

    private IOrderPerformer orderPerformer;

    private IModel model;

    public View(){

    }

    @Override
    public void displayMessage(String message) {

    }

    public void start(IModel model, IOrderPerformer orderPerformer){
        this.orderPerformer = orderPerformer;
        this.model = model;
        this.run();
    }


    @Override
    public void run() {
        this.eventPerformer = new EventPerformer(this.orderPerformer);
        this.maker = new Maker(this.model);
        new Frame("BoulderDash", this.eventPerformer, maker, model);
    }
}
