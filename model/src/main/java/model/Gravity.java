package model;

import contract.model.IElement;

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

    }
}
