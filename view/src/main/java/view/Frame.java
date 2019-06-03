package view;

import contract.model.IModel;
import contract.view.IEventPerformer;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * <h1>The Class Frame provides the method to use the different keyboard interactions</h1>
 *
 * @author Groupe2
 */

public class Frame extends JFrame implements KeyListener {

    /** Allow to perform an element to the controller */
    private IEventPerformer eventPerformer;

    /**
     * Create the constructor of Frame
     * @param title
     * 		For the title of frame
     * @param eventPerformer
     *		For the event perform
     * @param maker
     *		Use for set what element to built
     * @param model
     * 		For set a model
     */
    public Frame(String title, IEventPerformer eventPerformer, IMaker maker, IModel model){
        this.setTitle(title);
        this.setSize(816, 518);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Panel panel = new Panel(maker, model);

        this.setContentPane(panel);

        model.observerAdd(panel);

        addKeyListener(this);

        this.eventPerformer = eventPerformer;

        this.setVisible(true);
    }

    /**
     * Use for research the key who is typed
     * @param e
     * 		Name of key event
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Use for research the key who is pressed
     * @param e
     * 		Name of key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        try{
            eventPerformer.eventPerformer(e);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * Use for research the key who is released
     * @param e
     * 		Name of key event
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
