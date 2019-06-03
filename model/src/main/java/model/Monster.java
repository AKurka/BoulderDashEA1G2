package model;

import contract.model.Direction;
import contract.model.Position;

public class Monster extends Element{

    private static String IMAGE = "monster";

    static Map map;

    public Monster(Position position, Map map){
        super(position, IMAGE, map);
        Monster.map = map;
        comportment = new IA(this);
        direction = Direction.LEFT;
    }

    public String getImageName(){
        return IMAGE;
    }

    public void setImageName(String IMAGE){
        Monster.IMAGE = IMAGE;
    }
}
