package model;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;
/**
 * <h1>The class test ComportmentTest</h1>
 * @author groupe2 */
public class ControlledTest extends ComportmentTest{

    /**
     * Instantiate a new Hero
     */
    @Override
    @Before
    public void setUp() throws Exception {
        this.element = Boulder.getInstance();
        this.element.getPosition().setX(5);
        this.element.getPosition().setY(5);
    }

}