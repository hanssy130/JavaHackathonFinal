package FinalProject;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test for TimelineGraphic
 *
 * @author Gan Ma Gang
 * @version 2020
 */
public class TestArrow {

    /**
     * Test object.
     */
    private Arrow test;

    @Test
    public void testTimelineGraphic() throws Exception {
        test = new Arrow();
        String compare = test.getClass().getName();
        assertEquals(compare, "FinalProject.Arrow");
    }
}
