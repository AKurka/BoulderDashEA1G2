package model;

import contract.model.IComportment;
import contract.model.Position;

public class Comportment implements IComportment {

    Element element;

    public Comportment(Element element){
        this.element = element;
    }

    @Override
    public void move() throws Exception {

    }

    @Override
    synchronized public void moveRight() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setX(x+1);
        this.element.getMap().getElements()[x+1][y] = this.element;
        this.element.getMap().getElements()[x][y] = new Background(new Position(x,y,Map.WIDTH, Map.HEIGHT),this.element.getMap());

        this.element.getMap().getModel().effectiveChanged();
    }

    @Override
    synchronized public void moveLeft() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setX(x-1);
        this.element.getMap().getElements()[x-1][y] = this.element;
        this.element.getMap().getElements()[x][y] = new Background(new Position(x,y,Map.WIDTH, Map.HEIGHT),this.element.getMap());


        this.element.getMap().getModel().effectiveChanged();
    }

    @Override
    synchronized public void moveUp() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setY(y-1);
        this.element.getMap().getElements()[x][y-1] = this.element;
        this.element.getMap().getElements()[x][y] = new Background(new Position(x,y,Map.WIDTH, Map.HEIGHT),this.element.getMap());


        this.element.getMap().getModel().effectiveChanged();
    }

    @Override
    synchronized public void moveDown() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setY(y+1);
        this.element.getMap().getElements()[x][y+1] = this.element;
        this.element.getMap().getElements()[x][y] = new Background(new Position(x,y,Map.WIDTH, Map.HEIGHT),this.element.getMap());


        this.element.getMap().getModel().effectiveChanged();
    }

    @Override
    public void moveAll() throws Exception {

    }

    @Override
    public void gravit1() throws Exception {

    }
}
