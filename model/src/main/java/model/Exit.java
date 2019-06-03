package model;

import contract.model.Position;

/**
 * <h1>The Class Exit</h1>
 *
 * @author Groupe2
 */

public class Exit extends Element{

    /** Variable who will use for seek sprite **/
    private final static String IMAGE = "exit";

    /** create DP singleton */
    private static Exit exit;

    /**
     * constructor of exit
     * @param position
     *      the position of the gate
     * @param map
     *      the actual map
     */
    private Exit(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Static(this);
    }

    /**
     * Get the exit instance
     * @param position
     *      get the Exit Gate position
     * @param map
     *      Get the actual mine
     * @return exit
     */
    public static Exit getInstance(Position position, Map map){
        if(exit == null){
            exit = new Exit(position, map);
        }
        return exit;
    }
}
