package model;

import contract.model.Position;

public class Background extends Element {

    private final static String NAME = "background";

    public Background(Position position, Map map){
        super(position, NAME, map);
        comportment = new Fix(this);

    }
}
