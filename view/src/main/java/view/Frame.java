package view;

import contract.IBKeyListener;
import contract.IFrame;
import contract.IMapBuilder;
import contract.IPanel;
import model.MapBuilder;
import contract.IBKeyListener;

import javax.swing.*;
import java.awt.event.KeyListener;


public class Frame extends JFrame implements IFrame {
    private Panel panel;
    int finalDiamonds;


    public Frame(MapBuilder builder, IBKeyListener listener, int finalDiamonds, int title){
        this.finalDiamonds = finalDiamonds;
        this.setTitle("BoulderDashRemastered level" + title);
        this.setSize(660, 420);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
        this.addKeyListener((KeyListener) listener);

        panel = new Panel(builder, finalDiamonds);

        this.setContentPane(panel);
        this.setVisible(true);
    }

    public IPanel getPanel(){
        return panel;
    }


}
