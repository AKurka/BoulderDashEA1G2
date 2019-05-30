package model;

import contract.model.Position;

public class Back extends Element{

    private final static String STRING = "back";

    public Back(Position position, Mine mine){
        super(position, STRING, mine);
        comportment = new Fix(this);
    }
}
