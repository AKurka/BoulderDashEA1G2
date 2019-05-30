package model;

import contract.model.Direction;
import contract.model.IElement;

import java.util.Iterator;

public class Automatic extends ComportmentMove {

    public Automatic(Element element){
        super(element);
    }

    @Override
    public void moveAll() throws Exception {
        Iterator<IElement> iterator = this.element.getMine().getMonster().iterator();
        while (iterator.hasNext()){
            iterator.next().getComportment().move();
        }
    }

    @Override
    synchronized public void move() throws Exception{

        Direction dir = this.element.getDirection();

        switch (dir){
            case LEFT :
                this.goLeft();
                break;
            case RIGHT :
                this.goRight();
                break;
            case UP :
                this.goUp();
                break;
            case DOWN :
                this.goDown();
                break;
        }
    }

    private void goRight() throws Exception{

        IElement right = element.getMine().getElements()[element.getPosition().getX()+1][element.getPosition().getY()];

        if(right.getClass() == model.Back).class){
            this.element.getComportment().moveRight();
        } else if (right.equals(Boulder.getInstance())){
            this.element.getComportment().moveRight();
            Boulder.getInstance().explosion();
        }
        else {
            this.element.setDirection(Direction.UP);
        }
    }

    private void goLeft() throws Exception{

        IElement left = element.getMine().getElements()[element.getPosition().getX()-1][element.getPosition().getY()];

        if(left.getClass() == model.Back).class){
            this.element.getComportment().moveLeft();
        } else if (left.equals(Boulder.getInstance())){
            this.element.getComportment().moveLeft();
            Boulder.getInstance().explosion();
        }
        else {
            this.element.setDirection(Direction.DOWN);
        }
    }

    private void goDown() throws Exception{

        IElement down = element.getMine().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];

        if(down.getClass() == model.Back).class){
            this.element.getComportment().moveDown();
        } else if (down.equals(Boulder.getInstance())){
            this.element.getComportment().moveDown();
            Boulder.getInstance().explosion();
        }
        else {
            this.element.setDirection(Direction.RIGHT);
        }
    }

    private void goUp() throws Exception{

        IElement up = element.getMine().getElements()[element.getPosition().getX()][element.getPosition().getY()-1];

        if(up.getClass() == model.Back).class){
            this.element.getComportment().moveUp();
        } else if (up.equals(Boulder.getInstance())){
            this.element.getComportment().moveUp();
            Boulder.getInstance().explosion();
        }
        else {
            this.element.setDirection(Direction.LEFT);
        }
    }
}
