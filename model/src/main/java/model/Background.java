package model;

import contract.model.Position;

/**
 * <h1>Background Classr</h1>
 * @author Groupe2
 */

public class Background extends Element {

    /** Variable who will use for seek sprite **/
    private final static String IMAGE = "background";

    public Background(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Static(this);

    }
}
