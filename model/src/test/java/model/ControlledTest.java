package model;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class ControlledTest extends ComportmentTest{

    @Override
    @Before
    public void setUp() throws Exception {
        this.element = Boulder.getInstance();
        this.element.getPosition().setX(5);
        this.element.getPosition().setY(5);
    }

    @After
    public void tearDown() throws Exception {
    }
}