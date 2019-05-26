package view;

import contract.IPanel;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Panel extends JPanel implements Serializable, IPanel {
    private static final long serialVersionUID = 1L;
    protected Image buffer[][] = new Image[22][40];
    private int diamondGet = 0;
    private IMapMaker maker;
    private int finalDiamonds;

    public Panel(MapMaker maker, int finalDiamonds){
        this.maker = maker;
        this.finalDiamonds = finalDiamonds;
    }

    public void counterDiamond(Graphics g){
        g.setColor(Color.black);
        g.drawString("Diamonds : " + diamondGet, 10, 365);
    }

    public void paintComponent(Graphics g){
        this.updateCount(g);
        this.counterDiamond(g);
        this.maker.drawMap(g);
    }

    @Override
    public void update(){
        this.repaint();
    }

    public int getDiamondGet(){
        return diamondGet;
    }

    public void setDiamondsGet(int diamondGet){
        this.diamondGet = diamondGet;
    }
}
