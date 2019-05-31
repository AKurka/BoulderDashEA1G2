package view;

import contract.model.Position;

public class Wall extends Element {

    private static final String IMAGE = "wall";

    public Wall(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Static(this);
    }
}
