package model;

import contract.model.Direction;
import contract.model.IElement;

import java.util.Iterator;

/**
 * <h1>The Class IA</h1>
 *
 * @author Groupe2
 */

public class IA extends Comportment {

    /**
     * Instantiate a new IA move
     * @param element
     * 		element to IA
     */
    public IA(Element element){
        super(element);
    }

    /**
     * @see Comportment
     */
    @Override
    public void moveAll() throws Exception{
        Iterator<IElement> iterator = this.element.getMap().getMonster().iterator();
        while (iterator.hasNext()) {
            iterator.next().getComportment().move();
        }
    }

    /**
     * @see Comportment
     */
    @Override
    synchronized public void move() throws Exception{
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

    /**
     * Check and if it's possible move to the left
     * @throws Exception
     * 		comportement Exception
     */
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

    /**
     * Check and if it's possible move to the right
     * @throws Exception
     * 		position exception
     */
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
            this.element.setDirection(Direction.DOWN);
        }
    }


    /**
     * Check and if it's possible move to the up
     * @throws Exception
     * 		position exception
     */
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

    /**
     * Check and if it's possible move to the down
     * @throws Exception
     * 		position exception
     */

    private void goDown() throws Exception{

        IElement up = element.getMap().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];

        if(up.getClass() == Background.class){
            this.element.getComportment().moveDown();
        }
        else if(up.equals(Boulder.getInstance())){
            this.element.getComportment().moveDown();
            //Boulder.getInstance().destroy();
        }
        else{
            this.element.setDirection(Direction.RIGHT);
        }
    }
}
