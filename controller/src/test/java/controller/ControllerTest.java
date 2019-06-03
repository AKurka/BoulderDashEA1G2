package controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <h1>The class test ControllerTest</h1>
 * @author groupe2
 */
public class ControllerTest {

    //The controller to test
    private Controller controller;

    /**
     * Instantiate a new controller before each test
     * @throws Exception
     * 		Exception in case of build mine failed
     */
    @Before
    public void setUp() throws Exception {
        this.controller = new Controller();
    }

    /**
     * Test if we can't end the game in case of diamondCounter is inferior to 10
     * @throws Exception
     *      excepted number of diamond
     */
    @Test
    public void EndTest() throws Exception{
        try{
            this.controller.End(8);
        } catch (final Exception e){
            final String expected = "You need more diamonds";
            assertEquals(expected, e.getMessage());
        }
    }
}