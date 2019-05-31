package view;

import contract.model.IModel;

import java.awt.*;
import java.awt.image.ImageObserver;

public interface IMaker {

    void applyModelToGraphic(Graphics graphics, ImageObserver obs) throws Exception;

    IModel getModel();
}
