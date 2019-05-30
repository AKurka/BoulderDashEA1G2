package contract.view;

import contract.controller.IOrderPerformer;
import contract.model.IBDModel;

public interface IView {

    void displayMessage(String message);

    void start(IBDModel model, IOrderPerformer order);
}
