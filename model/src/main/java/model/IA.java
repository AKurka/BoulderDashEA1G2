package model;

import contract.model.Direction;
import contract.model.IElement;

import java.util.Iterator;

public class IA extends Comportment {

    public IA(Element element){
        super(element);
    }

    @Override
    public void moveAll() throws Exception{
        Iterator<IElement> iterator = this.element.getMap().getMonster().iterator();
        while (iterator.hasNext()) {
            iterator.next().getComportment().move();
        }
    }

    @Override public void move() throws Exception{
        Direction direction = this.element.getDirection();

        switch (direction){
            case LEFT:
                this.goLeft();
                break;
            case RIGHT:
                this.goRight();
                break;
            case UP:
                this.goUp();
                break;
            case DOWN:
                this.goDown();
                break;
        }
    }

    private void goLeft() throws Exception{
        IElement left = element.getMap().getElements()[element.getPosition().getX()-1][element.getPosition().getY()];

        if(left.getClass() == Background.class){
            this.element.getComportment().moveLeft();
        }
        else if(left.equals(Boulder.getInstance())){
            this.element.getComportment().moveLeft();
            Boulder.getInstance().destroy();
        }
        else{
            this.element.setDirection(Direction.DOWN);
        }
    }

    private void goRight() throws Exception{

        IElement right = element.getMap().getElements()[element.getPosition().getX()+1][element.getPosition().getY()];

        if(right.getClass() == Background.class){
            this.element.getComportment().moveRight();
        }
        else if(right.equals(Boulder.getInstance())){
            this.element.getComportment().moveRight();
            Boulder.getInstance().destroy();
        }
        else{
            this.element.setDirection(Direction.UP);
        }
    }


    private void goUp() throws Exception{

        IElement up = element.getMap().getElements()[element.getPosition().getX()][element.getPosition().getY()-1];

        if(up.getClass() == Background.class){
            this.element.getComportment().moveUp();
        }
        else if(up.equals(Boulder.getInstance())){
            this.element.getComportment().moveUp();
            Boulder.getInstance().destroy();
        }
        else{
            this.element.setDirection(Direction.LEFT);
        }
    }

    private void goDown() throws Exception{

        IElement up = element.getMap().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];

        if(up.getClass() == Background.class){
            this.element.getComportment().moveDown();
        }
        else if(up.equals(Boulder.getInstance())){
            this.element.getComportment().moveDown();
            Boulder.getInstance().destroy();
        }
        else{
            this.element.setDirection(Direction.RIGHT);
        }
    }
}
