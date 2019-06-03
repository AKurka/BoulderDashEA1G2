package model;

import contract.model.IElement;
import contract.model.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <h1>The class test ComportmentTest</h1>
 * @author groupe2
 */public class ComportmentTest {

    /** The tested element */
    protected IElement element;
    /** The mine of the tested element */
    protected static Map map;

    /**
     * Instantiate a new Mine to realize move test
     * @throws Exception
     * 		Failed to build the mine
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        map = new Map(new Model());
    }

    /**
     * Instantiate an element before each test
     * @throws Exception
     * 	The exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test the move right
     * @throws Exception
     * 		Exception if the position is out of range
     */
    @Test
    public void moveRight() throws Exception{
        this.element.getComportment().moveRight();
        final Position expected = new Position(6,5,10,10);
        assertEquals(expected.getX(),this.element.getPosition().getX());
    }

    /**
     * Test the move left
     * @throws Exception
     * 		Exception if the position is out of range
     */
    @Test
    public void moveLeft() throws Exception{
        this.element.getComportment().moveLeft();
        final Position expected = new Position(4,5,10,10);
        assertEquals(expected.getX(),this.element.getPosition().getX());
    }

    /**
     * Test the move up
     * @throws Exception
     * 		Exception if the position is out of range
     */
    @Test
    public void moveUp() throws Exception{
        this.element.getComportment().moveUp();
        final Position expected = new Position(5,4,10,10);
        assertEquals(expected.getY(),this.element.getPosition().getY());
    }

    /**
     * Test the move down
     * @throws Exception
     * 		Exception if the position is out of range
     */
    @Test
    public void moveDown() throws Exception{
        this.element.getComportment().moveDown();
        final Position expected = new Position(5,6,10,10);
        assertEquals(expected.getY(),this.element.getPosition().getY());
    }


}