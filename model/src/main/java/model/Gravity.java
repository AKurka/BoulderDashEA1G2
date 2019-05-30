package model;

import contract.model.IElement;
import contract.model.Position;

import java.awt.*;
import java.util.Iterator;

public class Gravity extends ComportmentMove{

    private boolean motion = false;

    public Gravity(Element element){
        super(element);
    }

    public void Gravit() throws Exception{
        Iterator<IElement> iterator = this.element.getMine().getGravity().iterator();
        while (iterator.hasNext()){
            iterator.next().getComportment().move();
        }
    }

    @Override
    public void move() throws Exception{

        IElement down = element.getMine().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];
        IElement downr = element.getMine().getElements()[element.getPosition().getX()+1][element.getPosition().getY()+1];
        IElement right = element.getMine().getElements()[element.getPosition().getX()+1][element.getPosition().getY()];
        IElement downl = element.getMine().getElements()[element.getPosition().getX()-1][element.getPosition().getY()+1];
        IElement left = element.getMine().getElements()[element.getPosition().getX()-1][element.getPosition().getY()];

        if(down.getClass() == model.Back.class){
            this.motion = true;
            this.element.getComportment().moveDown();
        }
        if(down.getClass() != model.Back.class && left.getClass() == model.Back.class && downl.getClass() == model.Back.class && (down.getClass() == model.Diamond.class || down.getClass() == model.Rock.class)){
            this.motion = true;
            this.element.getComportment().moveLeft();
            this.element.getComportment().moveDown();
        }

        if(down.getClass() != model.Back.class && right.getClass() == model.Back.class && downr.getClass() == model.Back.class && (down.getClass() == model.Diamond.class || down.getClass() == model.Rock.class)){
            this.motion = true;
            this.element.getComportment().moveRight();
            this.element.getComportment().moveDown();
        }
        if(down.getClass() != model.Back.class && down.getClass() == model.Monster.class) {
            IElement monster = element.getMine().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];

            int x = monster.getPosition().getX();
            int y = monster.getPosition().getY();
            int xMax = monster.getPosition().getMaxX();
            int yMax = monster.getPosition().getMaxY();

            this.element.getMine().destroyElement(monster);

            IElement diamond = new Diamond(new Position(x,y,xMax,yMax),Monster.mine);

            this.element.getMine().setElement(x, y, diamond);

            this.element.getMine().addGravity(diamond);
        }
        if(down.getClass() != model.Back.class && down.getClass() == model.Boulder.class && this.motion == true) {

            Boulder.getInstance().explosion();

        }
        if(down.getClass() != model.Back.class){
            this.motion = false;
        }
    }
}
