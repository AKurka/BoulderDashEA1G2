package model;

import contract.model.Direction;
import contract.model.Position;

/**
 * <h1>The class Monster</h1>
 *
 * @author Groupe2
 */

public class Monster extends Element{

    /** Variable who will use for seek sprite **/
    private static String IMAGE = "monster";

    /** The map of the enemy */
    static Map map;

    /**
     * Instantiate a new Monster
     * @param position
     * 		The position to set
     * @param map
     * 		The map to set
     */
    public Monster(Position position, Map map){
        super(position, IMAGE, map);
        Monster.map = map;
        comportment = new IA(this);
        direction = Direction.LEFT;
    }

    /**
     * Get the name of the sprite
     * @return
     */
    public String getImageName(){
        return IMAGE;
    }

    /**
     * Set the name of the sprite
     * @param IMAGE
     */
    public void setImageName(String IMAGE){
        Monster.IMAGE = IMAGE;
    }
}
