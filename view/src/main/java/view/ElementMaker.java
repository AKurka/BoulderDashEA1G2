package view;

import contract.model.IBDModel;
import contract.model.IElement;

import java.awt.*;
import java.awt.image.ImageObserver;

public class ElementMaker implements IElementMaker {

    private IBDModel model;

    public ElementMaker(IBDModel BDModel){
        this.model = BDModel;
    }

    private void drawMine(Graphics graphics, ImageObserver obs){

        IElement[][] actual = model.getElement();

        for(int x = 0, x < 50, x++){
            for(int y = 0; y < 30; y++){
                if(model.getBoulder() == null){
                    return;
                } else {
                    elementDraw(actual[x][y], graphics, obs);
                }
            }
        }
    }

    private void drawElement(IElement element, Graphics graphics, ImageObserver obs){

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(element.getSprite(), element.getPosition().getX()*25, element.getPosition().getY()*25,25, 25, obs);

        Font font = new Font("TimeRoman", Font.BOLD, 32);
        graphics2D.setFont(font);
        graphics2D.setColor(Color.BLACK);

        try {
            graphics2D.drawString("Diamond :" +String.valueOf(this.model.diamondCounter()), 32, 750);
        } catch (Exception e){
            graphics2D.drawString("Diamond :", 32, 956);
        }
    }

    @Override
    public void applyModelToGraphic(Graphics graphics, ImageObserver obs) {
        drawMine(graphics, obs);
    }

    public IBDModel getModel(){
        return model;
    }
}
