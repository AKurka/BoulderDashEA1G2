package controller;

import contract.controller.IOrderPerformer;
import contract.controller.Order;
import contract.model.IElement;
import contract.model.IModel;
import contract.view.IView;

public class Controller implements IOrderPerformer {

    private IModel model;

    private IView view;

    private IElement boulder;

    private IElement monster;

    private IElement gravity;

    public Controller(IModel model, IView view){
        this.model = model;
        this.view = view;
    }

    public void play() throws Exception{
        this.view.start(this.model, this);
        this.boulder = this.model.getBoulder();
    }

















    @Override
    public void orderPerformer(Order order) throws Exception {

    }
}
