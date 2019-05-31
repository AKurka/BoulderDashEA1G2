package model;

import contract.model.Position;

public class Wall extends Element {
    private final static String STRING = "wall";

    public Wall(Position positon, Mine mine){
        super(positon, STRING, mine);
        comportment = new Fix(this);
    }
}
