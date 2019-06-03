package view;

import contract.model.IElement;
import contract.model.IModel;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Maker implements IMaker{

    private IModel model;

    public Maker(IModel model){
        this.model = model;
    }

    private void drawMap(Graphics g, ImageObserver obs){
        IElement[][] actual = model.getElements();
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 30; y++) {

                if(model.getBoulder() == null){
                    return;
                }
                else{
                    drawElement(actual[x][y],g, obs);
                }

            }
        }
    }

    private void drawElement(IElement element, Graphics g, ImageObserver obs){
        Graphics2D g2d = (Graphics2D) g ;
        System.out.println(element);
        if(element != null) g2d.drawImage(element.getImage(),element.getPosition().getX()*16,element.getPosition().getY()*16,null);

        Font fonte = new Font("TimeRoman", Font.BOLD, 32);
        g2d.setFont(fonte);
        g2d.setColor(Color.BLACK);

        try {
            g2d.drawString("Diamond : "+ this.model.diamondCounter(), 32, 750);
        } catch (Exception e) {
            g2d.drawString("Diamond :", 32, 956);
        }
    }

    @Override
    public void applyModelToGraphic(Graphics g, ImageObserver obs){
        drawMap(g, obs);
    }

    public IModel getModel(){
        return model;
    }
}
