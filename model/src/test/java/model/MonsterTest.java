package model;

import contract.model.Position;
import org.junit.Before;

import static org.junit.Assert.*;
/**
 * <h1>The class test MonsterTest</h1>
 * @author groupe2 */
public class MonsterTest extends ElementTest{

    /**
     * Instantiate a new Monster
     * @throws Exception
     */
    @Override
    @Before
    public void setUp() throws Exception {
        this.actual = new Dirt(new Position(1,1,10,10), this.map);
        this.comportment = new Static(actual);
    }
}