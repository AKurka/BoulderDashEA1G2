package model;

import contract.model.Position;

public class Dirt extends Element {

    private final static String IMAGE = "dirt";

    public Dirt(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Static(this);
    }
}
