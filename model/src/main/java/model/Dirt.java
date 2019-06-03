package model;

import contract.model.Position;

/**
 * <h1> Class Dirt</h1>
 * @author Groupe2
 */

public class Dirt extends Element {

    /** Variable who will use for seek sprite **/
    private final static String IMAGE = "dirt";

    /**
     * Instantiate a new dirt
     * @param position
     * 		The position to set the new dirt
     * @param map
     * 		The mine where set the new dirt
     */
    public Dirt(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Static(this);
    }
}
