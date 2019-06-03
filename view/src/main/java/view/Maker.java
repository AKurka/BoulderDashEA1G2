package view;

import contract.model.IElement;
import contract.model.IModel;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * <h1>The class Maker</h1>
 *
 * @author Groupe2
 */

public class Maker implements IMaker{

    /** crate a variable model come from IBoulderDashModel*/
    private IModel model;

    /**
     * instantiate Model
     * @param model
     * 		Set the actual model
     */
    public Maker(IModel model){
        this.model = model;
    }

    /**
     * method use for draw the visual of our mine. Set in a double enter tab all element.
     * If an element "null" exist, replace it by a black rectangle who sizes is 32*32.
     * @param g
     * 		Set the graphics where to draw
     * @param obs
     * 		Use the observer
     */
    private void drawMap(Graphics g, ImageObserver obs){
        IElement[][] actual = model.getElements();
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 30; y++) {

                if(model.getBoulder() == null){
                    return;
                }
                else{
                    drawElement(actual[x][y],g, obs);
                }

            }
        }
    }

    /**
     * place in a graphics who name's g2d, all element
     * After add some features in our program. In particularly the number of diamond get by the hero
     * @param element
     * 		The element to draw
     * @param g
     * 		The graphics where draw
     * @param obs
     * 		Use an observer
     */
    private void drawElement(IElement element, Graphics g, ImageObserver obs){
        Graphics2D g2d = (Graphics2D) g ;
        System.out.println(element);
        if(element != null) g2d.drawImage(element.getImage(),element.getPosition().getX()*16,element.getPosition().getY()*16,null);

        Font fonte = new Font("TimeRoman", Font.BOLD, 20);
        g2d.setFont(fonte);
        g2d.setColor(Color.RED);

        try {
            g2d.drawString("Diamond : "+ this.model.diamondCounter(), 32, 50);
        } catch (Exception e) {
            g2d.drawString("Diamond :", 32, 32);
        }
    }

    /**
     * @see IMaker
     * @param g
     * 		Use a graphics to draw
     * @param obs
     * 		Use the observer
     */
    @Override
    public void applyModelToGraphic(Graphics g, ImageObserver obs){
        drawMap(g, obs);
    }

    /**
     * @return model
     */
    public IModel getModel(){
        return model;
    }
}
