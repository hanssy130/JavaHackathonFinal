package FinalProject;

import org.junit.*;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test for TimelineGraphic
 *
 * @author Gan Ma Gang
 * @version 2020
 */
public class testArrow {

    /**
     * Test object.
     */
    private Arrow test;

    /**
     * @throws Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        test = null;
    }

    @Test
    public void testTimelineGraphic() throws Exception {
        test = new Arrow();
        String compare = test.getClass().getName();
        assertEquals(compare, "FinalProject.Arrow");
    }
}
