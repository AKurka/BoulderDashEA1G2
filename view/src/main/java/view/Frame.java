package view;

import contract.model.IBDModel;
import contract.view.IPerformEvent;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {

    private static final long serialVersionUID = 3792052992605473420L;
    private IPerformEvent performerEvent;

    public Frame(String title, IPerformEvent perform, IElementMaker maker;IBDModel model){
        this.setTitle(title);
        this.setSize(1270, 790);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Panel panel = new Panel(maker, model);

        System.out.println("test");

        this.setContentPane(panel);

        model.observerAdd(panel);

        addKeyListener(this);

        this.performerEvent = perform;

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        try{
            performerEvent.performEvent(e);
        } catch(Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e){

    }
}
