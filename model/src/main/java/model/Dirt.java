package model;

import contract.model.Position;

public class Dirt extends Element {

    private final static String STRING = "dirt";

    public Dirt(Position position, Mine mine){
        super(position, STRING, mine);
        comportment = new Fix(this);
    }
}
