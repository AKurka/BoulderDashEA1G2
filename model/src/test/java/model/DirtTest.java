package model;

import contract.model.Position;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * <h1>The class test DirtTest</h1>
 * @author groupe2 */
 public class DirtTest extends ElementTest{
    /**
     * Instantiate a new Dirt
     */
    @Override
    @Before
    public void setUp() throws Exception {
        this.actual = new Dirt(new Position(1,1,10,10), this.map);
        this.comportment = new Static(actual);
    }
}