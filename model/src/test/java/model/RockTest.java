package model;

import contract.model.Position;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * <h1>The class test RockTest</h1>
 * @author groupe2
 */
public class RockTest extends ElementTest{

    /**
     * Instatiates a new rock
     * @throws Exception
     */
    @Override
    @Before
    public void setUp() throws Exception {
        this.actual = new Rock(new Position(1,1,10,10), this.map);
        this.comportment = new Gravity(actual);
    }
}