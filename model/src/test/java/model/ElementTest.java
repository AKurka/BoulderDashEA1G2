package model;

import contract.model.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * <h1>The class test ElementTest</h1>
 * @author groupe2 */
public class ElementTest {

    /** The tested Element */
    protected Element actual;
    /** The behaviour of the tested Element */
    protected Comportment comportment;
    /** The map of the tested element */
    protected Map map;

    /**
     * Execute before each test
     * @throws Exception
     * 		Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Check if the element has a move behaviour and the good one
     */
    @Test
    public void getPosition() throws Exception{

        assertNotNull(this.actual.getPosition());
        Position expected = new Position(1,1,10,10);

        assertEquals(expected.getX(), this.actual.getPosition().getX());
        assertEquals(expected.getY(), this.actual.getPosition().getY());
    }

    /**
     * Check if the element has a position
     * @throws Exception
     * 		The exception
     */
    @Test
    public void setPosition() throws Exception{

        Position expected = new Position(2,3,10,10);

        this.actual.setPosition(new Position(2,3,10,10));

        assertEquals(expected.getX(), this.actual.getPosition().getX());
        assertEquals(expected.getY(), this.actual.getPosition().getY());
        assertEquals(expected.getXMax(), this.actual.getPosition().getXMax());
        assertEquals(expected.getYMax(), this.actual.getPosition().getYMax());
    }

    /**
     * Check if the setter position work correctly
     * 		The exception
     */
    @Test
    public void getImage() {
        assertNotNull(this.actual.getComportment().getClass());
    }

    /**
     * Check if the element has a image
     */
    @Test
    public void getComportment() {

       assertNotNull(this.actual.getComportment());
       assertEquals(comportment.getClass(), this.actual.getComportment().getClass());
    }
}