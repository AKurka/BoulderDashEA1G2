package view;

import contract.IMapBuilder;
import contract.IPanel;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Panel extends JPanel implements Serializable, IPanel {
    private static final long serialVersionUID = 1L;
    protected Image buffer[][] = new Image[15][15];
    private int diamondGet = 0;
    private IMapBuilder maker;
    private int finalDiamonds = 0;

    public Panel(IMapBuilder maker, int finalDiamonds){
        this.maker = maker;
        this.finalDiamonds = finalDiamonds;
    }

    public void counterDiamond(Graphics g){
        g.setColor(Color.black);
        g.drawString("Diamonds : " + diamondGet, 10, 365);
    }

    public void paintComponent(Graphics g){
        this.update(g);
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
