package model;

import contract.model.Position;

public class Background extends Element {

    private final static String IMAGE = "background";

    public Background(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Static(this);

    }
}
