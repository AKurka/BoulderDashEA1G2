package model;

import contract.model.Position;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * <h1>The class test ExitTest</h1>
 * @author groupe2 */
public class GravityTest extends ComportmentTest{

    /**
     * Instantiate a Stone before each test
     * @throws Exception
     */


    @Override
    @Before
    public void setUp() throws Exception {
        this.element = new Rock(new Position(5,5,10,10), map);
    }
}