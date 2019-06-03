package view;

import contract.model.IModel;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 *
 * @author Groupe2
 */

public interface IMaker {

    /**
     * Translate The Model into Graphic
     * @param graphics
     * 		Name of the graphic
     * @param obs
     * 		Name of observer
     * @throws Exception
     * 		The exception
     */
    void applyModelToGraphic(Graphics graphics, ImageObserver obs) throws Exception;

    /**
     * Get the model
     * @return the model
     */
    IModel getModel();
}
