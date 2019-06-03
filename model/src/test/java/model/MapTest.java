package model;

import contract.model.IElement;
import contract.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <h1>The class test MapTest</h1>
 * @author groupe2 */
public class MapTest {

    /** The map that contain the list of elements to test*/
    private Map map;

    /**
     * Instantiate a new mMine before each test
     * @throws Exception
     * 		Exception if the build of the mine failed
     */
    @Before
    public void setUp() throws Exception {
        this.map = new Map(new Model());
    }

    /**
     * Check if it's possible to set an element in the elements list
     * @throws Exception
     * 		Exception in case of out of range position
     */
    @Test
    public void setElement() throws Exception{
        IElement element = new Rock(new Position(1,1,10,10), this.map);
        this.map.setElement(1, 1, element);
        assertEquals(element,this.map.getElements()[1][1]);
    }

    /**
     * Check if it's possible to destroy an element in the elements list
     * @throws Exception
     * 		Exception in case of out of range position
     */
    @Test
    public void destroyElement() throws Exception{
        this.map.destroyElement(this.map.getElements()[5][5]);
        assertEquals(model.Background.class, this.map.getElements()[5][5].getClass());
    }
    /**
     * Check if it's possible to add an element in the elements list
     * @throws Exception
     * 		Exception in case of out of range position
     */
    @Test
    public void addMonster() throws Exception{
        IElement element = new Monster(new Position(1,1,10,10), this.map);
        this.map.addMonster(element);
        assertEquals(element,this.map.getMonster().get(this.map.getMonster().size()-1));
    }

    /**
     * Check if it's possible to add an element in the gravity elements list
     * @throws Exception
     * 		Exception in case of out of range position
     */
    @Test
    public void addGravity() throws Exception{
        IElement element = new Rock(new Position(1,1,10,10), this.map);
        this.map.addGravity(element);
        assertEquals(element,this.map.getGravity().get(this.map.getGravity().size()-1));
    }

    /**
     * Check if it's possible to get the hero from the elements list
     */
    @Test
    public void getHero() {
        Boulder boulder = Boulder.getInstance();
        assertEquals(boulder, this.map.getBoulder());
    }
}