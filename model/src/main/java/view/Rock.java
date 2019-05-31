package view;

import contract.model.Position;

public class Rock extends Element{

    private static final String IMAGE ="rock";

    public Rock(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Gravity(this);
    }
}
