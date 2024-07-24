import org.avisfy.tasks.SumStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumStringsTest {
    @Test
    public void test1() {
        assertEquals("579", SumStrings.sumStrings("123", "456"));
    }
    @Test
    public void testBig() {
        assertEquals("5673864335857551998", SumStrings.sumStrings("208826580220108780", "5465037755637443218"));
    }
}
