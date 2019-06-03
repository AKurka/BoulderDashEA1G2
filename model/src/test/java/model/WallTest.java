package model;

import contract.model.Position;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * <h1>The class test WallTest</h1>
 * @author groupe2
 */
public class WallTest extends ElementTest{

    /**
     * Instatiate a new dirt
     * @throws Exception
     */
    @Override
    @Before
    public void setUp() throws Exception {
        this.actual = new Wall(new Position(1,1,10,10), this.map);
        this.comportment = new Static(actual);
    }
}