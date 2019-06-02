package model;

import contract.model.IElement;
import contract.model.Position;

import java.util.Iterator;

public class Gravity extends Comportment{

    private boolean motion = false;

    public Gravity(Element element){
        super(element);
    }

    public void gravity() throws Exception{
        Iterator<IElement>iterator = this.element.getMap().getGravity().iterator();
        while (iterator.hasNext()){
            iterator.next().getComportment().move();
        }
    }

    @Override
    public void move() throws Exception{
        IElement down = element.getMap().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];
        IElement downr = element.getMap().getElements()[element.getPosition().getX()+1][element.getPosition().getY()+1];
        IElement right = element.getMap().getElements()[element.getPosition().getX()+1][element.getPosition().getY()];
        IElement downl = element.getMap().getElements()[element.getPosition().getX()-1][element.getPosition().getY()+1];
        IElement left = element.getMap().getElements()[element.getPosition().getX()-1][element.getPosition().getY()];

        if(down.getClass() == Background.class){
            this.motion = true;
            this.element.getComportment().moveDown();
        }
        if(down.getClass() != Background.class && left.getClass() == Background.class && downl.getClass() == Background.class && (down.getClass() == Diamond.class || down.getClass() == Rock.class)){
            this.motion = true;
            this.element.getComportment().moveLeft();
            this.element.getComportment().moveDown();
        }

        if(down.getClass() != Background.class && right.getClass() == Background.class && downr.getClass() == Background.class && (down.getClass() == Diamond.class || down.getClass() == Rock.class)){
            this.motion = true;
            this.element.getComportment().moveRight();
            this.element.getComportment().moveDown();
        }
        if(down.getClass() != Background.class && down.getClass() == Monster.class) {
            IElement monster = element.getMap().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];

            int x = monster.getPosition().getX();
            int y = monster.getPosition().getY();
            int xMax = monster.getPosition().getXMax();
            int yMax = monster.getPosition().getYMax();

            this.element.getMap().destroyElement(monster);

            IElement diamond = new Diamond(new Position(x,y,xMax,yMax),Monster.map);

            this.element.getMap().setElement(x, y, diamond);

            this.element.getMap().addGravity(diamond);
        }
        if(down.getClass() != Background.class && down.getClass() == Boulder.class && this.motion == true) {

            Boulder.getInstance().destroy();

        }
        if(down.getClass() != Background.class){
            this.motion = false;
        }
    }
}
