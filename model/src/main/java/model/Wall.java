package model;

import contract.model.Position;

/**
 * <h1>The Class Wall</h1>
 *
 * @author Groupe2
 */

public class Wall extends Element {

    /** Variable who will use for seek sprite **/
    private static final String IMAGE = "wall";

    /**
     * Instantiate a new wall
     * @param position
     *      the position of the wall
     * @param map
     *      the actual map
     */
    public Wall(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Static(this);
    }
}
