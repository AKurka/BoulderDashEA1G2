package model;

import contract.model.Position;

public class Rock extends Element{
    private final static String STRING = "rock";

    public Rock(Position position, Mine mine){
        super(position, STRING, mine);
        comportment = new Gravity(this);
    }
}
