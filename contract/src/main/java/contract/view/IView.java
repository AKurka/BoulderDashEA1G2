package contract.view;

import contract.controller.IOrderPerformer;
import contract.model.IModel;

public interface IView {

    void displayMessage(String message);

    void start(IModel model, IOrderPerformer order);

}
