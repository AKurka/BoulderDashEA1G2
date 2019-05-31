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

        switch(alea){
            case 0:
                return "enemy";
            case 1:
                return "enemy";
            case 2:
                return "enemy";
            case 3:
                return "enemy";
            default:
                return "enemy";
        }
    }

    public String getSpriteType() {
        return spriteType;
    }

    public void setSpriteType(String spriteType) {
        Monster.spriteType = spriteType;
    }
}
