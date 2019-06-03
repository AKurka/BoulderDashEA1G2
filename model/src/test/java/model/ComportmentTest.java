package model;

import contract.model.IElement;
import contract.model.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComportmentTest {

    protected IElement element;
    protected static Map map;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        map = new Map(new Model());
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void moveRight() throws Exception{
        this.element.getComportment().moveRight();
        final Position expected = new Position(6,5,10,10);
        assertEquals(expected.getX(),this.element.getPosition().getX());
    }

    @Test
    public void moveLeft() throws Exception{
        this.element.getComportment().moveLeft();
        final Position expected = new Position(4,5,10,10);
        assertEquals(expected.getX(),this.element.getPosition().getX());
    }

    @Test
    public void moveUp() throws Exception{
        this.element.getComportment().moveUp();
        final Position expected = new Position(5,4,10,10);
        assertEquals(expected.getY(),this.element.getPosition().getY());
    }

    @Test
    public void moveDown() throws Exception{
        this.element.getComportment().moveDown();
        final Position expected = new Position(5,6,10,10);
        assertEquals(expected.getY(),this.element.getPosition().getY());
    }


}