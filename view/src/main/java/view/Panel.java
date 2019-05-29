package view;

import contract.IMapBuilder;
import contract.IPanel;
import model.MapBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Panel extends JPanel implements Serializable, IPanel {
    private static final long serialVersionUID = 1L;
    protected Image buffer[][] = new Image[15][15];
    private int diamondGet = 0;
    private IMapBuilder builder;
    private int finalDiamonds = 0;

    public Panel(MapBuilder builder, int finalDiamonds){
        this.builder = builder;
        this.finalDiamonds = finalDiamonds;
    }

    public void counterDiamond(Graphics g){
        g.setColor(Color.black);
        g.drawString("Diamonds : " + diamondGet, 10, 365);
    }

    public void updateCount(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(0,0,800,500);
    }

    public void paintComponent(Graphics g){
        this.updateCount(g);
        this.counterDiamond(g);
        this.builder.drawMap(g);
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
