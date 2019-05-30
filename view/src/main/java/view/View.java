package view;

import contract.controller.IOrderPerformer;
import contract.model.IBDModel;
import contract.view.IPerformEvent;
import contract.view.IView;

public class View implements Runnable, IView {

    private IPerformEvent performEvent;
    private IElementMaker elementMaker;
    private IOrderPerformer OrderPerformer;
    private IBDModel model;

    public BDView(){}

    public void start(IBDModel model, IOrderPerformer orderPerformer){
        this.OrderPerformer = orderPerformer;
        this.model = model;
        this.run();
    }

    @Override
    public void displayMessage(String message){

    }

    @Override
    public void run(){
        this.performEvent = new PerformEvent(OrderPerformer);
        this.elementMaker = new ElementMaker(this.model);
        new Frame("BoulderDash", this.performEvent, elementMaker, model);
    }
}
