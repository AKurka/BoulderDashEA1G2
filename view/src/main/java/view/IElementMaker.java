package view;

import contract.model.IBDModel;

import java.awt.*;
import java.awt.image.ImageObserver;

public interface IElementMaker {

    void applyModelToGraphic(Graphics graphics, ImageObserver obs) throws Exception;

    IBDModel getModel();
}
