package model;

import contract.model.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ElementTest {

    protected Element actual;
    protected Comportment comportment;
    protected Map map;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getPosition() throws Exception{

        assertNotNull(this.actual.getPosition());
        Position expected = new Position(1,1,10,10);

        assertEquals(expected.getX(), this.actual.getPosition().getX());
        assertEquals(expected.getY(), this.actual.getPosition().getY());
    }

    @Test
    public void setPosition() throws Exception{

        Position expected = new Position(2,3,10,10);

        this.actual.setPosition(new Position(2,3,10,10));

        assertEquals(expected.getX(), this.actual.getPosition().getX());
        assertEquals(expected.getY(), this.actual.getPosition().getY());
        assertEquals(expected.getXMax(), this.actual.getPosition().getXMax());
        assertEquals(expected.getYMax(), this.actual.getPosition().getYMax());
    }

    @Test
    public void getImage() {
        assertNotNull(this.actual.getComportment().getClass());
    }

    @Test
    public void getComportment() {

       assertNotNull(this.actual.getComportment());
       assertEquals(comportment.getClass(), this.actual.getComportment().getClass());
    }
}