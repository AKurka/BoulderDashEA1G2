package model;

import contract.model.IComportment;
import contract.model.Position;
/**
 * <h1>The Class Comportment</h1>
 * @author Groupe2
 */
public class Comportment implements IComportment {

    /** The element */
    Element element;

    /** Instantiate a new move's comportment*/
    public Comportment(Element element){
        this.element = element;
    }


    /**
     * @see IComportment
     * @throws Exception
     * 		Comportment exception
     */
    @Override
    public void move() throws Exception {
    }


    /**
     * @see IComportment
     * @throws Exception
     * 		Comportment exception
     */
    @Override
    synchronized public void moveRight() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setX(x+1);
        this.element.getMap().getElements()[x+1][y] = this.element;
        this.element.getMap().getElements()[x][y] = new Background(new Position(x,y,Map.WIDTH, Map.HEIGHT),this.element.getMap());

        this.element.getMap().getModel().effectiveChanged();
    }

    /**
     * @see IComportment
     * @throws Exception
     * 		Comportment exception
     */
    @Override
    synchronized public void moveLeft() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setX(x-1);
        this.element.getMap().getElements()[x-1][y] = this.element;
        this.element.getMap().getElements()[x][y] = new Background(new Position(x,y,Map.WIDTH, Map.HEIGHT),this.element.getMap());


        this.element.getMap().getModel().effectiveChanged();
    }

    /**
     * @see IComportment
     * @throws Exception
     * 		Comportment exception
     */
    @Override
    synchronized public void moveUp() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setY(y-1);
        this.element.getMap().getElements()[x][y-1] = this.element;
        this.element.getMap().getElements()[x][y] = new Background(new Position(x,y,Map.WIDTH, Map.HEIGHT),this.element.getMap());


        this.element.getMap().getModel().effectiveChanged();
    }


    /**
     * @see IComportment
     * @throws Exception
     * 		Comportment exception
     */
    @Override
    synchronized public void moveDown() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setY(y+1);
        this.element.getMap().getElements()[x][y+1] = this.element;
        this.element.getMap().getElements()[x][y] = new Background(new Position(x,y,Map.WIDTH, Map.HEIGHT),this.element.getMap());


        this.element.getMap().getModel().effectiveChanged();
    }


    /**
     * @see IComportment
     * @throws Exception
     * 		Comportment exception
     */
    @Override
    public void moveAll() throws Exception {

    }

    /**
     * @see IComportment
     * @throws Exception
     * 		Comportment exception
     */

    @Override
    public void gravit1() throws Exception {

    }
}
