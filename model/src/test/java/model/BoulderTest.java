package model;

import contract.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <h1>The class test BoulderTest</h1>
 * @author groupe2
 */
public class BoulderTest extends ElementTest{

    /**
     * Instantiate the Hero
     */
    @Override
    @Before
    public void setUp() throws Exception {
        this.actual = Boulder.getInstance(new Position(1,1,10,10), this.map);
        this.actual.getPosition().setX(1);
        this.actual.getPosition().setY(1);
        this.comportment = new Controlled(actual);
    }

    /**
     * Check the single instantiation of the hero
     * @throws Exception
     * 		Exception in case of position out of range
     */
    @Test
    public void getInstance() throws Exception{
        Element expected = Boulder.getInstance(new Position(5,3,10,10), this.map);

        assertEquals(expected,this.actual);
    }
}