package view;

import contract.model.IElement;
import contract.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Panel extends JPanel implements Observer {

    private IMaker maker;

    public Panel(IMaker maker, IModel model){
        this.maker = maker;
        for(int i = 0; i < model.getElements().length; i++) {
            for(int j = 0; j < model.getElements()[i].length; j++) {
                if(model.getElements()[i][j] != null) model.getElements()[i][j].setObserver(this);
            }
        }
        model.getBoulder().setObserver(this);
        for(IElement element: model.getMonster()) {
            element.setObserver(this);
        }
        repaint();
    }


    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

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
            JOptionPane.showMessageDialog(null, "End of the Game\n Score : "+String.valueOf(score));
            System.exit(0);
        }
    }
}
