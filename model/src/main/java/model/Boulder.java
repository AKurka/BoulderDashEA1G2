package model;

import contract.model.Direction;
import contract.model.IDestroy;
import contract.model.Position;

/**
 * <h1>The Class Element</h1>
 *
 * @author Groupe2
 */

public class Boulder extends Element implements IDestroy {


    /** The sprite of the boulder */
    private static String IMAGE = "up";

    /** The boulder */
    private static Boulder boulder;

    /** The number of diamonds of the hero */
    private int diamonds;

    /** The boulder's direction */
    private Direction direction;


    /**
     * Instantiate a new Boulder
     * @param position
     * @param map
     */
    private Boulder(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Controlled(this);
    }

    /**
     * method use for create an instance of boulder
     * @param position
     * 		The position to set
     * @param map
     * 		The map to set
     * @return return a new boulder
     */
    static public Boulder getInstance(Position position, Map map){
        if(boulder == null){
            boulder = new Boulder(position, map);
        }
        return boulder;
    }

    /**
     * Get the instance of the boulder
     * @return the boulder
     */
    static public Boulder getInstance(){
        return boulder;
    }

    /**
     * return diamonds if collision
     * @return diamonds
     */
    public int getDiamonds(){
        return diamonds;
    }

    /**
     * setDiamond on the map
     * @param diamonds
     * 		The number of diamond to set
     */
    public void setDiamonds(int diamonds){
        this.diamonds = diamonds;
    }


    /**
     * get the direction who come from the action of the player
     * @return direction
     */
    public Direction getDirection(){
        return direction;
    }


    /**
     * with the direction get before, set the direction of the hero
     * @param direction
     * 		The direction to set
     */
    public void setDirection(Direction direction){
        this.direction = direction;
    }

    /**
     * @throws Exception
     * 		The exception
     * @see IDestroy
     */
    @Override
    public void destroy() throws Exception {
        this.getMap().destroyElement(Boulder.boulder);
        this.getMap().getModel().setGame(false);
        Boulder.boulder = null;
    }
}
