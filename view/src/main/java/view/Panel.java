package view;

import contract.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Panel extends JPanel implements Observer {

    private IMaker maker;

    public Panel(IMaker maker, IModel model){
        this.maker = maker;
        repaint();
    }


    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

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
            JOptionPane.showMessageDialog(null, "End of the Game\n Score : "+String.valueOf(score));
            System.exit(0);
        }
    }
}
