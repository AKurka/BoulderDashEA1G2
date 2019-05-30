package view;

import contract.model.IBDModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Panel extends JPanel implements Observer {

    private static final long serialVersionUID = 2451228009089487119L;
    private IElementMaker elementMaker;

    public Panel(IElementMaker maker, IBDModel model){
        this.elementMaker = maker;
        repaint();
    }

    @Override
    public void update(Observable o, Object arg){
        repaint();
    }

    public void paintComponent(Graphics g){
        if(this.elementMaker.getModel().isGame()){
            try{
                this.elementMaker.applyModelToGraphics(g, this);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        if(!this.elementMaker.getModel().isGame()){
            this.elementMaker.getModel().observerDelete(this);
            int score = this.elementMaker.getModel().getScore();
            JOptionPane.showMessageDialog(null, "End of the Game\n Score : " +String.valueOf(score));
            System.exit(0);
        }
    }
}
