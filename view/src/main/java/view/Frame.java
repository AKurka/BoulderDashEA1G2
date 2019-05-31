package view;

import contract.model.IModel;
import contract.view.IEventPerformer;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {

    private IEventPerformer eventPerformer;

    public Frame(IEventPerformer eventPerformer, IMaker maker, IModel model){
        this.setTitle("BoulderDash Remastered G2");
        this.setSize(1270, 790);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Panel panel = new Panel(maker, model);

        this.setContentPane(panel);

        model.observerAdd(panel);

        addKeyListener(this);

        this.eventPerformer = eventPerformer;


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        try{
            eventPerformer.eventPerformer(e);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
