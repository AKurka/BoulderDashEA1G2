package model;

import contract.model.IElement;
import contract.model.Position;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class ComportmentTest {

    protected IElement element;

    protected static Map map;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        map = new Map(new Model());
    }

    @Before
    public void setUp() throws Exception {}

}