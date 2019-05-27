package controller;

import contract.IFrame;
import contract.IPanel;

import javax.swing.*;

public class End {
    private IPanel panel;
    private IFrame frame;

    public End(IPanel panel, IFrame frame){
        this.panel = panel;
        this.frame = frame;
    }

    public void gameOver(){
        panel.update();
        JOptionPane.showMessageDialog(null, "Game Over !");
    }

    public void victory(){
        panel.update();
        JOptionPane.showMessageDialog(null, "Victoire !");
    }
}
