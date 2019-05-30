package model;

import contract.model.IComportmentMove;
import contract.model.Position;

public class ComportmentMove implements IComportmentMove {

    Element element;

    ComportmentMove(Element element){
        this.element = element;
    }

    @Override
    public void move() throws Exception{

    }

    @Override
    synchronized public void moveRight() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setX(x+1);
        this.element.getMine().getElements()[x+1][y] = this.element;
        this.element.getMine().getElements()[x][y] = new Back(new Position(x, y, Mine.WIDTH, Mine.HEIGHT), this.element.getMine());

        this.element.getMine().getModel().effectiveChanged();
    }

    @Override
    synchronized public void moveLeft() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setX(x-1);
        this.element.getMine().getElements()[x-1][y] = this.element;
        this.element.getMine().getElements()[x][y] = new Back(new Position(x,y,Mine.WIDTH, Mine.HEIGHT),this.element.getMine());

        this.element.getMine().getModel().effectiveChanged();
    }

    @Override
    synchronized public void moveUp() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setY(y-1);
        this.element.getMine().getElements()[x][y-1] = this.element;
        this.element.getMine().getElements()[x][y] = new Back(new Position(x,y,Mine.WIDTH, Mine.HEIGHT),this.element.getMine());

        this.element.getMine().getModel().effectiveChanged();
    }

    @Override
    synchronized public void moveDown() throws Exception{

        int x = this.element.getPosition().getX();
        int y = this.element.getPosition().getY();

        this.element.getPosition().setY(y+1);
        this.element.getMine().getElements()[x][y+1] = this.element;
        this.element.getMine().getElements()[x][y] = new Back(new Position(x,y,Mine.WIDTH, Mine.HEIGHT),this.element.getMine());

        this.element.getMine().getModel().effectiveChanged();
    }

    @Override
    public void moveAll() throws Exception{

    }

    @Override
    public void Gravit() throws Exception{

    }

}
