package model;

import contract.model.Position;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class DiamondTest extends ElementTest{

    @Override
    @Before
    public void setUp() throws Exception {
        this.actual = new Diamond(new Position(1,1,10,10), this.map);
    }


}