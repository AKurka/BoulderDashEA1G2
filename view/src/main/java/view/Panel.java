package view;

import contract.model.IElement;
import contract.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * <h1>The class Panel</h1>
 *
 * @author Groupe2
 */

public class Panel extends JPanel implements Observer {

    /** Print the different model's element on the screen */
    private IMaker maker;


    /**
     * Instantiate the panel and repaint it
     * @param maker
     * @param model
     */
    public Panel(IMaker maker, IModel model){
        this.maker = maker;
        repaint();
    }


    /**
     * the method create from Observable
     * @param o
     * 		observable name
     * @param arg
     * 		object name to update
     */
    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    /**
     * allows to paint the component on the frame
     * @param g
     * 		name the graphic
     */
    @Override
    public void paintComponent(Graphics g){
        if(this.maker.getModel().isGame()){
            try {
                this.maker.applyModelToGraphic(g, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(!this.maker.getModel().isGame()) {
            this.maker.getModel().observerDelete(this);
            int score = this.maker.getModel().getScore();
            JOptionPane.showMessageDialog(null, "End of the Game\n Score : "+ score);
            System.exit(0);
        }
    }
}
