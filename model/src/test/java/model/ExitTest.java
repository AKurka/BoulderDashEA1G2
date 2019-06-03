package model;

import contract.model.Position;
import org.junit.Before;

import static org.junit.Assert.*;
/**
 * <h1>The class test ExitTest</h1>
 * @author groupe2 */
public class ExitTest extends ElementTest{

    /**
     * Instantiate the Exit
     * @throws Exception
     */
    @Override
    @Before
    public void setUp() throws Exception {
        this.actual = Exit.getInstance(new Position(1,1,10,10),this.map);
        this.actual.getPosition().setX(1);
        this.actual.getPosition().setY(1);
        this.comportment = new Static(actual);
    }
}