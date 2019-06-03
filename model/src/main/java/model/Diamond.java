package model;

import contract.model.Position;

/**
 * <h1> Diamond Class</h1>
 * @author Groupe2
 */

public class Diamond extends Element implements Interaction{

    /** Variable who will use for seek sprite **/
    private final static String IMAGE = "diamond";


    /**
     * Constructor of Diamond
     * @param position
     *      Find diamond position
     *  @param map
     *      Get the actual map
     */
    public Diamond(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Gravity(this);
    }

    /**
     * @see Interaction
     * @param boulder
     *      Get the hero element
     * @throws Exception
     *      Destroy element exception
     */

    @Override
    public void get(Boulder boulder) throws Exception{
        boulder.setDiamonds(boulder.getDiamonds()+1);
        this.getMap().destroyElement(this);
    }

    /**
     * @see Interaction
     * @param element
     *      Get element able to be kill
     */

    @Override
    public void kill(Element element) {
        element = null;
    }

}
