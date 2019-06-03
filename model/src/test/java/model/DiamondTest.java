package model;

import contract.model.Position;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * <h1>The class test DiamondsTest</h1>
 * @author groupe2 */

public class DiamondTest extends ElementTest{

    /**
     * Instantiate a new Diamond
     */
    @Override
    @Before
    public void setUp() throws Exception {
        this.actual = new Diamond(new Position(1,1,10,10), this.map);
    }


}