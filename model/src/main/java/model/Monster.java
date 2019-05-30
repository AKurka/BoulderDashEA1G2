package model;

import contract.model.Direction;
import contract.model.Position;

public class Monster extends Element {

    private static String spriteType = "monster";
    static Mine mine;

    public Monster(Position position, Mine mine){
        super(position, setSpriteTypeAlea(), mine);
        Monster.mine = mine;
        comportment = new Automatic(this);
        direction = Direction.LEFT;
    }

    private static String setSpriteTypeAlea(){
        int alea = (int) (Math.random()*4);
    }
}
