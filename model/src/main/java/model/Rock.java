package model;

import contract.model.Position;

/**
 * <h1>The class Rock</h1>
 *
 * @author Groupe2
 */

public class Rock extends Element{

    /** Variable who will use for seek sprite **/
    private static final String IMAGE ="rock";

    /**
     * Instantiate a new rock
     * @param position
     * 		The position to set the new rock
     * @param map
     * 		The map where set the new rock
     */
    public Rock(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Gravity(this);
    }
}
